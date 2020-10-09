import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author aparece1241
 */
public class App {
    Scanner input = new Scanner(System.in);
    static ArrayList<CardCatalog> catalog_cards = new ArrayList<>();

    /**
     * This will display the
     * menu
     */
    public void displayMenu() {
        System.out.print("Libray Card Catalog System\n" +
                "1.Add Card Catalog\n" +
                "2.Edit Card Catalog\n" +
                "3.Remove Card Catalog\n" +
                "4.View Card Catalog\n" +
                "5.Exit\n" +
                "6.Generate fake values (for dev only!)\n");
    }

    /**
     * Generates fake values
     * Used only for developing process
     *
     */
    public void generateValues() {
        System.out.print("How many?: ");
        int size = input.nextInt();
        if(size < 0){
            System.out.println("Invalid size!");
            return;
        }
        for(int ctr = 0; ctr < size;ctr++){
            CardCatalog card = new CardCatalog();
            card.setCardId(Integer.toString(ctr));
            card.setBookTitle(String.format("Book Title %d",ctr));
            card.setBookAuthor(String.format("Book Author %d",ctr));
            card.setYearPublished(String.format("Year Published %d",ctr));
            card.setPublisher(String.format("Publisher %d",ctr));

            catalog_cards.add(card);
        }

        System.out.println("\n Successfully create "+size+" fake values!\n");
    }

    /**
     *
     * This function will search a card
     *
     * @param cardId
     * @return CardCatalog
     */

    public CardCatalog searchCard(String cardId){
        CardCatalog returnCard = new CardCatalog();
        returnCard.setCardId("unknown");
        for (CardCatalog card: catalog_cards) {
            if(cardId.equals(card.getCardId())) {
                returnCard = card;
                break;
            }
        }
        return returnCard;
    }


    /**
     * This will get the users
     * input as a choice
     * @return String
     */
    public String choice() {
        return input.nextLine();
    }

    /**
     * This function will edit
     * the attributes of the card catalog
     */
    public void editCard() {
        if(catalog_cards.isEmpty()) {
            System.out.println("There is no Card Catalogues listed!");
            return;
        }
        System.out.print("Enter Card Catalog Id: ");
        String cardId = choice();
        CardCatalog returnedCard = searchCard(cardId);
        //check if it returned a valid card
        if("unknown".equals(returnedCard.getCardId())){
            System.out.printf("\nThe id %s doesn't exist!", cardId);//displays the id that doesn't exists
        }else {
            String [][] keys = {
                    {"Card id(current value: %s): ",returnedCard.getCardId()},
                    {"Book Title(current value: %s): ",returnedCard.getBookTitle()},
                    {"Book Author(current value: %s): ",returnedCard.getBookAuthor()},
                    {"Year Published(current value: %s): ",returnedCard.getYearPublished()},
                    {"Publisher(current value: %s): ",returnedCard.getPublisher()}
            };
            String [] datas = new String[5];
            for (int index = 0;index < keys.length;index++) {
                System.out.printf(keys[index][0],keys[index][1]);
                String value = input.nextLine();
                datas[index] = (value.isEmpty())? keys[index][1]: value;
            }
            returnedCard.setCardId(datas[0]);
            returnedCard.setBookTitle(datas[1]);
            returnedCard.setBookAuthor(datas[2]);
            returnedCard.setYearPublished(datas[3]);
            returnedCard.setPublisher(datas[4]);
            catalog_cards.set(catalog_cards.indexOf(returnedCard),returnedCard);
            System.out.println("\n Updated successfully!\n");
        }

        System.out.println("\n Command run successfully\n");
    }

    /**
     * This function will remove the catalog card
     */
    public void removeCatalog() {
        if(catalog_cards.isEmpty()) {
            System.out.println("There is no Card Catalogues listed!");
            return;
        }
        System.out.print("Enter Card Catalog Id: ");
        String cardId = choice();
        CardCatalog returnedCard = searchCard(cardId);
        if("unknown".equals(returnedCard.getCardId())){
            System.out.printf("\nThe id %s doesn't exist!", cardId);//displays the id that doesn't exists
        }else {
            catalog_cards.remove(returnedCard);
            System.out.println("\n Card successfully removed!\n");
            System.out.println("\n Command successfully run!\n");

        }

    }

    /**
     * This will display the card catalog information
     * the user must choose either view all or view one
     */
    public void viewCatalog() {
        if(catalog_cards.isEmpty()) {
            System.out.println("There is no Card Catalogues listed!");
            return;
        }
        System.out.print("Would you like to:\n1. Search?\n2.View All?\nEnter Choice: ");

        switch (choice()) {
            case "1":
            case "search":
                System.out.print("Enter Card Catalog Id: ");
                String cardId = choice();
                CardCatalog returnedCard = searchCard(cardId);

                System.out.println(("unknown".equals(returnedCard.getCardId()))?String.format("\nThe " +
                                "id %s doesn't exist!", cardId):String.format("\n\nCard id: %s " +
                                "\nBook title: %s\nBook author: %s\nYear Published: %s\nPublisher:" +
                                " %s\n", returnedCard.getCardId(), returnedCard.getBookTitle(), returnedCard.getBookAuthor(),
                                returnedCard.getYearPublished(), returnedCard.getPublisher()));
                break;
            case "2":
            case "all":
                Collections.shuffle(catalog_cards);
                Collections.sort(catalog_cards);
                for ( CardCatalog card: catalog_cards) {
                    System.out.printf("\nCard id: %s \nBook title: %s\n" +
                            "Book author: %s\nYear Published: %s\nPublisher: %s\n",
                            card.getCardId(),card.getBookTitle(),card.getBookAuthor(),
                            card.getYearPublished(),card.getPublisher());
                }
                break;
            default:
                System.out.println("Invalid Choice!");
        }
        System.out.println("\n Command successfully executes\n");

    }

    /**
     * This function will add a catalog card
     */

    public void addCatalog() {
        CardCatalog card = new CardCatalog();
        System.out.print("Card id: ");
        card.setCardId(input.nextLine());
        System.out.print("Book Title: ");
        card.setBookTitle(input.nextLine());
        System.out.print("Book Author: ");
        card.setBookAuthor(input.nextLine());
        System.out.print("yearPublished: ");
        card.setYearPublished(input.nextLine());
        System.out.print("Publisher: ");
        card.setPublisher(input.nextLine());

        catalog_cards.add(card);
        System.out.println("\nSuccessfully added!\n");
    }


}
