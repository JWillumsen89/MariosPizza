package mariosPizza.ui;

import mariosPizza.DataContext.pizzaMenu.Pizza;

import java.util.ArrayList;
import java.util.List;

public class PrintPizzaMenu {
    public String fReset = "\u001B[0m";
    public String green = "\u001B[32m";
    public String blue = "\u001B[34m";
    public String yellow = "\u001B[33m";
    private void lineSpace() {
        LineSpacing lines = new LineSpacing();
        lines.lines();
    }
    private List<String> formatPizzaStrings(List<Pizza> pizzas){
        var strings = new ArrayList<String>();
        for (var i = 0;i < pizzas.size();i++){
            var pizza = pizzas.get(i);
            var name = pizza.name;
            var topping = pizza.topping;
            var price = pizza.price;
            var index = pizza.pizzaIndex;
            lineSpace();
            String str = String.format("(%d) %-15s %-75s %3d,-", index,name,topping,price);

            strings.add(str);
        }
        return strings;
    }
    /*
    public void lineSpace() {
        LineSpacing lines = new LineSpacing();
        lines.lines();
    }

     */
    public void print(List<Pizza> pizzas){
        var formattedStrings = formatPizzaStrings(pizzas);
        System.out.println(yellow+"-------------------------------------------------PIZZA MENU-------------------------------------------\n"+fReset);
        for (var str : formattedStrings){

            System.out.println(str);

        }
        System.out.println("\n\n");

    }
}
