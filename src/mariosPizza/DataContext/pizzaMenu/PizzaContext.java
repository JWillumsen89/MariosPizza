package mariosPizza.DataContext.pizzaMenu;

import java.util.List;

public class PizzaContext {
    private final List<Pizza> _pizzas;

    public PizzaContext() {
        _pizzas = new BuildPizzaMenu().build();
    }



    public List<Pizza> getPizzas() {return _pizzas;}
    public List<Pizza> getPizzas(List<Integer> indexes){
        var pizzas = _pizzas.stream()
                .filter(p -> indexes.contains(p.pizzaIndex()))
                .toList();
        return pizzas;
    }

    public Pizza getPizza(int index) throws PizzaNotFoundException {
        var pizza = _pizzas.stream()
                .filter(p -> p.pizzaIndex() == index).findFirst();
        if(pizza.isPresent())
            return pizza.get();
        throw new PizzaNotFoundException(index);
    }
}
