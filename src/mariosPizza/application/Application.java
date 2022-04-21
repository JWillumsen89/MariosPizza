package mariosPizza.application;

import mariosPizza.application.pizzaMenu.Pizza;
import mariosPizza.application.pizzaMenu.PizzaContext;
import mariosPizza.application.pizzaOrders.Order;
import mariosPizza.application.pizzaOrders.OrderNotFoundException;
import mariosPizza.application.pizzaOrders.PizzaOrders;
import java.util.List;

public class Application {
    private PizzaOrders _pizzaOrders = new PizzaOrders();
    private PizzaContext _pizzaContext = new PizzaContext();

    public List<Pizza> get_pizzas() {
        return _pizzaContext.getPizzas();
    }

    public List<Order> getPendingOrders(){
        return _pizzaOrders.getPendingOrders();
    }

    public List<Order> getOrdersInProgress(){
        return _pizzaOrders.getOrdersInProgress();
    }

    public List<Order> getCompletedOrders(){
        return _pizzaOrders.getCompletedOrders();
    }

    public void createOrder(int pizzaIndex, int duration){
        _pizzaOrders.createOrder(pizzaIndex, duration);
    }

    public void startOrder(int orderID) throws OrderNotFoundException {
        _pizzaOrders.getOrderByID(orderID).setInProgress();
    }

    public void finishOrder(int orderID) throws OrderNotFoundException {
        _pizzaOrders.getOrderByID(orderID).setFinished();
    }

    public List<Pizza> getPizzasInProgress(){
        var indexes = _pizzaOrders.getPizzaIndexesInProgress();
        var pizzas = _pizzaContext.getPizzas(indexes);
        return pizzas;
    }
}
