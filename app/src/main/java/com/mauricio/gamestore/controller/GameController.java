package com.mauricio.gamestore.controller;

import com.mauricio.gamestore.model.dto.request.GameRequestDTO;
import com.mauricio.gamestore.model.dto.response.GameResponseDTO;
import com.mauricio.gamestore.model.entity.Game;
import com.mauricio.gamestore.model.entity.GameCategory;
import com.mauricio.gamestore.model.service.GameCategoryService;
import com.mauricio.gamestore.model.service.GameService;

import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private final GameService gameService;
    private final GameCategoryService gameCategoryService;

    public GameController() {
        this.gameService = new GameService();
        this.gameCategoryService = new GameCategoryService();
    }

    public String addGame(GameRequestDTO request) {
        if (request.getTitle() == null || request.getTitle().trim().isEmpty()) {
            return "Erro: O título não pode ser vazio.";
        }

        if (request.getGender() == null || request.getGender().trim().isEmpty()) {
            return "Erro: O gênero não pode ser vazio.";
        }

        GameCategory category = gameCategoryService.findById(request.getCategoryId());

        if (category == null) {
            return "Erro: Categoria não encontrada no sistema.";
        }

        if (request.getPrice() < 0) {
            return "Erro: O preço não pode ser negativo.";
        }

        Game game = new Game(request.getTitle(), request.getGender(), category, request.getPrice());
        boolean success = gameService.addGame(game);

        if (success) {
            return "Sucesso: Jogo cadastrado no sistema!";
        } else {
            return "Erro: Falha ao tentar salvar no banco de dados.";
        }
    }

    public List<GameResponseDTO> getAllGames() {
        return gameService.getAllGames().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public GameResponseDTO getGameById(int id) {
        Game game = gameService.getGameById(id);
        return (game != null) ? convertToResponseDTO(game) : null;
    }

    public String updateGame(int id, GameRequestDTO request) {
        if (request.getTitle() == null || request.getTitle().trim().isEmpty()) {
            return "Erro: O título não pode ser vazio.";
        }

        if (request.getGender() == null || request.getGender().trim().isEmpty()) {
            return "Erro: O gênero não pode ser vazio.";
        }

        GameCategory category = gameCategoryService.findById(request.getCategoryId());

        if (category == null) {
            return "Erro: Categoria não encontrada no sistema.";
        }

        if (request.getPrice() < 0) {
            return "Erro: O preço não pode ser negativo.";
        }

        Game game = new Game(id, request.getTitle(), request.getGender(), category, request.getPrice());
        boolean success = gameService.updateGame(game);

        if (success) {
            return "Sucesso: Jogo atualizado no sistema!";
        } else {
            return "Erro: Falha ao tentar atualizar no banco de dados.";
        }
    }

    private GameResponseDTO convertToResponseDTO(Game game) {
        return new GameResponseDTO(
                game.getId(),
                game.getTitle(),
                game.getGender(),
                game.getCategory().getId(),
                game.getCategory().getTitle(),
                game.getPrice()
        );
    }
}
