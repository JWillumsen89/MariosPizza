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

    private boolean programRunning = true;
    private Scanner in = new Scanner(System.in);
    Application app = new Application();
    UI ui = new UI(this);

    private void initPizzaMenu() {
        var builder = new BuildPizzaMenu();
        this.pizzas = builder.build();
    }

    public void run() {


        while(programRunning) {
            ui.helpMenu();
            userDecision();
        }
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

        }
    }
}
