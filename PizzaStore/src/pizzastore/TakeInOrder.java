package pizzastore;

import java.util.List;

public class TakeInOrder extends Order {

    TakeInOrder(List<Pizza> pizzas) {
        super(pizzas);
    }

    @Override
    public float getCharge() {
        float charge = 0.0f;

        for (Pizza pizza : pizzas) {
            charge += pizza.getPrice();
        }

        return charge;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("TAKE IN");
        for (Pizza pizza : pizzas) {
            stringBuilder.append("\n");
            stringBuilder.append(pizza.getName());
            stringBuilder.append(" - ");
            stringBuilder.append(pizza.getPrice());
            stringBuilder.append("€");
        }

        return stringBuilder.toString();
    }

}
