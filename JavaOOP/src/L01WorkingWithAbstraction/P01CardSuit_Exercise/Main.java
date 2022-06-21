package L01WorkingWithAbstraction.P01CardSuit_Exercise;


public class Main {
    public static void main(String[] args) {


        System.out.println("Card Suits:");
        CardSuit[] cardSuits = CardSuit.values();
        for (CardSuit cardSuit : cardSuits) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", cardSuit.ordinal(), cardSuit);
        }
    }
}
