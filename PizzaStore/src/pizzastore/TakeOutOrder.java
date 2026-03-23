package pizzastore;

import java.util.List;

public class TakeOutOrder extends Order {

    public static final float ADDED_CHARGE = 0.15f;

    TakeOutOrder(List<Pizza> pizzas) {
        super(pizzas);
    }

    @Override
    public float getCharge() {
        float charge = 0.0f;

        for (Pizza pizza : pizzas) {
            charge += pizza.getPrice() + ADDED_CHARGE;
        }

        return charge;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("TAKE OUT");
        for (Pizza pizza : pizzas) {
            stringBuilder.append("\n");
            stringBuilder.append(pizza.getName());
            stringBuilder.append(" - ");
            stringBuilder.append(pizza.getPrice());
            stringBuilder.append("+");
            stringBuilder.append(ADDED_CHARGE);
            stringBuilder.append("€");
        }

        return stringBuilder.toString();
    }

}
