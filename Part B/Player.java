/** 
  * Class that represents a Player in a game
  */
public class Player {
    private String name;
    private int wins;
    private int games;
    private XOPiece piece;

    public Player(String name) {
        this.name = name;
        wins = 0;
        games = 0;
        piece = new XOPiece();

    }

    /**
      * Returns the number of times the Player won.
      */
    public int getWins() {
        return this.wins;
    }

    /**
      * Setter method for the Player's name
      */
    public void setName(String name) {
        this.name = name;
    }

    /**
      * Getter method for the Player's name
    */
    public String getName() {
        return name;
    }

    /**
      * Updates the player's total number of games played
      */
    public void lost() {
        games++;
    }

    /**
      * Updates the player's number of wins
      */
    public void won() {
        System.out.println(this.name + " wins!");
        wins++;
        games++;
    }

    /**
      * String representation of a player
      */
    public String toString() {
        return "" + name + ":\t" + "wins: " + wins + "\n\t" + "total games: " + games + "\n";
    }

    public void setPlayerPiece(XOPiece playerPiece) {
      piece = playerPiece;
    }

    public XOPiece getPlayerPiece() {
      return piece;
    }

}
