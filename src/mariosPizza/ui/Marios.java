package mariosPizza.ui;

import mariosPizza.application.Application;

import java.util.Scanner;

public class Marios {

    private boolean programRunning = true;
    private Scanner in = new Scanner(System.in);
    Application app = new Application();
    UI ui = new UI(this);

    public void run() {
        while(programRunning) {
            ui.helpMenu();
            userDecision();
        }
    }

    public void userDecision() {
        System.out.print("\nWhat do you want to do: ");
        int decision = in.nextInt();
        System.out.println();
        switch (decision) {
            case 1 -> {
                //pz.menuCard();
                ui.createNewOrder();
            }
            case 2 -> ui.printOrders();

        }
    }
}
