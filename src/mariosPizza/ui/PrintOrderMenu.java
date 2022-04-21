package mariosPizza.ui;

import mariosPizza.application.pizzaOrders.Order;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PrintOrderMenu {
    private List<String> toStrings(List<Order> orders){
        var strings = new ArrayList<String>();
        for (var i = 0;i <orders.size();i++){
            var order = orders.get(i);
            var orderID = order.getOrderID();
            var formatter = DateTimeFormatter.ofPattern("HH:mm");
            var orderTime = order.getCreated().format(formatter);
            var pizzaIndex = order.getPizzaIndex();
            var str = String.format("(%d) Pizza: %-15d  ETA: %s",
                    orderID,pizzaIndex,orderTime);
            strings.add(str);
        }
        return strings;
    }

    public void print(List<Order> orders){
        var strings = toStrings(orders);
        for (var str : strings)
            System.out.println(str);
    }
}
