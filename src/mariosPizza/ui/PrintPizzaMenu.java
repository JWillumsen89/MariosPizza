package mariosPizza.ui;

import mariosPizza.DataContext.pizzaMenu.Pizza;

import java.util.ArrayList;
import java.util.List;

public class PrintPizzaMenu {
    private List<String> formatPizzaStrings(List<Pizza> pizzas){
        var strings = new ArrayList<String>();
        for (var i = 0;i < pizzas.size();i++){
            var pizza = pizzas.get(i);
            var name = pizza.name;
            var topping = pizza.topping;
            var price = pizza.price;
            var index = pizza.pizzaIndex;
            String str = String.format("(%d) %-15s %-75s %3d,-", index,name,topping,price);
            strings.add(str);
        }
        return strings;
    }

    public void print(List<Pizza> pizzas){
        var formattedStrings = formatPizzaStrings(pizzas);
        for (var str : formattedStrings)
            System.out.println(str);
    }
}
