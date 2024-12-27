import java.util.ArrayList;

public class CardGroup {
    String name;
    public ArrayList<Card> cards;

    public CardGroup() {
        this.cards = new ArrayList<>();
    }
    public CardGroup(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public Card removeCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0); // Remove and return the top card
        }
        return null;
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public int getSize() {
        return this.cards.size();
    }

    public boolean hasCard(String rank, String suit){
        for (int i = 0; i <cards.size(); i++){
            if (cards.get(i).getRank().equals(rank) && cards.get(i).getSuit().equals(suit)){
                return true;
            }
        }
        return false;
    }
}
