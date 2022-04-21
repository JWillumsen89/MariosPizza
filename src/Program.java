import mariosPizza.application.pizzaMenu.BuildPizzaMenu;
import mariosPizza.ui.PrintPizzaMenu;

public class Program {
    public static void main(String[] args) {
        var builder = new BuildPizzaMenu();
        var pizzas = builder.build();
        PrintPizzaMenu printer = new PrintPizzaMenu();
        printer.print(pizzas);
    }
}
