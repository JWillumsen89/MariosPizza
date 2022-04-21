package mariosPizza.application.pizzaOrders;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Order implements Comparable<Order>{
    @Override
    public int compareTo(Order order) {
        var val = estimatedTimeOfFinish.compareTo(order.estimatedTimeOfFinish);
        if(val > 0)
            return 1;
        else if(val == 0)
        {
            if(pizzaIndex < order.pizzaIndex)
                return 1;
            else
                return -1;
        }
        else
            return -1;
    }

    public enum Status {
        Pending,
        InProgress,
        Done
    }

    private static int instanceIndex = 1;

    private int orderID;

    public int getOrderID() {
        return instanceIndex;
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

    public Order(int pizzaIndex, int duration) {
        this.pizzaIndex = pizzaIndex;
        created = LocalTime.now();
        status = Status.Pending;
        estimatedTimeOfFinish = created.plus(duration,ChronoUnit.MINUTES);
        orderID = instanceIndex++;
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
