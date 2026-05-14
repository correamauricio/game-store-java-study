package com.mauricio.gamestore.view;

import com.mauricio.gamestore.controller.PurchaseController;
import com.mauricio.gamestore.model.entity.Purchase;

import java.util.List;
import java.util.Scanner;

public class PurchaseView {
    private final PurchaseController purchaseController;
    private final Scanner scanner;

    public PurchaseView() {
        this.purchaseController = new PurchaseController();
        this.scanner = new Scanner(System.in);
    }

    public void displayAllPurchases() {
        List<Purchase> purchases = purchaseController.getAllPurchases();

        System.out.println("\n-- LISTA DE TODAS AS COMPRAS --");

        if (purchases.isEmpty()) {
            System.out.println("Nenhuma compra registrada.");
        } else {
            System.out.printf("%-5s | %-15s | %-20s | %-10s | %-10s\n", "ID", "Cliente", "Jogo", "Data", "Qtd");
            System.out.println("-------------------------------------------------------------------------");
            for (Purchase purchase : purchases) {
                System.out.printf("%-5d | %-15s | %-20s | %-10s | %-10d\n",
                        purchase.getId(),
                        purchase.getPurchaseCustomer().getName(),
                        purchase.getPurchaseGame().getTitle(),
                        purchase.getPurchaseDate().toString(),
                        purchase.getQuantity());
            }
        }
    }

    public void searchPurchaseById() {
        System.out.print("\nDigite o ID da compra que deseja buscar: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Purchase purchase = purchaseController.getPurchaseById(id);

            if (purchase == null) {
                System.out.println("Compra com ID " + id + " não encontrada.");
            } else {
                System.out.println("\n-- DETALHES DA COMPRA --");
                System.out.printf("%-5s | %-15s | %-20s | %-10s | %-10s\n", "ID", "Cliente", "Jogo", "Data", "Qtd");
                System.out.println("-------------------------------------------------------------------------");
                System.out.printf("%-5d | %-15s | %-20s | %-10s | %-10d\n",
                        purchase.getId(),
                        purchase.getPurchaseCustomer().getName(),
                        purchase.getPurchaseGame().getTitle(),
                        purchase.getPurchaseDate().toString(),
                        purchase.getQuantity());
            }
        } catch (NumberFormatException e) {
            System.out.println("ID inválido. Por favor, digite um número.");
        }
    }

    public void editPurchase() {
        System.out.println("\n-- EDIÇÃO DE COMPRA --");
        displayAllPurchases();

        System.out.print("\nDigite o ID da compra que deseja editar: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Purchase purchase = purchaseController.getPurchaseById(id);

            if (purchase == null) {
                System.out.println("Compra com ID " + id + " não encontrada.");
            } else {
                System.out.println("\n-- EDITANDO COMPRA --");
                System.out.println("Cliente: " + purchase.getPurchaseCustomer().getName());
                System.out.println("Jogo: " + purchase.getPurchaseGame().getTitle());
                System.out.println("Data: " + purchase.getPurchaseDate());
                System.out.println("Quantidade Atual: " + purchase.getQuantity());

                System.out.print("Digite a nova quantidade (ou pressione Enter para manter): ");
                String input = scanner.nextLine();
                if (!input.isEmpty()) {
                    purchase.setQuantity(Integer.parseInt(input));
                }

                purchaseController.updatePurchase(purchase);
                System.out.println("Compra atualizada com sucesso!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Operação cancelada.");
        }
    }
}
