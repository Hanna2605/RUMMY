import java.util.ArrayList;
import java.util.HashSet;

public class CardSequence extends CardGroup {

    public CardSequence() {
    }

    public void addCardInOrder(Card card) {
        // If the list is empty, simply add the first card
        if (this.cards.isEmpty()) {
            this.cards.add(card);
            return;
        }

        // Check if the suit matches the suit of the first card
        String firstCardSuit = this.cards.get(0).getSuit();
        if (!card.getSuit().equals(firstCardSuit)) {
            // If the suit doesn't match, don't add the card
            return;
        }

        // Find the correct position to insert the card based on its rank
        for (int i = 0; i < this.cards.size(); i++) {
            // Compare ranks using the getRankAsInt method
            if (getRankAsInt(card.getRank()) < getRankAsInt(this.cards.get(i).getRank())) {
                // Insert the card before the first card with a higher rank
                this.cards.add(i, card);
                return;
            }
        }

        // If no suitable place was found, add the card at the end
        this.cards.add(card);
    }

    public boolean hasMinimumCount() {
        int n = 3;
        return this.cards.size() >= n;
    }

    public boolean areAllSameRank() {
        if (this.cards.size() < 3 || this.cards.size() > 4) {
            return false;
        }

        // Store the rank and suit of the first card
        String firstRank = this.cards.get(0).getRank();
        HashSet<String> uniqueSuits = new HashSet<>();  // Track unique suits

        for (Card card : this.cards) {
            // Check for rank consistency and track unique suits
            if (!firstRank.equals(card.getRank()) || !uniqueSuits.add(card.getSuit())) {
                return false;
            }
        }
        return true; // All cards are the same rank with different suits and no duplicates
    }
        // Helper method to convert card rank to an integer for comparison
        public int getRankAsInt(String rank) {
            switch (rank) {
                case "2": return 2;
                case "3": return 3;
                case "4": return 4;
                case "5": return 5;
                case "6": return 6;
                case "7": return 7;
                case "8": return 8;
                case "9": return 9;
                case "10": return 10;
                case "Jack": return 11;
                case "Queen": return 12;
                case "King": return 13;
                case "Ace": return 14;
                default: return -1; // Invalid rank
            }
        }

    public boolean areAllInOrder() {
        if (this.cards.size() >= 3) {
            for (int i = 0; i < this.cards.size() - 1; i++) {
                int num1 = getRankAsInt(this.cards.get(i).getRank());
                int num2 = getRankAsInt(this.cards.get(i + 1).getRank());
                if (num2 != num1 + 1) {
                    return false;
                }
            }
            // If all pairs are in order, return true
            return true;
        }
        // If the card count is not 3 or 4, return false
        return false;
    }
    public boolean isValid() {
        // Ensure minimum count of cards
        boolean hasMinimumCards = hasMinimumCount();

        // Check for same rank without duplicates
        boolean allSameRank = areAllSameRank();

        // Check for sequential order with suit consistency
        boolean allInOrder = areAllInOrder() && sameSuit();

        // Validate based on minimum cards and either all same rank or in order
        return hasMinimumCards && (allSameRank || allInOrder);
    }

    // Helper to check if all cards are the same suit
    private boolean sameSuit() {
        if (this.cards.isEmpty()) {
            return true;  // No cards, no suit to compare, consider it valid
        }

        String suit = this.cards.get(0).getSuit();
        if (suit == null) {
            return false;  // If the first card's suit is null, return false
        }

        for (Card card : this.cards) {
            // Check if any card has a null suit or a different suit
            if (card == null || card.getSuit() == null || !card.getSuit().equals(suit)) {
                return false;
            }
        }
        return true;
    }
}