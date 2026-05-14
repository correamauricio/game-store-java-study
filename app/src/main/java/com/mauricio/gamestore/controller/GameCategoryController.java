package com.mauricio.gamestore.controller;

import com.mauricio.gamestore.model.entity.GameCategory;
import com.mauricio.gamestore.model.service.GameCategoryService;

import java.util.List;

public class GameCategoryController {
    private final GameCategoryService categoryService;

    public GameCategoryController() {
        this.categoryService = new GameCategoryService();
    }

    public List<GameCategory> findAll () {
        return categoryService.findAll();
    }

    public GameCategory findById(int id) {
        return categoryService.findById(id);
    }
}
