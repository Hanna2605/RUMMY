
public class CardSequence extends CardGroup {

    public boolean hasMinimumCount() {
        int n = 3;
        return this.cards.size() >= n;
    }

    public boolean areAllSameRank() {
        if (this.cards.size() < 3 || this.cards.size() > 4) {
            return false;
        }
        // Compare the rank of the first card with the other cards
        String firstRank = this.cards.get(0).getRank();  // Get the suit of the first card
        for (int i = 1; i < this.cards.size(); i++) {
            if(!firstRank.equals(this.cards.get(i).getRank())) {
                return false;
            }
        }
        return true;
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
        if (this.cards.size() == 3 || this.cards.size() == 4) {
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
        // Check if the card sequence meets the minimum count requirement
        boolean hasMinimumCards = hasMinimumCount();

        // Check if the cards are all of the same suit
        boolean allSameSuit = areAllSameRank();

        // Check if the cards are all in sequential order
        boolean allInOrder = areAllInOrder();

        // The sequence is valid if it has the minimum number of cards
        // and either all cards are the same suit or they are all in order
        return hasMinimumCards && (allSameSuit || allInOrder);
    }
}