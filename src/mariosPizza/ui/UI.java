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
    private final Scanner in = new Scanner(System.in);
    private final DataContext dataContext;
    private final PrintOrderMenu printOrderMenu = new PrintOrderMenu();
    private final PrintPizzaMenu printPizzaMenu = new PrintPizzaMenu();
    private final PrintMenuOperations printMenu = new PrintMenuOperations();
    private final PrintBlankScreen printBlankScren = new PrintBlankScreen();

    public UI(DataContext dataContext) {
        this.dataContext = dataContext;

    }

    public void printMenu() {
        printMenu.print();
    }

    public void welcomeMessage() {
        printBlankScren.print();
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
        printPizzaMenu();
        System.out.print("Pick a pizza from menu: ");
        int pizzaIndex = in.nextInt();
        System.out.print("How many minutes in the making: ");
        int duration = in.nextInt();
        dataContext.createOrder(pizzaIndex, duration);
    }

    public void printPizzaMenu() {
        printBlank();
        var pizzas = dataContext.getPizzas();
        printPizzaMenu.print(pizzas);
    }

   public void removeOrder() {
        printOrders();
        System.out.println(" ");
        System.out.print(red+"Remove order: \n"+fReset);
        int orderID = in.nextInt();
        dataContext.removeOrder(orderID);
   }

    public void markAsFinished(){
        printOrders();
        System.out.println(" ");
        System.out.print(red+"Mark as finished: \n"+fReset);
        int orderID = in.nextInt();
        try {
            dataContext.finishOrder(orderID);
        } catch (OrderNotFoundException e) {}
    }

    public void clearScreen(){
        System.out.print("\33[2J\33[2H");
        System.out.flush();
    }

    public void disableScroll(){
        System.out.print("\33[3J");
    }

    public void printOrders() {
        var orders = dataContext.getPendingOrders();
        printBlankScren.print();
        printOrderMenu.print(orders);
    }

    public void shuttingDown() {
        System.out.println(red+"PROGRAM SHUTTING DOWN!"+fReset);
    }

    public void printBadInput(){
        printBlankScren.print();
        System.out.println(red+"----Wrong input----\n"+fReset);
    }
}
