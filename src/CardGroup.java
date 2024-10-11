import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardGroup {

    public ArrayList<Card> cards;

    public CardGroup() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }
    // Method to remove a card from the group
    public Card removeCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0); // Remove and return the top card
        }
        return null;
    }
    // Method to shuffle the cards
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Method to populate the deck with a full set of 52 cards
    public void populateFullDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public int getSize() {
        return this.cards.size();
    }
}
