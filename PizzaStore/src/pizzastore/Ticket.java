package pizzastore;

public class Ticket {

    private final Order order;
    private final PayMethod payMethod;

    Ticket(Order order, PayMethod payMethod) {
        this.order = order;
        this.payMethod = payMethod;

        this.order.markAsPaid();
        this.payMethod.makePayment(this.order.getCharge());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("---TICKET---\n");
        stringBuilder.append(order);
        stringBuilder.append("\n------\n");
        stringBuilder.append("Total: ");
        stringBuilder.append(order.getCharge());
        stringBuilder.append("€\n");
        stringBuilder.append(payMethod);
        stringBuilder.append("\n--------\n");

        return stringBuilder.toString();
    }

}
