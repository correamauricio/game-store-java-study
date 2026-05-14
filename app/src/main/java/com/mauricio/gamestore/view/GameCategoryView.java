package com.mauricio.gamestore.view;

import com.mauricio.gamestore.controller.GameCategoryController;
import com.mauricio.gamestore.model.entity.GameCategory;

import java.util.List;

public class GameCategoryView {
    private final GameCategoryController gameCategoryController;

    public GameCategoryView() {
        this.gameCategoryController = new GameCategoryController();
    }

    public void displayAllCategories () {
        List<GameCategory> allCategories = gameCategoryController.findAll();

        System.out.println("\n-- TODAS AS CATEGORIAS --");
        for (GameCategory category : allCategories) {
            System.out.printf("%d. %s%n", category.getId(), category.getTitle());
        }
    }
}
