package pizzastore;

import java.util.ArrayList;
import java.util.List;

public class PizzasMenu {

    private static PizzasMenu INSTANCE;

    private final List<Pizza> pizzas;

    private PizzasMenu() {
        pizzas = new ArrayList<>();
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public static PizzasMenu getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PizzasMenu();
        }
        return INSTANCE;
    }

}
