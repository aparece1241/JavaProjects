import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class DeckOfCards {

    Scanner input = new Scanner(System.in);
    protected static ArrayList<Card> cards = new ArrayList<Card>();
    /**
     * This function will create cards
     *
     * @params "none"
     */
    protected void createCards(){
        cards = genCards();
        System.out.println("\n\nCards are already created!\n\n");
    }

    public int getInput(Scanner in){
        return in.nextInt();
    }
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
        System.out.println("Deck of Cards");
        String menu = "[1] Create cards\n" +
                "[2] Shuffle\n" +
                "[3] Display\n" +
                "[4] Deal\n"+
                "[5] Exit\n";


        System.out.print(menu += "Please enter your action: ");
    }

    /**
     * process the user action
     * also call the functions
     * regarding the users action
     * @param userAction
     * @return bol
     */

    public boolean processAction (String userAction )
    {
        boolean end = false;
        userAction = userAction.toLowerCase();
        switch (userAction) {
            case "4":
            case "deal":
                //call function deal
                System.out.println("Deal");
                System.out.print("How many?: ");
                deal(getInput(input));
                end = false;
                break;
            case "2":
            case "shuffle":
                //call function shuffle card
                cards = shuffleCards(cards);
                end = false;
                break;
            case "3":
            case "display":
                //call the display function
                displayCards(cards);
                end = false;
                break;
            case "1":
            case "create":
                //create another deck of cards
                createCards();
                end = false;
                break;
            case "5":
            case "exit":
                //break the while loop
                System.out.println("Goodbye, Thank you for playing!");
                end = true;
                break;
            default:
                System.out.println("\n\nWARNING: Please choose a valid action!\n\n");
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
        if(cards.size() <= 0){
            System.out.println("\n\nWARNING:The Deck of cards is empty!\n\n");
            return;
        }
        int counter = 0;
        for(int ctr = 0; ctr < cards.size(); ctr++){
            if(counter % 13 == 0)
            {
                System.out.println("");
            }
            System.out.print(cards.get(ctr).getCard()+" ");
            counter++;
        }
        System.out.printf("\nThe number of cards: %d\n",cards.size());
    }

    /**
     * This function will shuffle the cards
     *
     * @params cards
     */

    private static ArrayList<Card> shuffleCards(ArrayList<Card> cards )
    {
        if(cards.size() <= 0){
            System.out.println("\n\nWARNING: The Deck of Card is Empty!\n\n");
            return cards;
        }
        Collections.shuffle(cards);
        System.out.println("\n\nCards is already shuffled!\n\n");
        return cards;

    }

    /**
     * This function is responsible for dealing the cards
     * @params dealVal cards
     */

    private static void deal(int dealVal){
        if(dealVal > cards.size()) {
            System.out.println("\n\nWARNING: The amount of deal should not be \ngreater than the number of cards");
            return;
        }
        for(int ctr = 0; ctr < 52; ctr++){
            System.out.print(cards.get(ctr).getCard()+" ");
            cards.remove(cards.get(ctr));
        }
        System.out.println("\n");
    }
}
