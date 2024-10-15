
public class Card {
    // here I have a class Card which means the structure of the card
    String suit; // e.g., "Hearts", "Spades"
    String rank; // e.g., "2", "3", "King", "Ace"

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }
    public String getSuit() {
        return suit;
    }
    public String getRank() {
        return rank;
    }
    // Display the card as "Rank of Suit"
    @Override
    public String toString() {
        return rank + " of " + suit;
    }

}
