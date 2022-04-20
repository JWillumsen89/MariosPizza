package mariosPizza.application;

import mariosPizza.application.pizzaOrders.Order;
import mariosPizza.application.pizzaOrders.OrderNotFoundException;
import mariosPizza.application.pizzaOrders.PizzaOrders;

import java.util.List;

public class Application {
    private PizzaOrders _pizzaOrders = new PizzaOrders();

    public List<Order> getPendingOrders(){
        return _pizzaOrders.getPendingOrders();
    }

    public List<Order> getOrdersInProgress(){
        return _pizzaOrders.getOrdersInProgress();
    }

    public List<Order> getCompletedOrders(){
        return _pizzaOrders.getCompletedOrders();
    }

    public void createOrder(int pizzaIndex, boolean phone){
        _pizzaOrders.createOrder(pizzaIndex,phone);
    }

    public void startOrder(int orderID) throws OrderNotFoundException {
        _pizzaOrders.getOrderByID(orderID).setInProgress();
    }

    public void finishOrder(int orderID) throws OrderNotFoundException {
        _pizzaOrders.getOrderByID(orderID).setFinished();
    }
}
