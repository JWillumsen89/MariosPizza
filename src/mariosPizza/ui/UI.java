package mariosPizza.ui;

import mariosPizza.DataContext.DataContext;
import mariosPizza.DataContext.pizzaOrders.OrderNotFoundException;
import java.util.Scanner;

public class UI {
    private final String fReset = "\u001B[0m";
    private final String green = "\u001B[32m";
    private final String blue = "\u001B[34m";
    private final String yellow = "\u001B[33m";
    private final String red = "\u001B[31m";
    private final String defColor = "\u001B[39m";
    private final String blinkingCSI = "\u001B[6m";
    private final Scanner in = new Scanner(System.in);
    private final DataContext dataContext;
    private final PrintOrderMenu printOrderMenu = new PrintOrderMenu();
    private final PrintPizzaMenu printPizzaMenu = new PrintPizzaMenu();
    private final PrintMenuOperations printMenu = new PrintMenuOperations();
    private final PrintBlankScreen printBlankScreen = new PrintBlankScreen();

    public UI(DataContext dataContext) {
        this.dataContext = dataContext;
    }

    public void printMenu() {
        printMenu.print();
    }

    public void welcomeMessage() {
        printBlankScreen.print();
        System.out.println("""
              __  __            _             _____ _              _               \s
             |  \\/  |          (_)           |  __ (_)            | |              \s
             | \\  / | __ _ _ __ _  ___  ___  | |__) | __________ _| |__   __ _ _ __\s
             | |\\/| |/ _` | '__| |/ _ \\/ __| |  ___/ |_  /_  / _` | '_ \\ / _` | '__|
             | |  | | (_| | |  | | (_) \\__ \\ | |   | |/ / / / (_| | |_) | (_| | |  \s
             |_|  |_|\\__,_|_|  |_|\\___/|___/ |_|   |_/___/___\\__,_|_.__/ \\__,_|_|  \s
                                                                                   \s
                                                                                  \s
               ____          _           _                _____           _                \s
              / __ \\        | |         (_)              / ____|         | |               \s
             | |  | |_ __ __| | ___ _ __ _ _ __   __ _  | (___  _   _ ___| |_ ___ _ __ ___ \s
             | |  | | '__/ _` |/ _ \\ '__| | '_ \\ / _` |  \\___ \\| | | / __| __/ _ \\ '_ ` _ \\\s
             | |__| | | | (_| |  __/ |  | | | | | (_| |  ____) | |_| \\__ \\ ||  __/ | | | | |
              \\____/|_|  \\__,_|\\___|_|  |_|_| |_|\\__, | |_____/ \\__, |___/\\__\\___|_| |_| |_|
                                                  __/ |          __/ |                     \s
                                                 |___/          |___/                      \s
            """);
    }

    public void createNewOrder() {
        System.out.print("Pick a pizza from menu: ");
        var input = in.nextLine();
        int pizzaIndex;
        try {
            pizzaIndex = Integer.parseInt(input);
        } catch (NumberFormatException e){
            clearScreen();
            printBadInput();
            return;
        }
        System.out.print("How many minutes in the making: ");
        int duration = in.nextInt();
        dataContext.createOrder(pizzaIndex, duration);
        printOrders();
    }

    public void printPizzaMenu() {
        var pizzas = dataContext.getPizzas();
        printPizzaMenu.print(pizzas);
    }

   public void removeOrder() {
       var numberOfOrders = dataContext.getPendingOrders().size();
       if(numberOfOrders<= 0){
           printBlankScreen();
           return;
       }
        printOrders();
        System.out.println(" ");
        System.out.print(red+"Remove order: "+fReset);
        int orderID = in.nextInt();
        dataContext.removeOrder(orderID);
   }

    public void markAsFinished(){
        var numberOfOrders = dataContext.getPendingOrders().size();
        if(numberOfOrders<= 0){
            printOrders();
            return;
        }
        printOrders();
        System.out.println(" ");
        System.out.print(red+"Mark as finished: "+fReset);
        int orderID = in.nextInt();
        try {
            dataContext.finishOrder(orderID);
        } catch (OrderNotFoundException e) {}
        printBlankScreen();
    }

    public void clearScreen(){
        System.out.print("\33[2J\33[2H");
        printBlankScreen();
        System.out.flush();
    }

    public void disableScroll(){
        System.out.print("\33[3J");
    }

    public void printOrders() {
        var orders = dataContext.getPendingOrders();
        printOrderMenu.print(orders);
    }

    public void printExitMessage() {
        System.out.println(red+"See you!"+fReset);
    }

    public void printBadInput(){
        System.out.println(red+blinkingCSI+"                                                         ----Wrong input----                " + fReset);
    }

    public void printBlankScreen(){
        printBlankScreen.print();
    }
}
