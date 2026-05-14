package com.mauricio.gamestore.controller;

import com.mauricio.gamestore.model.dto.response.GameCategoryResponseDTO;
import com.mauricio.gamestore.model.entity.GameCategory;
import com.mauricio.gamestore.model.service.GameCategoryService;

import java.util.List;
import java.util.stream.Collectors;

public class GameCategoryController {
    private final GameCategoryService categoryService;

    public GameCategoryController() {
        this.categoryService = new GameCategoryService();
    }

    public List<GameCategoryResponseDTO> findAll () {
        return categoryService.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public GameCategoryResponseDTO findById(int id) {
        GameCategory category = categoryService.findById(id);
        return (category != null) ? convertToResponseDTO(category) : null;
    }

    private GameCategoryResponseDTO convertToResponseDTO(GameCategory category) {
        return new GameCategoryResponseDTO(category.getId(), category.getTitle());
    }
}
