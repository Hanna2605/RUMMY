import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // I need to understand how many players will be
        // I need to shuffle the deck and give cards to the players
        // cardDeck (cardDeck must be populated with full set of cards)
        CardDeck deck = new CardDeck();
        deck.populateFullDeck();
        deck.shuffle();

        // Create playerA
        CardGroup playerA = new CardGroup();

        // Number of cards to deal to playerA, if the game will be with 2 players
        int n = 10;

        // n random cards from cardDeck to playerA
        for (int i = 0; i < n; i++) {
            Card dealtCard = deck.removeCard();
            if (dealtCard != null) {
                playerA.addCard(dealtCard);
            }
        }
        // Display the remaining cards in cardDeck
        System.out.println("Remaining cards in cardDeck: " + deck.getSize());
        for (Card card : deck.getCards()) {
            System.out.println(card);
        }
        // Display the cards in playerA's hand
        System.out.println("\nCards in playerA's hand:");
        for (Card card : playerA.getCards()) {
            System.out.println(card);
        }


    }
}
