package com.mauricio.gamestore.model.entity;

import java.time.LocalDate;

public class Purchase {
    private int id;
    private Customer purchaseCustomer;
    private Game purchaseGame;
    private LocalDate  purchaseDate;
    private int quantity;

    public Purchase(int id, Customer purchaseCustomer, Game purchaseGame, LocalDate purchaseDate, int quantity) {
        this.id = id;
        this.purchaseCustomer = purchaseCustomer;
        this.purchaseGame = purchaseGame;
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getPurchaseCustomer() {
        return purchaseCustomer;
    }

    public void setPurchaseCustomer(Customer purchaseCustomer) {
        this.purchaseCustomer = purchaseCustomer;
    }

    public Game getPurchaseGame() {
        return purchaseGame;
    }

    public void setPurchaseGame(Game purchaseGame) {
        this.purchaseGame = purchaseGame;
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
}
