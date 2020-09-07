import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DeckOfCards deckOfCards = new DeckOfCards();
        ArrayList<Card> cards = deckOfCards.genCards();
        while(true) {
            deckOfCards.menu();
            if(deckOfCards.processAction(in.nextLine(),cards)){
                break;
            }
        }
    }
}
