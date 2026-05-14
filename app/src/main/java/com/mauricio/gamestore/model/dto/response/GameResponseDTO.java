package com.mauricio.gamestore.model.dto.response;

public class GameResponseDTO {
    private int id;
    private String title;
    private String gender;
    private int categoryId;
    private String categoryTitle;
    private double price;

    public GameResponseDTO(int id, String title, String gender, int categoryId, String categoryTitle, double price) {
        this.id = id;
        this.title = title;
        this.gender = gender;
        this.categoryId = categoryId;
        this.categoryTitle = categoryTitle;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
