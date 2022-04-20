package mariosPizza.application.pizzaMenu;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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

    private String extractDataAsString(FileReader reader) {
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

    private List<String> extractNames(String data){
        if(data.isEmpty())
            new ArrayList<>();
        var pat = Pattern.compile("[A-z 0-9.]+");
        var matcher = pat.matcher(data);
        var pizzas = matcher.results()
                .map(r -> r.group()).toList();
        return pizzas;
    }

    private List<Pizza> createPizzas(List<String> names){
        var pizzas = names.stream()
                .map(n -> {
                    var duration = new Random().nextInt(15) + 5;
                    return new Pizza(n,duration);
                }).toList();
        return pizzas;
    }

    public List<Pizza> build(){
        var reader = setupReader();
        var pizzaNames = extractDataAsString(reader);
        var names = extractNames(pizzaNames);
        var pizzas = createPizzas(names);
        return pizzas;
    }
}
