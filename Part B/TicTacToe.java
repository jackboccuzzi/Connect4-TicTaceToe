import java.util.*;

public class TicTacToe 
{
	public static void printRules() 
	{
		System.out.println();
		System.out.println("   WELCOME TO TIC-TAC-TOE!");
		System.out.println();
		System.out.println("The game is played on a grid");
		System.out.println("that is 3 squares by 3 squares");
		System.out.println("You are X and your friend is O.");
		System.out.println("You will take turns placing your");
		System.out.println("mark on an empty square.");
		System.out.println();
		System.out.println("The first player to get 3 X's or O's");
		System.out.println("in a row (in any direction) wins!");
		System.out.println();
		System.out.println("If all 9 spaces are full and no one wins,");
		System.out.println("The game ends in a tie.");
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

		for (int i = 0; i < board.getLength() - 1; i++) 
		{
			// starting at top left and bottom left, check if player piece matches either one to check diagonal
			if (piece.match(board.getPiece(i,i)) || piece.match(board.getPiece(2 - i, i))) 
			{
				// checks to see if diagonal down and right matches current piece
				if (board.getPiece(i,i).match(board.getPiece(i + 1, i + 1))) 
				{
					leftToRightCount++;
				}
				else 
				{
					leftToRightCount = 0;
				}
				// checks to see if diagonal up and right matches current piece
				if (board.getPiece((board.getLength() - 1) - i, i).match(board.getPiece((board.getLength() - 2) - i, i + 1)))
				{
					rightToLeftCount++;
				}
				else 
				{
					rightToLeftCount = 0;
				}

			}
			if ( (leftToRightCount == board.getLength() - 1) || (rightToLeftCount == board.getLength() - 1) )
			{
				return 1;
			}

		}

		// check for tie
		int spaceCount = 0;
		for (int i = 0; i < board.getLength(); i++) 
		{
			for (int j = 0; j < board.getLength(); j++)
			{
				if (!(board.getPiece(i,j).match( new XOPiece() )) ) // if current piece is empty
				{
					spaceCount++;
				}
			}
		}
		if (spaceCount == 9) 
		{
			return 0;
		}

		return -1;
	}

    public static void main(String[] args)
    {
    	Scanner scan = new Scanner(System.in);

    	printRules(); //print the rules
    	System.out.println("Player 1 Enter your name:");

    	String playerOneName = scan.nextLine();
    	Player playerOne = new Player(playerOneName); // create player1 object

    	System.out.println("Player 2 Enter your name:");
    	String playerTwoName = scan.nextLine();
    	Player playerTwo = new Player(playerTwoName); // create player2 object
    	System.out.println();

    	playerOne.setPlayerPiece(new XOPiece(XOPiece.XO.X)); // player1 is X
    	playerTwo.setPlayerPiece(new XOPiece(XOPiece.XO.O)); // player2 is O

    	char playAgain = 'y';
    	while (playAgain != 'n') {

    		SquareBoard board = new SquareBoard(3, new XOPiece()); // create the board

	    	System.out.println("Here are the Board's Coordinates!");
	        board.printBoardCoordinates(); // display board coordinates

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
	        		openSpot = board.setPiece(playerOne.getPlayerPiece(), coord1, coord2); // boolean assigned to openSpot 
	        		if (openSpot == true) { 
	        			board.setPiece(playerOne.getPlayerPiece(), coord1, coord2); // if open, set piece
	        			win = checkWin(board, playerOne.getPlayerPiece());
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
	        		openSpot = board.setPiece(playerTwo.getPlayerPiece(), coord1, coord2); // boolean assigned to openSpot
	        		if (openSpot == true) {
	        			board.setPiece(playerTwo.getPlayerPiece(), coord1, coord2); // if open, set piece
	        			win = checkWin(board, playerTwo.getPlayerPiece());
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

	    	} // close inner while loop


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

        	System.out.println("Would you like to play again? [y/n]");
        	playAgain = scan.next().toLowerCase().charAt(0);

    	} // close outer while loop
        
    }

}

