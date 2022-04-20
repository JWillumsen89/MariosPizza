package mariosPizza;

import mariosPizza.application.pizzaMenu.BuildPizzaMenu;

public class Main {
    public static void main(String[] args) {
        var pizzaMenu = new BuildPizzaMenu().build();
        pizzaMenu.forEach(p -> System.out.println(p.getName()));
    }
}