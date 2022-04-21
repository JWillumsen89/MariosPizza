package mariosPizza.ui;

import mariosPizza.application.Application;

import java.util.Scanner;

public class UI {
    Scanner in = new Scanner(System.in);

    public UI() {}

    public void helpMenu() {
        System.out.println("""
                
        [1] Create new order
        [2] Print list of orders
        [3] Change order status
        [4] Show menu card
        [5] Exit program""");

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

    public void createNewOrder(Application app) {

        System.out.println(" ");
        System.out.print("Pick a pizza: ");
        int pizzaIndex = in.nextInt();
        System.out.print("How many minutes to pick up: ");
        int duration = in.nextInt();

        app.createOrder(pizzaIndex, duration);

    }

   /* public void removeOrder() {
        System.out.println(" ");
        System.out.println("Remove order: ");
        //int input = in.nextInt();
    }

    */

    public void printOrders() {

        System.out.println("--------------------------------------------------Order List--------------------------------------------------");

        /*for (int i = 0; i < orderList.size(); i++) {
            System.out.println(orderList.get(i));
        }
         */
    }

    public void shuttingDown() {
        System.out.println("""
            PROGRAM SHUTTING DOWN!
            """);
    }

}
