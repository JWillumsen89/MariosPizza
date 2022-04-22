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

  private void shutDown(){
    ui.shuttingDown();
    dataContext.saveOrders();
    System.exit(0);
  }

  public void run() {
    ui.welcomeMessage();
    ui.helpMenu();
    while (true) {
      userDecision();
      ui.helpMenu();
    }
  }
  
  public void userDecision() {
    String decision = in.nextLine();
    switch (decision) {
      case "1" -> {
        ui.createNewOrder();
        ui.printOrders();
      }
      case "2" -> ui.printOrders();
      case "3" -> ui.printPizzaMenu();
      case "4" -> {
        ui.removeOrder();
        ui.printOrders();
      }
      case "5" -> System.out.println("Change order status");
      case "6" -> shutDown();
      default -> {
        ui.lineSpace();
        System.out.println(ui.red+"----Wrong input----\n"+ui.fReset);}
    }
  }
}
