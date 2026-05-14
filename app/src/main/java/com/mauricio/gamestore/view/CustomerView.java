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

    public void registerCustomer() {
        System.out.println("\n -- CADASTRAR NOVO CLIENTE --");
        System.out.print("Nome: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Idade: ");
        try {
            int age = Integer.parseInt(scanner.nextLine());
            Customer customer = new Customer(name, email, age);
            if (customerController.registerCustomer(customer)) {
                System.out.println("Cliente cadastrado com sucesso!");
            } else {
                System.out.println("Erro ao cadastrar cliente.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Idade inválida. Operação cancelada.");
        }
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

    public void editCustomer() {
        System.out.println("\n -- EDITAR CLIENTE --");
        displayAllCustomers();
        System.out.print("\nDigite o ID do cliente que deseja editar: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Customer customer = customerController.findById(id);

            if (customer != null) {
                System.out.println("Dados atuais - Nome: " + customer.getName() + ", Email: " + customer.getEmail() + ", Idade: " + customer.getAge());
                
                System.out.print("Novo nome (deixe em branco para manter): ");
                String name = scanner.nextLine();
                if (!name.isBlank()) customer.setName(name);

                System.out.print("Novo email (deixe em branco para manter): ");
                String email = scanner.nextLine();
                if (!email.isBlank()) customer.setEmail(email);

                System.out.print("Nova idade (deixe em branco para manter): ");
                String ageStr = scanner.nextLine();
                if (!ageStr.isBlank()) {
                    customer.setAge(Integer.parseInt(ageStr));
                }

                if (customerController.updateCustomer(customer)) {
                    System.out.println("Cliente atualizado com sucesso!");
                } else {
                    System.out.println("Erro ao atualizar cliente.");
                }
            } else {
                System.out.println("Cliente com ID " + id + " não encontrado.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Operação cancelada.");
        }
    }
}
