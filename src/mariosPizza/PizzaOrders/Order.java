package mariosPizza.PizzaOrders;

import java.time.LocalDate;

public class Order {
    public enum Type{
        Phone,
        walkIn
    }

    private Type type;
    public Type getType() {
        return type;
    }

    private final int pizzaIndex;
    public int getPizzaIndex() {return pizzaIndex;}

    private final LocalDate created;
    private LocalDate started;
    private LocalDate finished;

    public Order(Type type, int pizzaIndex) {
        this.type = type;
        this.pizzaIndex = pizzaIndex;
        created = LocalDate.now();
    }

    public LocalDate getCreated() {return created;}
    public LocalDate getStarted() {return started;}
    public LocalDate getFinished() {return finished;}

    public void setStarted(LocalDate started) {this.started = started;}
    public void setFinished(LocalDate finished) {this.finished = finished;}
}
