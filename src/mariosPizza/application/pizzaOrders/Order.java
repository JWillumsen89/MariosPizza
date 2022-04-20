package mariosPizza.application.pizzaOrders;

import java.time.LocalDate;
import java.time.LocalTime;
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

    private LocalTime estimatedTimeOfFinish;

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

    private final LocalTime created;
    private LocalTime started;
    private LocalTime finished;

    public Order(Type type, int pizzaIndex) {
        this.pizzaIndex = pizzaIndex;
        created = LocalTime.now();
        status = Status.Pending;

        var duration = type == Type.Phone ? 60 : 10;
        estimatedTimeOfFinish = created.plus(duration,ChronoUnit.MINUTES);
        orderID++;
    }

    public LocalTime getCreated() {return created;}
    public LocalTime getStarted() {return started;}
    public LocalTime getFinished() {return finished;}

    public LocalTime getEstimated() {
        return created.plus(60, ChronoUnit.MINUTES);
    }

    public void setInProgress(){
        started = LocalTime.now();
        status = Status.InProgress;
    }

    public void setFinished(){
        finished = LocalTime.now();
        status = Status.Done;
    }
}
