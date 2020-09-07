import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class DeckOfCards {

    /**
     * "This a temporary function"
     * This function will
     * generate the cards through
     * object
     * @return cards
     */

    protected ArrayList<Card> genCards(){
        String ranks [] = {"2","3","4","5","6",
                          "7","8","9","10","A",
                          "J","Q","K"};
        String suits [] = {"H","D","S","C"};
        ArrayList<Card> cards = new ArrayList<Card>();

        for ( String suit : suits) {
            for( String rank : ranks){
                Card card = new Card(rank,suit);
                cards.add(card);
            }
        }

        return cards;
    }



    /**
     * This function displays the
     * menu
     *
     * @param "none"
     */

    public static void menu(){
        System.out.print("1. Deal\n" +
                "2. Shuffle\n" +
                "3. Display\n" +
                "4. Exit\n" +
                "Please choose an action: ");
    }

    /**
     * process the user action
     * also call the functions
     * regarding the users action
     * @param userAction, cards
     * @return bol
     */

    public static boolean processAction (String userAction, ArrayList<Card> cards )
    {
        boolean end = false;
        userAction = userAction.toLowerCase();
        switch (userAction) {
            case "1":
            case "deal":
                //call function deal
                System.out.println("Deal");
                end = false;
                break;
            case "2":
            case "shuffle":
                //call function shuffle card
                cards = shuffleCards(cards);
                System.out.println("Cards is already shuffle!");
                end = false;
                break;
            case "3":
            case "display":
                //call the display function
                displayCards(cards);
                end = false;
                break;
            case "4":
            case "exit":
                //break the while loop
                System.out.println("Goodbye, Thank you for playing!");
                end = true;
                break;
            default:
                System.out.println("WARNING: Please choose a valid action!");
                end = false;
        }
        return end;
    }

    /**
     * This function will this play the cards
     *
     * @param cards
     */
    private static void displayCards(ArrayList<Card> cards){
        int counter = 0;
        for(int ctr = 0; ctr < cards.size(); ctr++){
            if(counter % 13 == 0)
            {
                System.out.println("");
            }
            System.out.print(cards.get(ctr).getCard()+" ");
            counter++;
        }
        System.out.println("");
    }

    /**
     * This function will shuffle the cards
     *
     * @params cards
     */

    private static ArrayList<Card> shuffleCards(ArrayList<Card> cards )
    {
        Collections.shuffle(cards);
        return cards;
    }


}
