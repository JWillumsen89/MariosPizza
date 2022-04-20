package mariosPizza.application.pizzaOrders;

public class OrderBuilder {
    public Order build(int indexOfPizza, boolean phoneOrder){
        if(phoneOrder)
            return new Order(Order.Type.Phone,indexOfPizza);
        return new Order(Order.Type.WalkIn,indexOfPizza);
    }
}
