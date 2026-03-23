package pizzastore;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Application {

    private final InputStream input;
    private final PrintStream output;
    private final List<Order> unpaidOrders;

    private Application(InputStream input, PrintStream output) {
        this.input = input;
        this.output = output;
        this.unpaidOrders = new ArrayList<>();
    }

    private void mainMenu() {
        Scanner scanner = new Scanner(input);
        int option;

        do {
            option = 1;
            output.println("\n--------------MENU--------------");
            output.println(option++ + ". Registrar pedido");
            output.println(option++ + ". Realizar pago");
            output.println(option++ + ". Salir");
            output.print(": ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    registerOrder(scanner);
                    break;
                case 2:
                    makePayment(scanner);
                    break;
                case 3:
                    output.println("Saliendo...");
                    break;
                default:
                    output.println("Opcion desconocida");
            }
        } while (option != 3);
    }

    private void registerOrder(Scanner scanner) {
        List<Pizza> pizzas;
        int option = 1;

        output.println("\n---------REGISTER ORDER----------");
        output.println(option++ + ". Tomar aqui");
        output.println(option++ + ". Para llevar");
        output.println(option++ + ". Cancelar");
        output.print(": ");
        option = scanner.nextInt();

        switch (option) {
            case 1:
                pizzas = takeOrder(scanner);
                if (!pizzas.isEmpty()) {
                    unpaidOrders.add(CashRegister.createTakeInOrder(pizzas));
                    output.println("Registrado!");
                }
                break;
            case 2:
                pizzas = takeOrder(scanner);
                if (!pizzas.isEmpty()) {
                    unpaidOrders.add(CashRegister.createTakeOutOrder(pizzas));
                    output.println("Registrado!");
                }
                break;
            default:
                output.println("Cancelado");
        }

    }

    private List<Pizza> takeOrder(Scanner scanner) {
        List<Pizza> orderedPizzas = new LinkedList<>();
        List<Pizza> pizzas = PizzasMenu.getInstance().getPizzas();
        int option = 1, confirmar, cancelar;

        output.println("\n-----------TAKE ORDER------------");
        for (Pizza pizza : pizzas) {
            output.println(option++ + ". " + pizza.getName() + " - " + pizza.getPrice() + "€");
        }
        output.println((confirmar = option++) + ". Confirmar");
        output.println((cancelar = option++) + ". Cancelar");

        do {
            output.print(": ");
            option = scanner.nextInt();

            if (option > 0 && option <= pizzas.size()) {
                orderedPizzas.add(pizzas.get(option - 1));
            }
        } while (option != confirmar && option != cancelar);

        if (orderedPizzas.isEmpty() || option == cancelar) {
            orderedPizzas.clear();
            output.println("Cancelado");
        } else if (option == confirmar) {
            output.println("Confirmado");
        }

        return orderedPizzas;
    }

    private void makePayment(Scanner scanner) {
        Order order;
        Ticket ticket;
        int option;

        order = selectUnpaidOrder(scanner);

        if (order == null) {
            output.println("Cancelado");
            return;
        }

        option = 1;
        output.println("\n----------MAKE PAYMENT-----------");
        output.println(option++ + ". Pago en tarjeta");
        output.println(option++ + ". Pago en efectivo");
        output.println(option++ + ". Cancelar");
        output.print(": ");
        option = scanner.nextInt();

        switch (option) {
            case 1:
                ticket = CashRegister.makeCardPayment(order);
                output.println(ticket);
                break;
            case 2:
                ticket = CashRegister.makeCashPayment(order, 100.0f);
                output.println(ticket);
                break;
            default:
                output.println("Cancelado");
        }
    }

    private Order selectUnpaidOrder(Scanner scanner) {
        Order selectedOrder = null;
        int option = 1;

        output.println("\n----------SELECT ORDER-----------");
        for (Order order : unpaidOrders) {
            output.println(option++ + ". " + order + "\nTotal: " + order.getCharge());
        }
        output.println(option++ + ". Cancelar");
        output.print(": ");
        option = scanner.nextInt();

        if (option > 0 && option <= unpaidOrders.size()) {
            selectedOrder = unpaidOrders.remove(option - 1);
        }

        return selectedOrder;
    }

    public static void main(String[] args) {
        List<Pizza> pizzas = PizzasMenu.getInstance().getPizzas();
        pizzas.add(new Pizza("Barbacoa", 7.0f));
        pizzas.add(new Pizza("Carbonara", 6.5f));
        pizzas.add(new Pizza("Cuatro quesos", 6.5f));
        pizzas.add(new Pizza("Hawaiiana", 6.5f));
        pizzas.add(new Pizza("Margarita", 5.75f));

        Application application = new Application(System.in, System.out);
        application.mainMenu();
    }

}
