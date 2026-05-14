package com.mauricio.gamestore.controller;

import com.mauricio.gamestore.model.dto.request.PurchaseRequestDTO;
import com.mauricio.gamestore.model.dto.response.PurchaseResponseDTO;
import com.mauricio.gamestore.model.entity.Customer;
import com.mauricio.gamestore.model.entity.Game;
import com.mauricio.gamestore.model.entity.Purchase;
import com.mauricio.gamestore.model.service.CustomerService;
import com.mauricio.gamestore.model.service.GameService;
import com.mauricio.gamestore.model.service.PurchaseService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PurchaseController {
    private final PurchaseService purchaseService;
    private final CustomerService customerService;
    private final GameService gameService;

    public PurchaseController() {
        this.purchaseService = new PurchaseService();
        this.customerService = new CustomerService();
        this.gameService = new GameService();
    }

    public List<PurchaseResponseDTO> getAllPurchases() {
        return purchaseService.listAllPurchases().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public PurchaseResponseDTO getPurchaseById(int id) {
        Purchase purchase = purchaseService.getPurchaseById(id);
        return (purchase != null) ? convertToResponseDTO(purchase) : null;
    }

    public void updatePurchase(int id, PurchaseRequestDTO request) {
        Customer customer = customerService.findById(request.getCustomerId());
        Game game = gameService.getGameById(request.getGameId());
        
        if (customer != null && game != null) {
            Purchase purchase = new Purchase(id, customer, game, LocalDate.now(), request.getQuantity());
            purchaseService.updatePurchase(purchase);
        }
    }

    public String registerPurchase(PurchaseRequestDTO request) {
        Customer customer = customerService.findById(request.getCustomerId());
        if (customer == null) {
            return "Erro: Cliente não encontrado.";
        }

        Game game = gameService.getGameById(request.getGameId());
        if (game == null) {
            return "Erro: Jogo não encontrado.";
        }

        if (request.getQuantity() <= 0) {
            return "Erro: A quantidade deve ser maior que zero.";
        }

        Purchase purchase = new Purchase(0, customer, game, LocalDate.now(), request.getQuantity());
        purchaseService.savePurchase(purchase);

        return "Sucesso: Compra registrada com sucesso!";
    }

    private PurchaseResponseDTO convertToResponseDTO(Purchase purchase) {
        double totalValue = purchase.getPurchaseGame().getPrice() * purchase.getQuantity();
        return new PurchaseResponseDTO(
                purchase.getId(),
                purchase.getPurchaseCustomer().getId(),
                purchase.getPurchaseCustomer().getName(),
                purchase.getPurchaseGame().getId(),
                purchase.getPurchaseGame().getTitle(),
                purchase.getPurchaseDate(),
                purchase.getQuantity(),
                totalValue
        );
    }
}
