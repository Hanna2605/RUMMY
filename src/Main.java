

public class Main {
    public static void main(String[] args) {
        // I need to understand how many players will be
        // I need to shuffle the deck and give cards to the players
        // cardDeck (cardDeck must be populated with full set of cards)
        CardDeck deck = new CardDeck();
        deck.populateFullDeck();
        deck.shuffle();

        Card card1 = new Card("Hearts", "5");
        Card card2 = new Card("Diamonds", "5");
        Card card3 = new Card("Spades", "5");
        Card card4 = new Card("Clubs", "5");
        //Card card5 = new Card("Clubs", "5");
        CardSequence sequence = new CardSequence();
        sequence.addCard(card1);
        sequence.addCard(card2);
        sequence.addCard(card3);
        sequence.addCard(card4);
        //sequence.addCard(card5);

        // Test areAllSameRank
        System.out.println("Are all cards the same rank? " + sequence.areAllSameRank());


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
            // System.out.println(card);
        }
        // Display the cards in playerA's hand
        System.out.println("\nCards in playerA's hand:");
        for (Card card : playerA.getCards()) {
            //System.out.println(card);
        }

        // Create a new CardGroup
        CardSequence group = new CardSequence();

        // Add cards in order (should return true)
        group.addCard(new Card("Hearts", "2"));
        group.addCard(new Card("Hearts", "3"));
        group.addCard(new Card("Hearts", "4"));

        // Test if the cards are in order
        System.out.println("Test 1 (should be true): " + group.areAllInOrder());

        // Add another card to test out of order case (should return false)
        group.addCard(new Card("Hearts", "6"));
        System.out.println("Test 2 (should be false): " + group.areAllInOrder());

        // Create a new sequence that's not in order (should return false)
        CardSequence group2 = new CardSequence();
        group2.addCard(new Card("Diamonds", "5"));
        group2.addCard(new Card("Diamonds", "3"));
        group2.addCard(new Card("Diamonds", "4"));

        // Test if the cards are in order
        System.out.println("Test 3 (should be false): " + group2.areAllInOrder());

        // Test case 1: Valid sequence with same suit
        CardSequence sequence1 = new CardSequence();
        sequence1.addCard(new Card("Hearts", "2"));
        sequence1.addCard(new Card("Hearts", "3"));
        sequence1.addCard(new Card("Hearts", "4"));
        System.out.println("Test 1 (same suit, valid): " + sequence1.isValid()); // Should be true

        // Test case 2: Valid sequence in order
        CardSequence sequence2 = new CardSequence();
        sequence2.addCard(new Card("Diamonds", "5"));
        sequence2.addCard(new Card("Diamonds", "6"));
        sequence2.addCard(new Card("Diamonds", "7"));
        System.out.println("Test 2 (in order, valid): " + sequence2.isValid()); // Should be true

        // Test case 3: Invalid sequence (not enough cards)
        CardSequence sequence3 = new CardSequence();
        sequence3.addCard(new Card("Clubs", "8"));
        System.out.println("Test 3 (not enough cards, invalid): " + sequence3.isValid()); // Should be false

        // Test case 4: Invalid sequence (not same suit or in order)
        CardSequence sequence4 = new CardSequence();
        sequence4.addCard(new Card("Spades", "9"));
        sequence4.addCard(new Card("Hearts", "10"));
        sequence4.addCard(new Card("Diamonds", "11"));
        System.out.println("Test 4 (mixed suit, invalid): " + sequence4.isValid()); // Should be false

        // Test case 5: Valid sequence with more cards (same suit)
        CardSequence sequence5 = new CardSequence();
        sequence5.addCard(new Card("Clubs", "Jack"));
        sequence5.addCard(new Card("Clubs", "Queen"));
        sequence5.addCard(new Card("Clubs", "King"));
        sequence5.addCard(new Card("Clubs", "Ace"));
        System.out.println("Test 5 (same suit, valid): " + sequence5.isValid()); // Should be true

        // Test case 6: Valid sequence with more cards (in order)
        CardSequence sequence6 = new CardSequence();
        sequence6.addCard(new Card("Hearts", "10"));
        sequence6.addCard(new Card("Hearts", "Jack"));
        sequence6.addCard(new Card("Hearts", "Queen"));
        sequence6.addCard(new Card("Hearts", "King"));
        System.out.println("Test 6 (in order, valid): " + sequence6.isValid()); // Should be true
    }
}



