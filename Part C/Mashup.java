import java.util.*;

/**
 * Mashup class that plays the game Mashup-Tic-Tac-Toe
 * @author: Jack Boccuzzi
 * @version: 1.0
 */

public class Mashup {

	public static void printRules() {
		System.out.println();
		System.out.println("      WELCOME TO TIC-TAC-TOE MASHUP!");
		System.out.println();
		System.out.println("This game is played on a 4 x 4 board.");
        System.out.println("Player 1 is going to be HEARTS: \u2661" + ".");
        System.out.println("Player 2 is going to be DIAMONDS: \u2662" + ".");
        System.out.println("Each player will take turns placing their suit");
        System.out.println("to a specific coordinate on the board.");
        System.out.println();
        System.out.println("The first player to get 4 of their suits");
        System.out.println("in a row (in any direction) wins!");
        System.out.println();
        System.out.println("If all 12 spaces are full but and no one has,");
        System.out.println("four in a row, the game will be a draw.");
        System.out.println();
	}

	public static int checkWin(SquareBoard board, Token piece) {
		int matchCount = 0;
		int leftToRightCount = 0;
		int rightToLeftCount = 0;

		// check if user matches horizonal pieces
		for (int row = 0; row < board.getLength(); row++) // index over row first then column
		{ 
			for (int col = 0; col < board.getLength() - 1; col++) 
			{
				if (piece.match(board.getPiece(row,col))) // does current piece on board == the player's piece
				{ 
					if (board.getPiece(row,col).match(board.getPiece(row,col + 1))) // checks if the current piece == piece next to it by increasing column index
					{
						matchCount++;
					}
					else 
					{
						matchCount = 0;
					}
				}
				if (matchCount == board.getLength() - 1) 
				{
					return 1;
				}		
			}
			matchCount = 0; // to reset the counter after checking an entire column
		}

		// check if the user matches vertical pieces 
		for (int col = 0; col < board.getLength(); col++) // index over column first then row
		{ 
			for (int row = 0; row < board.getLength() - 1; row++) 
			{ 
				if (piece.match(board.getPiece(row,col))) // does currrent piece on board == player piece
				{ 
					if (board.getPiece(row,col).match(board.getPiece(row + 1, col))) // checks to see if the current piece, matches the piece below it by increasing row index
					{ 
						matchCount++;
					}
					else 
					{
						matchCount = 0;
					}
				}
				if (matchCount == board.getLength() - 1) 
				{
					return 1;
				}
			}
			matchCount = 0; // to reset counter after checking each row
		}

		// check diag L to R 
		for (int i = 0; i < board.getLength()-1; i++) {
			if (piece.match(board.getPiece(i,i))) { // if player piece == [0,0] to start
				if (board.getPiece(i,i).match(board.getPiece(i + 1, i + 1))) {
					leftToRightCount++;
					if (leftToRightCount == board.getLength()-1) {
						return 1;
					}
				}
				else {
					leftToRightCount = 0;
				}
			}
		}

		// check diag R to L
		for (int i = 0; i < board.getLength()-1; i++) {
			if (piece.match(board.getPiece(3 - i, i))) { // if player piece == [3,0] to start
				if (board.getPiece((board.getLength() - 1) - i, i).match(board.getPiece((board.getLength() - 2) - i, i + 1))) { // check piece up and to right
					rightToLeftCount++;
					if (rightToLeftCount == board.getLength()-1) {
						return 1;
					}
				}
				else {
					rightToLeftCount = 0;
				}
			}
		}

		// check for tie
		int spaceCount = 0;
		for (int i = 0; i < board.getLength(); i++) 
		{
			for (int j = 0; j < board.getLength(); j++)
			{
				if (!(board.getPiece(i,j).match( new Card() )) ) // if current piece is empty
				{
					spaceCount++;
				}
			}
		}
		if (spaceCount == 16) 
		{
			return 0;
		}

		return -1;
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();

		printRules(); // print game rules

		System.out.println("Player 1 Enter your name:");
    	String playerOneName = scan.nextLine();
    	MashupPlayer playerOne = new MashupPlayer(playerOneName); // create player1 object

    	System.out.println("Player 2 Enter your name:");
    	String playerTwoName = scan.nextLine();
    	MashupPlayer playerTwo = new MashupPlayer(playerTwoName); // create player2 object
    	System.out.println();

    	char playAgain = 'y';
    	while (playAgain != 'n') {

    		// re-initialize decks so they play with a "reset" deck
    		playerOne.setPlayerPiece(new Deck(Card.Suit.HEARTS)); // player1 is HEARTS
    		playerOne.getPlayerPiece().shuffle(); // shuffle cards 
    		playerTwo.setPlayerPiece(new Deck(Card.Suit.DIAMONDS)); // player2 is DIAMONDS
    		playerTwo.getPlayerPiece().shuffle(); // shuffle cards

    		SquareBoard board = new SquareBoard(4, new Card()); // now playing with cards

    		System.out.println("Here are the board's coordinates!");
    		System.out.println();
			board.printBoardCoordinates();

			System.out.println("Here is the starting Board!");
	        System.out.println(board);

	        boolean keepPlaying = true;
	        int count = 0;
	  		String currentPlayer = playerOne.getName();
	  		int win = -1; // false
	        while (keepPlaying == true) { 

	        	if (count % 2 == 0) {
	        		System.out.println("It is Player 1 (" + playerOne.getName() + ")'s' Turn!");
	        		currentPlayer = playerOne.getName();
	        	}
	        	else {
	        		System.out.println("It is Player 2 (" + playerTwo.getName() + ")'s' Turn!");
	        		currentPlayer = playerTwo.getName();
	        	}
	        	count++; 

	        	int coord1 = 0;
	        	int coord2 = 0;
	        	boolean validCoordinate = false;
	        	while (validCoordinate == false) {
	        		System.out.println("Please enter a ROW coordinate");
	        		coord1 = scan.nextInt();
	        		System.out.println("Please enter a COLUMN coordiante");
	        		coord2 = scan.nextInt();

	        		if ( (coord1 >= 0 && coord1 < board.getLength()) && (coord2 >= 0 && coord2 < board.getLength()) ) {
	        			validCoordinate = true;
	        		}
	        		else {
	        			System.out.println("Please enter a ROW/COLUMN coordinate that is on the board!");
	        			System.out.println();
	        		}
	        	}


	        	boolean openSpot; 
	        	if (currentPlayer.equals(playerOne.getName())) { // P1 Turn
	        		Card playerOneCard = playerOne.getPlayerPiece().deal();
	        		openSpot = board.setPiece(playerOneCard, coord1, coord2); // boolean assigned to openSpot 
	        		if (openSpot == true) { 
	        			board.setPiece(playerOneCard, coord1, coord2); // if open, set piece
	        			win = checkWin(board, playerOneCard);
	        			if (win != -1) {
	        				keepPlaying = false;
	        			}
	        			System.out.println();
	        		}
	        		else {
	        			System.out.println("There is already a piece there. Try Again!");
	        			System.out.println();
	        			count--; // if piece exists, decrement count to stay on current player's turn
	        		}
	        	}
	        	else { // P2 Turn
	        		Card playerTwoCard = playerTwo.getPlayerPiece().deal();
	        		openSpot = board.setPiece(playerTwoCard, coord1, coord2); // boolean assigned to openSpot
	        		if (openSpot == true) {
	        			board.setPiece(playerTwoCard, coord1, coord2); // if open, set piece
	        			win = checkWin(board, playerTwoCard);
	        			if (win != -1) {
	        				keepPlaying = false;
	        			}
	        			System.out.println();
	        		}
	        		else {
	        			System.out.println("There is already a piece there. Try Again!");
	        			System.out.println();
	        			count--; // if piece exists, decrement count to stay on current player's turn
	        		}
	        	}

	        	System.out.println("-->THE CURRENT BOARD<--");
	        	System.out.println(board);


	        } // close "keepPlaying" while loop

	        if (win == 1 && currentPlayer == playerOne.getName()) { // p1 wins
        		playerOne.won();
        		System.out.println(playerOne);
        		playerTwo.lost();
        		playAgain = 'n';
        	}
        	if (win == 1 && currentPlayer == playerTwo.getName()) { // p2 wins
        		playerTwo.won();
        		System.out.println(playerTwo);
        		playerOne.lost();
        		playAgain = 'n';
        	}
        	if (win == 0) { // tie game
        		System.out.println("The game ended in a tie!");
        		playerOne.lost();
        		playerTwo.lost();
        		playAgain = 'n';
        	}

        	boolean validInput = false;
        	while (validInput == false) {
				System.out.println("Would you like to play again? [y/n]");
        		playAgain = scan.next().toLowerCase().charAt(0);
        		if (playAgain == 'y' || playAgain == 'n') {
        			validInput = true;
        		}
        		else {
        			System.out.println("Please enter a valid input!");
        			validInput = false;
        		}
        	}


    	} // close "playAgain" while loop


	}

}