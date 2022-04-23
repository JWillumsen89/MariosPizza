package mariosPizza.ui;

import mariosPizza.DataContext.pizzaOrders.Order;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PrintOrderMenu {
    public String fReset = "\u001B[0m";
    public String green = "\u001B[32m";
    public String blue = "\u001B[34m";
    public String red = "\u001B[31m";
    private final String blinkingCSI = "\u001B[6m";

    private void printMenuHeader(){
        lineSpace();
        System.out.println(green+"\nPENDING ORDERS\n"+fReset+"---------------------------------------");
    }

    private String formatString(String str, Order order){
        if(order.overdue())
            return red + blinkingCSI + str + fReset;
        else
            return green + str + fReset;
    }

    private List<String> toStrings(List<Order> orders){
        var strings = new ArrayList<String>();
        for (var i = 0;i <orders.size();i++){
            var order = orders.get(i);
            var orderID = order.getOrderID();
            var formatter = DateTimeFormatter.ofPattern("HH:mm");
            var orderTime = order.getEstimated().format(formatter);
            var pizzaIndex = order.getPizzaIndex();
            var str = String.format("(%d) Pizza: %-15d  ETA: %s",
                    orderID,pizzaIndex,orderTime);
            var formatted = formatString(str,order);
            strings.add(formatted);

        }
        return strings;
    }

    private void lineSpace() {
        PrintBlankScreen lines = new PrintBlankScreen();
        lines.print();
    }

    private void printMenu(List<Order> orders){
        printMenuHeader();
        var strings = toStrings(orders);
        for (var str : strings)
            System.out.println(str);
    }

    private void printEmptyMenu(){
        lineSpace();
        System.out.println(red + blinkingCSI +"                                 -----------------No pending orders at the moment!------------------"+fReset);
    }

    public void print(List<Order> orders){
        if(orders.isEmpty())
            printEmptyMenu();
        else
            printMenu(orders);
    }
}
