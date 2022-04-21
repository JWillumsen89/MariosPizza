package mariosPizza.ui;

import mariosPizza.application.Application;

import java.util.Scanner;

public class UI {
    Scanner in = new Scanner(System.in);

    public UI(Marios marios) {
        //this.marios = marios;
    }

    public void helpMenu() {
        System.out.println("""
                
        Use can use the following commands throughout:
                
        [1] Create new order
        [2] Print list of orders
        [3] Change order status
        [4] Show menu card""");

    }

    public void createNewOrder(Application app) {

        System.out.println("");
        System.out.print("Pick a pizza: ");
        int pizzaIndex = in.nextInt();
        System.out.print("How many minutes to pick up: ");
        int duration = in.nextInt();
        //String order = "#" + idNum + " - " + (marios.pz.pizzaList.get(input) + ". PICK UP TIME: 10:35");
        //System.out.println(marios.pz.pizzaList.get(input));
        //orderList.add(order);
        //idNum++;

        app.createOrder(pizzaIndex, duration);

    }

    public void removeOrder() {
        System.out.println("");
        System.out.println("Remove order: ");
        //int input = in.nextInt();
    }

    public void printOrders() {
        /*
        System.out.println("--------------------------------------------------Order List--------------------------------------------------");
        for (int i = 0; i < orderList.size(); i++) {
            System.out.println(orderList.get(i));
        }
         */
    }

}
