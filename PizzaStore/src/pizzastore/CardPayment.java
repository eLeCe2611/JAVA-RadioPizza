package pizzastore;

public class CardPayment implements PayMethod {

    CardPayment() {
    }

    @Override
    public boolean makePayment(float charge) {
        // Simulación de un pago con tarjeta
        return true;
    }

    @Override
    public String toString() {
        return "Card payment";
    }

}
