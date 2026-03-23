package pizzastore;

import java.util.List;

public class CashRegister {

    private CashRegister() {
    }

    public static Order createTakeInOrder(List<Pizza> pizzas) {
        return OrderFactory.getInstance().order(OrderType.TAKE_IN, pizzas);
    }

    public static Order createTakeOutOrder(List<Pizza> pizzas) {
        return OrderFactory.getInstance().order(OrderType.TAKE_OUT, pizzas);
    }

    public static Ticket makeCardPayment(Order order) {
        return new Ticket(order, new CardPayment());
    }

    public static Ticket makeCashPayment(Order order, float cash) {
        return new Ticket(order, new CashPayment(cash));
    }

}
