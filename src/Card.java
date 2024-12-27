
public class Card {
    // here I have a class Card which means the structure of the card
    String suit; // e.g., "Hearts", "Spades"
    String rank; // e.g., "2", "3", "King", "Ace"
    public static String[] suits = {"h", "d", "c", "s"};
    public static String[] ranks = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};

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

    public static boolean isValidRankCard(String rank) {
        for (int i = 0; i < ranks.length; i++){
            if (ranks[i].equals(rank)){
                return true;
            }
        }
        return false;
    }

    public static boolean isValidSuitCard(String suit) {
        for (int i = 0; i < suits.length; i++){
            if (suit.equals(suits[i])){
                return true;
            }
        }
        return false;
    }
}
