package mariosPizza.application.pizzaMenu;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

public class BuildPizzaMenu {

    public List<Pizza> build(){
        var pizzas = new ArrayList<Pizza>();
        Pizza p1 = new Pizza( "Vesuvio", "Tomat, Ost, Skinke, Oregano", 57);
        Pizza p2 = new Pizza( "Amerikaner", "Tomat, Ost, Oksefars, Oregano", 53);
        Pizza p3 = new Pizza( "Cacciatore", "Tomat, Ost, Pepperoni, Oregano", 57);
        Pizza p4 = new Pizza( "Carbona", "Tomat, Ost, Kødsovs, Spaghetti, Cocktailpølser, Oregano", 63);
        Pizza p5 = new Pizza( "Dennis", "Tomat, Ost, Skinke, Pepperoni, Cocktailpølser, Oregano", 65);
        pizzas.add(p1);
        pizzas.add(p2);
        pizzas.add(p3);
        pizzas.add(p4);
        pizzas.add(p5);
        return pizzas;
    }
}
