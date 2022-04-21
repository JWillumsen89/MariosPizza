package mariosPizza.application.pizzaOrders;

import java.util.ArrayList;
import java.util.List;

public class PizzaOrders {
    private List<Order> orders = new ArrayList<>();

    public List<Order> getPendingOrders(){return orders.stream().filter(o -> o.isPending()).toList();}
    public List<Order> getOrdersInProgress(){return orders.stream().filter(o -> o.isInProgress()).toList();}
    public List<Order> getCompletedOrders(){return orders.stream().filter(o -> o.isDone()).toList();}

    public List<Integer> getPizzaIndexesInProgress(){
        return orders.stream()
                .filter(o -> o.isInProgress())
                .map(o -> o.getPizzaIndex()).toList();
    }

    public Order getOrderByID(int id) throws OrderNotFoundException {
        var order = orders.stream()
                .filter(o -> o.getOrderID() == id)
                .findFirst();
        if(order.isPresent())
            return order.get();
        throw new OrderNotFoundException();
    }

    public void createOrder(int pizzaIndex, int duration){

        var order = new Order(pizzaIndex,duration);
        orders.add(order);
    }
}
