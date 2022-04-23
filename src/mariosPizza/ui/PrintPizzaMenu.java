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
        PrintBlankScreen lines = new PrintBlankScreen();
        lines.print();
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

    private int aggregatedLength(List<String> items){
        var aggregatedLength = items.stream()
                .map(String::length)
                .reduce(0,(x,y) -> y = x > y ? x : y);
        return aggregatedLength;
    }

    private String buildHeader(int length){
        var header = new StringBuilder("\33[33m");
        var label = "PIZZA MENU";
        var lengthOfDots = length - label.length();
        for (var i = 0;i < lengthOfDots;i++)
            header.append("-");
        int medianIndex;
        if(lengthOfDots % 2 == 0)
            medianIndex = lengthOfDots / 2;
        else
            medianIndex = (lengthOfDots / 2) + 1;
        header.insert(medianIndex,label);
        header.append("\33[m");
        return header.toString();
    }

    public void print(List<Pizza> pizzas){
        var formattedStrings = formatPizzaStrings(pizzas);
        var totalLength = aggregatedLength(formattedStrings);
        var header = buildHeader(totalLength);
        System.out.println(header);
        for (var str : formattedStrings)
            System.out.println(str);
    }
}
