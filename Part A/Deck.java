import java.util.*;

/**
 * A Deck class represents a complete deck of Cards
 * @author: Jack Boccuzzi
 * @version: 1.0
 */
public class Deck 
{
    protected ArrayList<Card> deck = new ArrayList<Card>();


    /** Constructor creates a group of 52 cards using the Card's
      * enumerated types of face and suits 
      */
    public Deck()
    {
        for (int i = 0; i < Card.Suit.values().length; i++) { // iterate through an array of Suit values
            for (int j = 0; j < Card.Face.values().length; j++) { // at each Suit value, iterate through the Face values
                Card theCard = new Card(Card.Suit.values()[i], Card.Face.values()[j]); // .values() returns an array of all values that can be indexed
                deck.add(theCard);
            }
        }
    }

     /** Constructor creates a group of 13 cards 
       * that all belong to one suit
       */
    public Deck(Card.Suit s)
    {
        for (int i = 0; i < Card.Face.values().length; i++) {
            Card theCard = new Card(s, Card.Face.values()[i]);
            deck.add(theCard);
        }
    }

    /** 
     * toString method:
     * @overrides toString method to display all 52 cards
     * Print out the Deck of Cards 
     * 13 cards per line please.
     */
    public String toString()
    {
        String deckPrintOut = "";

        for (int i = 0; i < deck.size(); i++) {
            deckPrintOut += deck.get(i) + " ";
            if (i == 12 || i == 25 || i == 38 || i == 51) { // every 13 elements, add new line
                deckPrintOut += "\n";
            }
        }

        return deckPrintOut; 
    }

    /**
     * getCard method:
     * Get a card from the Deck at a specific location
     */
    public Card getCard(int index)
    {
        return deck.get(index);
    }

    /** 
    * shuffle method:
    * Randomizes the order of the stored cards
    * One easy way to shuffle is to loop through the 
    * cards and randomly swap each card with another one.
    */
    public void shuffle()
    {
       /* FIX ME */
        Random rand = new Random();
         
        for (int i = 0; i < deck.size(); i++) {
            // this statement decreases the range of cards to pick from
            // to not have any swaps happen multiple times (i.e switching cards
            // 0 and 51 three different times)
            int randomCard = (rand.nextInt(deck.size() - i) + i);
            Card tempCard = deck.get(randomCard); // get the random card
            deck.set(randomCard, deck.get(i)); // setting current card to random index
            deck.set(i, tempCard); // setting current index with random card
        }

    }

    /**   
     * deal method:
     * removes the top Card from the deck
     */ 
    public Card deal() 
    {
        /* FIX ME */
        Card topCard = deck.get(0); // last card
        deck.remove(0); // remove last card

        return topCard;
    }

    /**
     * getCardCount
     * determines how many cards are left on the deck.
     */ 
    public int getCardCount()
    {
        return deck.size();
    }

}
