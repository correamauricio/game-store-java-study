package com.mauricio.gamestore.model.dto.request;

public class GameRequestDTO {
    private String title;
    private String gender;
    private int categoryId;
    private double price;

    public GameRequestDTO(String title, String gender, int categoryId, double price) {
        this.title = title;
        this.gender = gender;
        this.categoryId = categoryId;
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
