package mariosPizza.application.pizzaMenu;

public class Pizza {
    private static int index = 1;
    public int pizzaIndex;
    public String name;
    public String topping;
    public int price;

    public int pizzaIndex() {
        return index;
    }

    public Pizza(String name, String topping, int price) {
        this.name = name;
        this.topping = topping;
        this.price = price;
        pizzaIndex = index++;
    }
}
