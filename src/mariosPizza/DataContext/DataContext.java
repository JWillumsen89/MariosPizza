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
