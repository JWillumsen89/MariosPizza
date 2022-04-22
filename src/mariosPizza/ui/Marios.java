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
    ui.helpMenu(false);
    while (programRunning) {
      userDecision();
      ui.helpMenu(false);
    }
    ui.shuttingDown();
    dataContext.saveOrders();
  }
  
  public void userDecision() {
    int decision = in.nextInt();
    switch (decision) {
      case 1 -> {
        ui.createNewOrder();
        ui.printOrders();
      }
      case 2 -> ui.printOrders();
      case 3 -> ui.printPizzaMenu();
      case 4 -> {
        ui.removeOrder();
        ui.printOrders();
      }
      case 5 -> System.out.println("Change order status");
      case 6 -> programRunning = false;
    }
  }
}
