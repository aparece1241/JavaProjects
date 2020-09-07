import java.lang.reflect.Array;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        genCards();
        while(true) {
            menu();
            if(processAction(in.nextLine())){
                break;
            }
        }
    }

    /**
     * "This a temporary function"
     * This function will
     * generate the cards through
     * object
     * @return cards
     */

    private static Object[] genCards(){
        int index = 0;
        Object[] cards = new Object[52];
        String [] flowers = {"Spade","Heart","Clove","Diamond"};
        String [] cardsProperties = {"2","3","4","5","6","7","8","9","10","A","J","Q","K"};
        Object card = new Object();
        for (String flower : flowers)
        {
            for (String cardsProperty : cardsProperties) {
                card[flower] = cardsProperty;
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

    private static void menu(){
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
     * @param userAction
     * @return bol
     */

    private static boolean processAction (String userAction)
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
                //call function shuffle cards
                System.out.println("Shuffle");
                end = false;
                break;
            case "3":
            case "display":
                //call the display function
                System.out.println("Display");
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
    private static void displayCards(Object cards){


    }



}
