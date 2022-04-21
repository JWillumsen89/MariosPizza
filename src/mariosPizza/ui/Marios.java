package mariosPizza.ui;

import mariosPizza.DataContext.DataContext;
import mariosPizza.DataContext.pizzaMenu.Pizza;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Marios {
    private List<Pizza> pizzas = new ArrayList<>();
    PrintPizzaMenu printer = new PrintPizzaMenu();
    boolean programRunning = true;
    private final Scanner in = new Scanner(System.in);
    DataContext dataContext = new DataContext();
    UI ui = new UI();

    public void run() {

        ui.welcomeMessage();
        printPizzaMenu();
        while(programRunning) {
            ui.helpMenu();
            userDecision();
        }
        ui.shuttingDown();
    }

    private void printPizzaMenu() {
        var pizzas = dataContext.get_pizzas();
        printer.print(pizzas);
    }

    public void userDecision() {
        System.out.print("\nWhat do you want to do: ");
        int decision = in.nextInt();
        System.out.println();
        switch (decision) {
            case 1 -> {
                printPizzaMenu();
                ui.createNewOrder(dataContext);
            }
            case 2 -> ui.printOrders();
            case 3 -> System.out.println("Change order status");
            case 4 -> printPizzaMenu();
            case 5 -> programRunning = false;
        }
    }
}
