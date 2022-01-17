public class Piece extends ChessPiece {
	
	/*
	 * Constructor that helps is in place of an empty space
	 */
	public Piece() {
		chessPiece = "---";
	}

	public String toString() {
		return chessPiece;
	}
	
}