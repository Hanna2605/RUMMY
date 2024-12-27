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

                System.out.print("Enter cards: ");
                //delete not needed spaces from user at the beginning and in the end of the input
                String inputCard = scanner.nextLine();

                // create an Arraylist for adding cards from user's input
                CardGroup cardsToPut = new CardGroup();

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

                        if (Card.isValidRankCard(rankCard) && Card.isValidSuitCard(suitCard)) {

                            if (playerOne.hasCard(rankCard, suitCard)) {
                                cardsToPut.addCard(new Card(rankCard, suitCard)); // Assuming Card has a constructor (String rank, String suit)
                                System.out.println("You add card " + rankCard + ":" + suitCard);
                            } else {
                                System.out.println("You don't have card " + rankCard + ":" + suitCard);
                            }
                        }
                        else{
                            System.out.println("Your card format invalid " + rankCard + ":" + suitCard);
                        }
                    } else {
                        System.out.println("Invalid card format: " + cardStr);
                    }
                }
            }
        }
    }
}

