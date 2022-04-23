package mariosPizza.DataContext.pizzaOrders;

import java.util.List;

public class PizzaOrders {
    private List<Order> _orders;
    private PersistOrders _persistence = new PersistOrders();

    public PizzaOrders(){
        _orders = _persistence.read();
        if(!_orders.isEmpty())
            Order.setInstanceIndex(_orders.size());
    }

    public List<Order> pendingOrders() {return _orders.stream().filter(Order::isPending).sorted().toList();}
    public List<Order> ordersInProgress(){return _orders.stream().filter(Order::isInProgress).toList();}
    public List<Order> completedOrders(){return _orders.stream().filter(Order::isDone).toList();}
    public List<Order> orders() {return _orders;}

    public List<Integer> getPizzaIndexesInProgress(){
        return _orders.stream().filter(Order::isInProgress).map(Order::pizzaIndex).toList();
    }

    public Order getOrderByID(int id) throws OrderNotFoundException {
        var order = _orders.stream().filter(o -> o.getOrderID() == id).findFirst();
        if(order.isPresent())
            return order.get();
        throw new OrderNotFoundException();
    }

    public void createOrder(int pizzaIndex, int duration){
        var order = new Order(pizzaIndex,duration);
        _orders.add(order);
    }

    public void removeOrder(int orderID){
        _orders.removeIf(g -> g.getOrderID() == orderID);
    }

    public void persist(){
        _persistence.save(_orders);
    }
}
