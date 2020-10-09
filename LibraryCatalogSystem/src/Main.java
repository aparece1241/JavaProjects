/**
 * @author aparece1241
 */
public class Main {
    public static void main(String[] args) {
        App app = new App();

        while (true){
            app.displayMenu();
            System.out.print("Enter Your Choice: ");
            switch (app.choice()) {

                case "1": // case one adds
                case "add":
                    app.addCatalog();
                    break;
                case "2": // case two edit a card
                case "edit":
                    app.editCard();
                    break;
                case "3":// case three removes a card
                case"remove":
                    app.removeCatalog();
                    break;
                case "4":// views all or search the card (sorted order)
                case "view":
                    app.viewCatalog();
                    break;
                case "5": // exits the program
                case "exit":
                    System.out.println("Thank You, Goodbye!");
                    System.exit(1);
                    break;
                case "6": //
                    app.generateValues();
                    break;
                default:// if the choices is not in the given
                    System.out.println("Invalid Choice!");
                    break;
            }
        }
    }
}
