package mariosPizza.application.pizzaMenu;

public record Pizza(String name, int duration) {
    private static int index;

    public int pizzaIndex() {
        return index;
    }

    public Pizza(String name, int duration) {
        this.name = name;
        this.duration = duration;
        index++;
    }
}
