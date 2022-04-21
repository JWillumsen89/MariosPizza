package mariosPizza.ui;

import mariosPizza.DataContext.DataContext;
import java.util.Scanner;

public class UI {
    Scanner in = new Scanner(System.in);
    private final DataContext dataContext;
    PrintOrderMenu printOrderMenu = new PrintOrderMenu();
    PrintPizzaMenu printPizzaMenu = new PrintPizzaMenu();

    public UI(DataContext dataContext) {
        this.dataContext = dataContext;
    }

    public void helpMenu() {
        System.out.println("""
                
        [1] Create new order
        [2] Print list of orders
        [3] Change order status
        [4] Show menu card
        [5] Cancel order
        [6] Exit program""");
    }

    public void welcomeMessage() {
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
        System.out.println(" ");
        System.out.print("Pick a pizza: ");
        int pizzaIndex = in.nextInt();
        System.out.print("How many minutes to pick up: ");
        int duration = in.nextInt();
        dataContext.createOrder(pizzaIndex, duration);
    }

    public void printPizzaMenu() {
        var pizzas = dataContext.getPizzas();
        printPizzaMenu.print(pizzas);
    }

   public void removeOrder() {
        printOrders();
        System.out.println(" ");
        System.out.print("Remove order: ");
        int orderID = in.nextInt();
        dataContext.removeOrder(orderID);
    }

    public void printOrders() {
        var orders = dataContext.getPendingOrders();
        printOrderMenu.print(orders);
    }

    public void shuttingDown() {
        System.out.println("PROGRAM SHUTTING DOWN!");
    }
}
