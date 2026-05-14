package com.mauricio.gamestore.controller;

import com.mauricio.gamestore.model.entity.Game;
import com.mauricio.gamestore.model.entity.GameCategory;
import com.mauricio.gamestore.model.service.GameCategoryService;
import com.mauricio.gamestore.model.service.GameService;

import java.util.List;

public class GameController {
    private final GameService gameService;
    private final GameCategoryService gameCategoryService;

    public GameController() {
        this.gameService = new GameService();
        this.gameCategoryService = new GameCategoryService();
    }

    public String addGame(String title, String gender, int idCategory, double price ) {
        if (title == null || title.trim().isEmpty()) {
            return "Erro: O título não pode ser vazio.";
        }

        if (gender == null || gender.trim().isEmpty()) {
            return "Erro: O gênero não pode ser vazio.";
        }

        GameCategory category = gameCategoryService.findById(idCategory);

        if (category == null) {
            return "Erro: Categoria não encontrada no sistema.";
        }

        if (price < 0) {
            return "Erro: O preço não pode ser negativo.";
        }

        Game game = new Game(title, gender, category, price);
        boolean success = gameService.addGame(game);

        if (success) {
            return "Sucesso: Jogo cadastrado no sistema!";
        } else {
            return "Erro: Falha ao tentar salvar no banco de dados.";
        }
    }

    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    public Game getGameById(int id) {
        return gameService.getGameById(id);
    }

    public String updateGame(int id, String title, String gender, int idCategory, double price) {
        if (title == null || title.trim().isEmpty()) {
            return "Erro: O título não pode ser vazio.";
        }

        if (gender == null || gender.trim().isEmpty()) {
            return "Erro: O gênero não pode ser vazio.";
        }

        GameCategory category = gameCategoryService.findById(idCategory);

        if (category == null) {
            return "Erro: Categoria não encontrada no sistema.";
        }

        if (price < 0) {
            return "Erro: O preço não pode ser negativo.";
        }

        Game game = new Game(id, title, gender, category, price);
        boolean success = gameService.updateGame(game);

        if (success) {
            return "Sucesso: Jogo atualizado no sistema!";
        } else {
            return "Erro: Falha ao tentar atualizar no banco de dados.";
        }
    }
}
