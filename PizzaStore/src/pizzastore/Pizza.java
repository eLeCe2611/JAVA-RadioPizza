package pizzastore;

public class Pizza {

    private final String name;
    private final float price;

    public Pizza(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

}
