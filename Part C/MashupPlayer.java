/** 
  * Class that represents a MashupPlayer in a game
  * @author: Jack Boccuzzi
  * @version: 1.0
  */
public class MashupPlayer {
    private String name;
    private int wins;
    private int games;
    private Deck piece;

    public MashupPlayer(String name) {
        this.name = name;
        wins = 0;
        games = 0;
        piece = new Deck();

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

    public void setPlayerPiece(Deck playerPiece) {
      piece = playerPiece;
    }

    public Deck getPlayerPiece() {
      return piece;
    }

}