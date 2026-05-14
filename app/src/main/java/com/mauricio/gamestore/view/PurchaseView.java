package com.mauricio.gamestore.view;

import com.mauricio.gamestore.controller.PurchaseController;
import com.mauricio.gamestore.model.entity.Purchase;

import java.util.List;

public class PurchaseView {
    private final PurchaseController purchaseController;

    public PurchaseView() {
        this.purchaseController = new PurchaseController();
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
}
