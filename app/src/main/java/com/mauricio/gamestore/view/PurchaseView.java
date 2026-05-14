package com.mauricio.gamestore.view;

import com.mauricio.gamestore.controller.PurchaseController;
import com.mauricio.gamestore.model.dto.request.PurchaseRequestDTO;
import com.mauricio.gamestore.model.dto.response.PurchaseResponseDTO;

import java.util.List;
import java.util.Scanner;

public class PurchaseView {
    private final PurchaseController purchaseController;
    private final CustomerView customerView;
    private final GameView gameView;
    private final Scanner scanner;

    public PurchaseView() {
        this.purchaseController = new PurchaseController();
        this.scanner = new Scanner(System.in);
        this.customerView = new CustomerView();
        this.gameView = new GameView();
    }

    public void displayAllPurchases() {
        List<PurchaseResponseDTO> purchases = purchaseController.getAllPurchases();

        System.out.println("\n-- LISTA DE TODAS AS COMPRAS --");

        if (purchases.isEmpty()) {
            System.out.println("Nenhuma compra registrada.");
        } else {
            System.out.printf("%-5s | %-15s | %-20s | %-10s | %-10s | %-10s\n", "ID", "Cliente", "Jogo", "Data", "Qtd", "Total");
            System.out.println("---------------------------------------------------------------------------------------");
            for (PurchaseResponseDTO purchase : purchases) {
                System.out.printf("%-5d | %-15s | %-20s | %-10s | %-10d | R$ %-8.2f\n",
                        purchase.getId(),
                        purchase.getCustomerName(),
                        purchase.getGameTitle(),
                        purchase.getPurchaseDate().toString(),
                        purchase.getQuantity(),
                        purchase.getTotalValue());
            }
        }
    }

    public void searchPurchaseById() {
        System.out.print("\nDigite o ID da compra que deseja buscar: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            PurchaseResponseDTO purchase = purchaseController.getPurchaseById(id);

            if (purchase == null) {
                System.out.println("Compra com ID " + id + " não encontrada.");
            } else {
                System.out.println("\n-- DETALHES DA COMPRA --");
                System.out.printf("%-5s | %-15s | %-20s | %-10s | %-10s | %-10s\n", "ID", "Cliente", "Jogo", "Data", "Qtd", "Total");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.printf("%-5d | %-15s | %-20s | %-10s | %-10d | R$ %-8.2f\n",
                        purchase.getId(),
                        purchase.getCustomerName(),
                        purchase.getGameTitle(),
                        purchase.getPurchaseDate().toString(),
                        purchase.getQuantity(),
                        purchase.getTotalValue());
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
            PurchaseResponseDTO purchase = purchaseController.getPurchaseById(id);

            if (purchase == null) {
                System.out.println("Compra com ID " + id + " não encontrada.");
            } else {
                System.out.println("\n-- EDITANDO COMPRA --");
                System.out.println("Cliente: " + purchase.getCustomerName());
                System.out.println("Jogo: " + purchase.getGameTitle());
                System.out.println("Data: " + purchase.getPurchaseDate());
                System.out.println("Quantidade Atual: " + purchase.getQuantity());

                System.out.print("Digite a nova quantidade (ou pressione Enter para manter): ");
                String input = scanner.nextLine();
                int quantity = input.isEmpty() ? purchase.getQuantity() : Integer.parseInt(input);

                PurchaseRequestDTO request = new PurchaseRequestDTO(purchase.getCustomerId(), purchase.getGameId(), quantity);
                purchaseController.updatePurchase(id, request);
                System.out.println("Compra atualizada com sucesso!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Operação cancelada.");
        }
    }

    public void registerPurchase() {
        System.out.println("\n-- REGISTRO DE NOVA COMPRA --");

        try {
            System.out.print("\n-- LISTA DE CLIENTES --");
            customerView.displayAllCustomers();

            System.out.print("Digite o ID do Cliente: ");
            int customerId = Integer.parseInt(scanner.nextLine());

            System.out.print("\n-- LISTA DE JOGOS --");
            gameView.displayAllGames();

            System.out.print("Digite o ID do Jogo: ");
            int gameId = Integer.parseInt(scanner.nextLine());

            System.out.print("Digite a Quantidade: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            PurchaseRequestDTO request = new PurchaseRequestDTO(customerId, gameId, quantity);
            String result = purchaseController.registerPurchase(request);
            System.out.println(result);

        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Certifique-se de digitar números para IDs e Quantidade.");
        }
    }
}
