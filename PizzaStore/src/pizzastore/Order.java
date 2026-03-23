package pizzastore;

import java.util.ArrayList;
import java.util.List;

public abstract class Order {

    protected final List<Pizza> pizzas;
    private boolean paid;

    protected Order(List<Pizza> pizzas) {
        this.pizzas = pizzas;
        this.paid = false;
    }

    public boolean isPaid() {
        return paid;
    }

    void markAsPaid() {
        paid = true;
    }

    public List<Pizza> getPizzas() {
        return new ArrayList<>(pizzas);
    }

    public abstract float getCharge();

    @Override
    public abstract String toString();

}
