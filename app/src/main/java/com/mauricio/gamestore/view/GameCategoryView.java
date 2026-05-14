package com.mauricio.gamestore.view;

import com.mauricio.gamestore.controller.GameCategoryController;
import com.mauricio.gamestore.model.dto.response.GameCategoryResponseDTO;

import java.util.List;

public class GameCategoryView {
    private final GameCategoryController gameCategoryController;

    public GameCategoryView() {
        this.gameCategoryController = new GameCategoryController();
    }

    public void displayAllCategories () {
        List<GameCategoryResponseDTO> allCategories = gameCategoryController.findAll();

        System.out.println("\n-- TODAS AS CATEGORIAS --");
        for (GameCategoryResponseDTO category : allCategories) {
            System.out.printf("%d. %s%n", category.getId(), category.getTitle());
        }
    }
}
