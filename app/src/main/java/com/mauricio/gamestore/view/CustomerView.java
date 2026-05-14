package com.mauricio.gamestore.view;

import com.mauricio.gamestore.controller.CustomerController;
import com.mauricio.gamestore.model.entity.Customer;
import java.util.List;
import java.util.Scanner;

public class CustomerView {
    private final CustomerController customerController;
    private final Scanner scanner;

    public CustomerView() {
        this.customerController = new CustomerController();
        this.scanner = new Scanner(System.in);
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

    public void findCustomerById() {
        System.out.println("\n -- BUSCAR CLIENTE POR ID --");
        System.out.print("Digite o ID do cliente: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Customer customer = customerController.findById(id);

            if (customer != null) {
                System.out.println("\nCliente encontrado:");
                System.out.println("ID: " + customer.getId());
                System.out.println("Nome: " + customer.getName());
                System.out.println("Email: " + customer.getEmail());
                System.out.println("Idade: " + customer.getAge());
            } else {
                System.out.println("Cliente com ID " + id + " não encontrado.");
            }
        } catch (NumberFormatException e) {
            System.out.println("ID inválido. Por favor, digite um número.");
        }
    }
}
