package mariosPizza.application.pizzaMenu;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BuildPizzaMenu {
    private FileReader setupReader(){
        FileReader reader = null;
        try {
            reader = new FileReader("resources/Pizzas.txt");
        } catch (FileNotFoundException e) {
            return null;
        }
        return reader;
    }

    private String getPizzaNamesFromData(FileReader reader) {
        var sb = new StringBuilder();
        int i;
        try {
            while ((i = reader.read()) != -1)
                sb.append((char) i);
        } catch (IOException e){
            return "";
        }
        return sb.toString();
    }

    List<Pizza> createPizzaModels(String data){
        if(data.isEmpty())
            new ArrayList<>();
        var pat = Pattern.compile("[A-z 0-9]+");
        var matcher = pat.matcher(data);
        var pizzas = matcher.results()
                .map(r -> new Pizza(r.group(),2)).toList();
        return pizzas;
    }

    public List<Pizza> build(){
        var reader = setupReader();
        var pizzaNames = getPizzaNamesFromData(reader);
        var pizzas = createPizzaModels(pizzaNames);
        return pizzas;
    }
}
