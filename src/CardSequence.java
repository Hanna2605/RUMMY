import java.util.ArrayList;
import java.util.Objects;

public class CardSequence extends CardGroup {
    public CardSequence() {
    }

    public boolean hasMinimumCount() {
        int n = 3;
        if (this.cards.size() >= n) {
            return true;
        }
        return false;
    }

    public boolean areAllSameSuit() {
        if (this.cards.size() < 3 || this.cards.size() > 4) {
            return false;
        }
        // Compare the suit of the first card with the other cards
        String firstSuit = this.cards.get(0).getSuit();  // Get the suit of the first card
        for (int i = 1; i < this.cards.size(); i++) {
            // If any card has a different suit, return false
            if (Objects.equals(firstSuit, this.cards.get(i).getSuit())) {
                return false;
            }
        }
        // Compare the suit of the first card with the other cards
        String firstRank = this.cards.get(0).getSuit();  // Get the suit of the first card
        for (int i = 1; i < this.cards.size(); i++) {
            // If any card has a different suit, return false
            if (!Objects.equals(firstRank, this.cards.get(i).getRank())) {
                return false;
            }
        }
        // If all suits are the same, return true
        return true;
    }
}
