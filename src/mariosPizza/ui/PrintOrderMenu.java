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
    private List<String> toStrings(List<Order> orders){
        var strings = new ArrayList<String>();
        for (var i = 0;i <orders.size();i++){
            var order = orders.get(i);
            var orderID = order.getOrderID();
            var formatter = DateTimeFormatter.ofPattern("HH:mm");
            var orderTime = order.getEstimated().format(formatter);
            var pizzaIndex = order.getPizzaIndex();
            newLine();
            lineSpace();
            System.out.println(green+"\nPENDING ORDERS\n"+fReset+"---------------------------------------");
            var str = String.format("(%d) Pizza: %-15d  ETA: %s\n\n",
                    orderID,pizzaIndex,orderTime);
            strings.add(str);

        }
        return strings;
    }
    private void newLine() {
        System.out.println();

    }

    public void print(List<Order> orders){
        if(orders.isEmpty()){
            lineSpace();
            System.out.println(red+"                                 -----------------No pending orders at the moment!------------------\n"+fReset);
            return;
        }
        var strings = toStrings(orders);
        for (var str : strings)
            System.out.println(str);
    }
    public void lineSpace() {
        LineSpacing lines = new LineSpacing();
        lines.lines();
    }
}
