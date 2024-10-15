import java.util.Collections;

public class CardDeck extends CardGroup {

    public CardDeck() {
        this.name = "Deck";
    }
    // Method to shuffle the cards
    public void shuffle() {
        Collections.shuffle(this.cards);
    }
    // Method to populate the deck with a full set of 52 cards
    public void populateFullDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }
}
