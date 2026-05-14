package com.mauricio.gamestore.model.dto.request;

public class PurchaseRequestDTO {
    private int customerId;
    private int gameId;
    private int quantity;

    public PurchaseRequestDTO(int customerId, int gameId, int quantity) {
        this.customerId = customerId;
        this.gameId = gameId;
        this.quantity = quantity;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
