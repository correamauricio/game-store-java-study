package com.mauricio.gamestore.model.entity;

public class Game {
    private String title;
    private String gender;
    private String category;
    private double price;

    public Game(String title, String gender, String category, double price) {
        this.title = title;
        this.gender = gender;
        this.category = category;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
