package mariosPizza.DataContext.pizzaOrders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PizzaOrders {
    private List<Order> orders = new ArrayList<>();
    private PersistOrders persist = new PersistOrders();

    public PizzaOrders(){
        try {
            orders = persist.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Order> getPendingOrders()
    {
        return orders.stream().filter(Order::isPending).sorted().toList();
    }
    public List<Order> getOrdersInProgress(){return orders.stream().filter(Order::isInProgress).toList();}
    public List<Order> getCompletedOrders(){return orders.stream().filter(Order::isDone).toList();}

    public List<Integer> getPizzaIndexesInProgress(){
        return orders.stream().filter(Order::isInProgress).map(Order::getPizzaIndex).toList();
    }

    public Order getOrderByID(int id) throws OrderNotFoundException {
        var order = orders.stream().filter(o -> o.getOrderID() == id).findFirst();
        if(order.isPresent())
            return order.get();
        throw new OrderNotFoundException();
    }

    public void createOrder(int pizzaIndex, int duration){
        var order = new Order(pizzaIndex,duration);
        orders.add(order);
    }

    public void removeOrder(int orderID){
        orders.removeIf(g -> g.getOrderID() == orderID);
    }

    public void persist(){
        try {
            persist.save(orders);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
