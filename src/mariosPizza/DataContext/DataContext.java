package mariosPizza.DataContext;

import mariosPizza.DataContext.pizzaMenu.Pizza;
import mariosPizza.DataContext.pizzaMenu.PizzaContext;
import mariosPizza.DataContext.pizzaOrders.Order;
import mariosPizza.DataContext.pizzaOrders.OrderNotFoundException;
import mariosPizza.DataContext.pizzaOrders.PizzaOrders;
import java.util.List;

public class DataContext {
    private PizzaOrders _pizzaOrders = new PizzaOrders();
    private PizzaContext _pizzaContext = new PizzaContext();

    public List<Pizza> pizzas() {
        return _pizzaContext.getPizzas();
    }

    public List<Order> pendingOrders(){
        return _pizzaOrders.pendingOrders();
    }

    public List<Order> ordersInProgress(){
        return _pizzaOrders.ordersInProgress();
    }

    public List<Order> completedOrders(){
        return _pizzaOrders.completedOrders();
    }

    public List<Order> orders(){
        return _pizzaOrders.orders();
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

    public List<Pizza> pizzasInProgress(){
        var indexes = _pizzaOrders.getPizzaIndexesInProgress();
        var pizzas = _pizzaContext.getPizzas(indexes);
        return pizzas;
    }

    public void removeOrder(int orderID){
        _pizzaOrders.removeOrder(orderID);
    }

    public void saveOrders(){
        _pizzaOrders.persist();
    }
}
