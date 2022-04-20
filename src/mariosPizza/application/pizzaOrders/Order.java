package mariosPizza.application.pizzaOrders;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Order {
    public enum Status {
        Pending,
        InProgress,
        Done
    }

    public enum Type {
        Phone,
        WalkIn
    }

    private static int orderID = 0;
    public int getOrderID() {
        return orderID;
    }

    private LocalDate estimatedTimeOfFinish;

    private Status status;

    public boolean isPending() {
        return status == Status.Pending;
    }

    public boolean isInProgress() {
        return status == Status.InProgress;
    }

    public boolean isDone() {
        return status == Status.Done;
    }

    private final int pizzaIndex;
    public int getPizzaIndex() {return pizzaIndex;}

    private final LocalDate created;
    private LocalDate started;
    private LocalDate finished;

    public Order(Type type, int pizzaIndex) {
        this.pizzaIndex = pizzaIndex;
        created = LocalDate.now();
        status = Status.Pending;
        var duration = type == Type.Phone ? 60 : 10;
        estimatedTimeOfFinish = created.plus(duration,ChronoUnit.MINUTES);
        orderID++;
    }

    public LocalDate getCreated() {return created;}
    public LocalDate getStarted() {return started;}
    public LocalDate getFinished() {return finished;}

    public LocalDate getEstimated() {
        return created.plus(60, ChronoUnit.MINUTES);
    }

    public void setInProgress(){
        started = LocalDate.now();
        status = Status.InProgress;
    }

    public void setFinished(){
        finished = LocalDate.now();
        status = Status.Done;
    }
}
