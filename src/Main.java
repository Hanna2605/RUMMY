import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // I'm creating a deck from 2*52 cards and shuffle it randomly
        CardDeck deck = new CardDeck();
        deck.populateFullDeck();
        deck.shuffle();
        String[] suits = {"h", "d", "c", "s"};
        String[] ranks = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};

        // Create playerOne
        CardGroup playerOne = new CardGroup();

        // Number of cards to deal to playerOne, if the game will be with 2 players
        int n = 10;

        // n random cards from cardDeck to playerA
        for (int i = 0; i < n; i++) {
            Card dealtCard = deck.removeCard();
            if (dealtCard != null) {
                playerOne.addCard(dealtCard);
            }
        }

        // Display the cards in playerA's hand
        System.out.println("PlayerA, your cards are: ");
        for (int i = 0; i < playerOne.getSize(); i++) {
            Card rummycard = playerOne.getCards().get(i);
            System.out.print(rummycard.getRank() + ":" + rummycard.getSuit() + "; ");
        }
        System.out.println();

        // Create a scanner to read input from user
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Waiting for your command... (type:" +
                    " 'deal'= to get three more cards," +
                    " 'put' = lay off on the table your valid set of cards" +
                    " 'end' to quit)");

            System.out.print("Enter command: ");
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            if (input.equals("deal")) {
                for (int i = 0; i < 3; i++) {
                    Card dealtCard = deck.removeCard();
                    if (dealtCard != null) {
                        playerOne.addCard(dealtCard);
                    }
                }
                System.out.println("PlayerA, your cards are NOW: ");
                for (int i = 0; i < playerOne.getSize(); i++) {
                    Card rummycard = playerOne.getCards().get(i);
                    System.out.print(rummycard.getRank() + ":" + rummycard.getSuit() + "; ");
                }
                System.out.println();
            }
            if (input.equals("put")) {
                System.out.println("Put your cards for checking... (type in format: " +
                        "card0rank:card0suit card1rank:card1suite... " +
                        "{any other cards delimited by space} ");

                System.out.print("Enter command: ");
                //delete not needed spaces from user at the beginning and in the end of the input
                String inputCard = scanner.nextLine().trim();

                // create an Arraylist for adding cards from user's input
                CardGroup setCards = new CardGroup();

                // Split the input into individual card representations
                String[] cardStrings = inputCard.split(" ");

                // For each card string
                for (int i = 0; i < cardStrings.length; i++) {
                    // Split into rank and suit
                    String cardStr = cardStrings[i];
                    // Split into rank and suit
                    String[] parts = cardStr.split(":");

                    if (parts.length == 2) {
                        String rankCard = parts[0];
                        String suitCard = parts[1];

                        for (int m = 0; m < ranks.length; m++){
                            if(ranks[m].equals(rankCard)){
                                if(suits[m].equals(suitCard)){
                                    // Add the card to the set
                                    setCards.addCard(new Card(rankCard, suitCard)); // Assuming Card has a constructor (String rank, String suit)
                                }
                            }
                        }
                    }
                    else {
                        System.out.println("Invalid card format: " + cardStr);
                        break;
                    }
                    // I bring to the same type the array of cards initially dealt to Player One
                    CardGroup playerOneCards = new CardGroup();
                    for (int a = 0; a < playerOne.getSize(); a++) {
                        String cardPOneRank = playerOne.getCards().get(a).getRank();
                        String cardPOneSuit = playerOne.getCards().get(a).getSuit();
                        playerOneCards.addCard(new Card(cardPOneRank, cardPOneSuit));
                    }

                    for (int m = 0; m < setCards.getSize(); m++) {
                        Card cardInput = setCards.getCards().get(m);
                        for (int k = 0; k < playerOne.getSize(); k++) {
                            Card cardPlayerOne = playerOne.getCards().get(k);
                            if (!cardInput.equals(cardPlayerOne)) {
                                System.out.println("You don't have such card to choose");
                                break;
                            }
                        }

                    }
                }
            }
        }
    }
}
