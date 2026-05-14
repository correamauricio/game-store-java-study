package com.mauricio.gamestore.model.dto.response;

import java.time.LocalDate;

public class PurchaseResponseDTO {
    private int id;
    private int customerId;
    private String customerName;
    private int gameId;
    private String gameTitle;
    private LocalDate purchaseDate;
    private int quantity;
    private double totalValue;

    public PurchaseResponseDTO(int id, int customerId, String customerName, int gameId, String gameTitle, LocalDate purchaseDate, int quantity, double totalValue) {
        this.id = id;
        this.customerId = customerId;
        this.customerName = customerName;
        this.gameId = gameId;
        this.gameTitle = gameTitle;
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
        this.totalValue = totalValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
}
