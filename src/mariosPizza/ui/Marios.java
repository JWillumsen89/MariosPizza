package mariosPizza.ui;

import mariosPizza.DataContext.DataContext;
import java.util.Scanner;

public class Marios {
    boolean programRunning = true;
    private final Scanner in = new Scanner(System.in);
    private final DataContext dataContext;
    private final UI ui;

    public Marios() {
        dataContext = new DataContext();
        ui = new UI(dataContext);
    }

    public void run() {
        ui.welcomeMessage();
        ui.printPizzaMenu();
        while(programRunning) {
            ui.helpMenu();
            userDecision();
        }
        ui.shuttingDown();
        dataContext.saveOrders();
    }

    public void userDecision() {
        System.out.print("\nWhat do you want to do: ");
        int decision = in.nextInt();
        System.out.println();
        switch (decision) {
            case 1 -> ui.createNewOrder();
            case 2 -> ui.printOrders();
            case 3 -> System.out.println("Change order status");
            case 4 -> ui.printPizzaMenu();
            case 5 -> ui.removeOrder();
            case 6 -> programRunning = false;
        }
    }
}
