package com.mauricio.gamestore.controller;

import com.mauricio.gamestore.model.entity.Purchase;
import com.mauricio.gamestore.model.service.PurchaseService;

import java.util.List;

public class PurchaseController {
    private final PurchaseService purchaseService;

    public PurchaseController() {
        this.purchaseService = new PurchaseService();
    }

    public List<Purchase> getAllPurchases() {
        return purchaseService.listAllPurchases();
    }
}
