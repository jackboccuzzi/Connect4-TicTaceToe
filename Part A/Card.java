/**
 * A Card class represents a playing card with a face 
 * value and a suit.
 * @author: Jack Boccuzzi
 * @version: 1.0
 */

public class Card extends Token
{

    /** These are the unicode characters to display the typical suits of a playing card */
    private static final char spades = '\u2660';
    private static final char hearts = '\u2661';
    private static final char diamonds = '\u2662';
    private static final char clubs = '\u2663';

    public static enum Suit {SPADES, HEARTS, DIAMONDS, CLUBS}
    public static enum Face {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}

    private Suit mySuit;
    private Face myFace;

    /** 
     * Constructor that creates an empty Card
     * Instance data should be initialized to null
     */
    public Card() 
    {
        tokenValue = "---"; 
        mySuit = null;
        myFace = null;
    }

    /** 
     * Constructor that initializes all 
     * instance data to proper values.
     */
    public Card(Suit s, Face f)
    {
        tokenValue = "--" + s; // because we want to compare just the suits
        mySuit = s;
        myFace = f;
    }

    // another constructor to test for Mashup.java
    public Card(Suit s) {
        mySuit = s;
        myFace = null;
    }

    /* ADD OTHER METHODS YOU NEED */
    public String getTokenValue() {
        return tokenValue;
    }

    public void setSuit (Suit newSuit) {
    	mySuit = newSuit;
    }

    public Suit getSuit () {
    	return mySuit;
    }

    public void setFace (Face newFace) {
    	myFace = newFace;
    }

    public Face getFace () {
    	return myFace;
    }

    @Override 
    public String toString() {
    	// get the face + ":" + get the suit 

        char suitSymbol = ' '; // placeholder 
        if (mySuit == Suit.SPADES) { 
            suitSymbol = spades;
        }
        else if (mySuit == Suit.HEARTS) {
            suitSymbol = hearts;
        }
        else if (mySuit == Suit.DIAMONDS) {
            suitSymbol = diamonds;
        }
        else if (mySuit == Suit.CLUBS) { 
            suitSymbol = clubs;
        }

        char faceNum = ' ';
        if (myFace == Face.ACE) {
            faceNum = '1';
        }
        else if (myFace == Face.TWO) {
            faceNum = '2';
        }
        else if (myFace == Face.THREE) {
            faceNum = '3';
        }
        else if (myFace == Face.FOUR) {
            faceNum = '4';
        }
        else if (myFace == Face.FIVE) {
            faceNum = '5';
        }
        else if (myFace == Face.SIX) {
            faceNum = '6';
        }
        else if (myFace == Face.SEVEN) {
            faceNum = '7';
        }
        else if (myFace == Face.EIGHT) {
            faceNum = '8';
        }
        else if (myFace == Face.NINE) {
            faceNum = '9';
        }
        else if (myFace == Face.TEN) {
            faceNum = 't';
        }
        else if (myFace == Face.JACK) {
            faceNum = 'J';
        }
        else if (myFace == Face.QUEEN) {
            faceNum = 'Q';
        }
        else if (myFace == Face.KING) {  
            faceNum = 'K';            
        }

		if (suitSymbol == ' ' && faceNum == ' ') {
            return "---";
        }
        else {
            return "" + faceNum + ":" + suitSymbol;
        }

    }
}
