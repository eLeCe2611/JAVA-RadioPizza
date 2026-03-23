# JAVA-RadioPizza: Design Patterns in Action 🍕🏗️

**JAVA-RadioPizza** is a Java-based management system for a pizza store. More than just a simple ordering app, this project serves as a practical implementation of various **Software Design Patterns** and Clean Code principles within an academic context.

## 🌟 Key Features

* **Order Management**: Handle different types of orders (Take-In vs. Take-Out) using inheritance and polymorphism.
* **Dynamic Menu**: A structured menu system (`PizzasMenu`) to manage available products.
* **Flexible Payments**: Support for multiple payment methods (Cash and Card) using a decoupled architecture.
* **Automated Ticketing**: Generation of transaction receipts (`Ticket`) and sales tracking via a `CashRegister`.

## 🏗️ Design Patterns Implemented

This project specifically highlights the use of:

* **Factory Pattern**: Utilized in `OrderFactory` to encapsulate the instantiation logic for different types of orders (`TakeInOrder`, `TakeOutOrder`).
* **Strategy Pattern**: Likely implemented via the `PayMethod` interface, allowing the system to switch between `CardPayment` and `CashPayment` seamlessly.
* **Abstraction & Encapsulation**: Extensive use of abstract classes and interfaces to define core business rules.

## 📁 Project Structure

The source code is located within the `pizzastore` package:

* **Core Logic**: `Application.java` (Entry point), `CashRegister.java`, and `PizzasMenu.java`.
* **Order System**: `Order.java` (Abstract base), `TakeInOrder.java`, `TakeOutOrder.java`, and the `OrderFactory.java`.
* **Payment Module**: `PayMethod.java` (Interface), `CardPayment.java`, and `CashPayment.java`.
* **Data & Output**: `Pizza.java`, `OrderType.java`, and `Ticket.java`.

## 🛠️ Tech Stack
* **Language**: Java
* **IDE Support**: Developed with NetBeans support (`nbproject` and `build.xml` files included).
* **Documentation**: A comprehensive report (`RadioPizzaMemoria.pdf`) is included, detailing the architectural decisions and class diagrams.

## 🎓 Academic Context
This repository contains a lab project focused on **Software Engineering and Design Patterns**. It demonstrates how to build scalable and maintainable systems by decoupling object creation from business logic.

## 👤 Author
* **Luis Carmona** - [eLeCe2611](https://github.com/eLeCe2611)

---
*Developed as an academic exercise in Software Architecture.*
