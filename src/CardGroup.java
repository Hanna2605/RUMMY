import java.util.ArrayList;


public abstract class CardGroup {


    private ArrayList<Card> cards;


    public CardGroup() {
        this.cards = new ArrayList<>();
    }


    public void addCard(Card card) {
        this.cards.add(card);
    }


    public ArrayList<Card> getCards() {
        return this.cards;
    }
}
