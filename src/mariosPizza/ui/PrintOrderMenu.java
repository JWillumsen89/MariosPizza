package mariosPizza.ui;

import mariosPizza.DataContext.pizzaOrders.Order;

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
            var orderTime = order.getEstimated().format(formatter);
            var pizzaIndex = order.getPizzaIndex();
            var str = String.format("(%d) Pizza: %-15d  ETA: %s",
                    orderID,pizzaIndex,orderTime);
            strings.add(str);
        }
        return strings;
    }

    public void print(List<Order> orders){
        if(orders.isEmpty()){
            System.out.println("No pending orders");
            return;
        }
        var strings = toStrings(orders);
        for (var str : strings)
            System.out.println(str);
    }
}
