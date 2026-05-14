package com.mauricio.gamestore.view;

import com.mauricio.gamestore.controller.CustomerController;
import com.mauricio.gamestore.model.entity.Customer;
import java.util.List;

public class CustomerView {
    private final CustomerController customerController;

    public CustomerView() {
        this.customerController = new CustomerController();
    }

    public void displayAllCustomers() {
        List<Customer> customers = customerController.getAllCustomers();
        System.out.println("\n -- LISTA DE CLIENTES --");
        if (customers.isEmpty()) {
            System.out.println("Nenhum cliente encontrado.");
        } else {
            System.out.printf("%-5s | %-20s | %-25s | %-5s%n", "ID", "Nome", "Email", "Idade");
            System.out.println("---------------------------------------------------------------");
            for (Customer customer : customers) {
                System.out.printf("%-5d | %-20s | %-25s | %-5d%n",
                        customer.getId(),
                        customer.getName(),
                        customer.getEmail(),
                        customer.getAge());
            }
        }
    }
}
