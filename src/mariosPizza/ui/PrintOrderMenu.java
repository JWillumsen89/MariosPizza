package mariosPizza.ui;

import mariosPizza.application.pizzaOrders.Order;

import java.util.ArrayList;
import java.util.List;

public class PrintOrderMenu {
    private List<String> toStrings(List<Order> orders){
        var strings = new ArrayList<String>();
        for (var i = 0;i <orders.size();i++){
            var order = orders.get(i);
            var orderID = order.getOrderID();
            var orderTime = order.getCreated().toString();
            var pizzaIndex = order.getPizzaIndex();
            var str =
                    String.format("Order id: %d - Pizza: %d - Order created: %s",
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
