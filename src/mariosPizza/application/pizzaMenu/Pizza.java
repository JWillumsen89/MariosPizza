package mariosPizza.application.pizzaMenu;

public class Pizza {
    private static int index;

    public int getIndex() {
        return index;
    }

    private final String name;
    public String getName() {
        return name;
    }

    private final int duration;
    public int getDuration() {
        return duration;
    }

    public Pizza(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }
}
