public class SquareBoard {
    private int size;
    private Token[][] board;

    /**
      * Constructor that creates an n x n board of
      * Tokens and each Token is set to an initial Token
      */ 
    public SquareBoard(int size, Token e) 
    {
        this.size = size;
        board = new Token[size][size];
        for (int i = 0; i < size; i++) {
          for (int j = 0; j < size; j++) {
            board[i][j] = e;
          }
        }
        
    }

   /**
     * String representation of the board 
     * showing the contents of each space 
     */
    public String toString()
    {
      String output = "";

			for (int i=0; i<board.length; i++) 
      {
          for (int j=0; j<board[i].length; j++)
          {
              output += ("["+board[i][j]+"] ");
          }
          output += "\n";
      }
      System.out.println();

      return output;
    }

    /**
      * Method that prints out the board with
      * the coordinates of each slot
      * to show the users how to identify each slot
      */
    public void printBoardCoordinates()
    {
        for (int i=0; i<board.length; i++) 
        {
            for (int j=0; j<board[i].length; j++)
            {
                System.out.print("["+i+","+j+"] ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
      * Sets a Token on the board with coordinates (i,j)
      */
    public boolean setPiece(Token t, int i, int j)
    {
        // board[i][j] = t;

        if (board[i][j].match(new Card())){ // if board has open spot set the piece on the board
          board[i][j] = t;
          return true;
        }
        else if (board[i][j].match(new XOPiece())) {
          board[i][j] = t;
          return true;
        }
        else { // if spot is not open, return false
          return false;
        }
    }

    /**
      * Gets a Token that is on the board with coordinates (i,j)
      */  
    public Token getPiece(int i, int j)
    {
			return board[i][j];
    }

    public int getLength() {
      return board.length;
    }

}

