package com.mauricio.gamestore.controller;

import com.mauricio.gamestore.model.entity.Customer;
import com.mauricio.gamestore.model.entity.Game;
import com.mauricio.gamestore.model.entity.Purchase;
import com.mauricio.gamestore.model.service.CustomerService;
import com.mauricio.gamestore.model.service.GameService;
import com.mauricio.gamestore.model.service.PurchaseService;

import java.time.LocalDate;
import java.util.List;

public class PurchaseController {
    private final PurchaseService purchaseService;
    private final CustomerService customerService;
    private final GameService gameService;

    public PurchaseController() {
        this.purchaseService = new PurchaseService();
        this.customerService = new CustomerService();
        this.gameService = new GameService();
    }

    public List<Purchase> getAllPurchases() {
        return purchaseService.listAllPurchases();
    }

    public Purchase getPurchaseById(int id) {
        return purchaseService.getPurchaseById(id);
    }

    public void updatePurchase(Purchase purchase) {
        purchaseService.updatePurchase(purchase);
    }

    public String registerPurchase(int customerId, int gameId, int quantity) {
        Customer customer = customerService.findById(customerId);
        if (customer == null) {
            return "Erro: Cliente não encontrado.";
        }

        Game game = gameService.getGameById(gameId);
        if (game == null) {
            return "Erro: Jogo não encontrado.";
        }

        if (quantity <= 0) {
            return "Erro: A quantidade deve ser maior que zero.";
        }

        Purchase purchase = new Purchase(0, customer, game, LocalDate.now(), quantity);
        purchaseService.savePurchase(purchase);

        return "Sucesso: Compra registrada com sucesso!";
    }
}
