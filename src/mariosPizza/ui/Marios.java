package mariosPizza.ui;

import mariosPizza.application.Application;
import mariosPizza.application.pizzaMenu.BuildPizzaMenu;
import mariosPizza.application.pizzaMenu.Pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Marios {

    public Marios() {
        initPizzaMenu();
    }

    private List<Pizza> pizzas = new ArrayList<>();
    PrintPizzaMenu printer = new PrintPizzaMenu();
    boolean programRunning = true;
    private final Scanner in = new Scanner(System.in);
    Application app = new Application();
    UI ui = new UI();

    private void initPizzaMenu() {
        var builder = new BuildPizzaMenu();
        this.pizzas = builder.build();
    }

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
        var pizzas = app.get_pizzas();
        printer.print(pizzas);
    }

    public void userDecision() {
        System.out.print("\nWhat do you want to do: ");
        int decision = in.nextInt();
        System.out.println();
        switch (decision) {
            case 1 -> {
                printPizzaMenu();
                ui.createNewOrder(app);
            }
            case 2 -> ui.printOrders();
            case 3 -> System.out.println("Change order status");
            case 4 -> printPizzaMenu();
            case 5 -> programRunning = false;
        }
    }
}
