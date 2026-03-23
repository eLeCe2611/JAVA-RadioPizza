package pizzastore;

import java.util.ArrayList;
import java.util.List;

public class OrderFactory {

    private static OrderFactory INSTANCE;

    private OrderFactory() {
    }

    public Order order(OrderType orderType, List<Pizza> pizzas) {
        Order order;
        
        switch (orderType) {
            case TAKE_IN:
                order = new TakeInOrder(new ArrayList<>(pizzas));
                break;
            case TAKE_OUT:
                order = new TakeOutOrder(new ArrayList<>(pizzas));
                break;
            default:
                order = null;
                break;
        };
        
        return order;
    }

    public static OrderFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new OrderFactory();
        }
        return INSTANCE;
    }

}
