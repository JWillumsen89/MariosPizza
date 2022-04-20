package mariosPizza;

import java.time.LocalDate;

public class Order {
    private final int pizzaIndex;
    public int getPizzaIndex() {return pizzaIndex;}
    private final LocalDate created;
    private LocalDate started;
    private LocalDate finished;

    public Order(int pizzaIndex) {
        this.pizzaIndex = pizzaIndex;
        created = LocalDate.now();
    }

    public LocalDate getCreated() {return created;}
    public LocalDate getStarted() {return started;}
    public LocalDate getFinished() {return finished;}

    public void setStarted(LocalDate started) {this.started = started;}
    public void setFinished(LocalDate finished) {this.finished = finished;}
}
