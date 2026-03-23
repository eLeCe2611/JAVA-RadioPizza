package pizzastore;

public class CashPayment implements PayMethod {

    private final float cash;

    CashPayment(float cash) {
        this.cash = cash;
    }

    @Override
    public boolean makePayment(float charge) {
        // Simulación de pago en efectivo
        return true;
    }

    @Override
    public String toString() {
        return "Cash Payment\n" + cash + "€";
    }

}
