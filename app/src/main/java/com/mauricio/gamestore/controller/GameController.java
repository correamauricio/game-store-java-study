package com.mauricio.gamestore.controller;

import com.mauricio.gamestore.model.dao.GameCategoryDAO;
import com.mauricio.gamestore.model.dao.GameDAO;
import com.mauricio.gamestore.model.entity.Game;
import com.mauricio.gamestore.model.entity.GameCategory;

public class GameController {
    private GameDAO gameDAO;
    private GameCategoryDAO gameCategoryDAO;

    public String addGame(String title, String gender, int idCategory, double price ) {
        if (title == null || title.trim().isEmpty()) {
            return "Erro: O título não pode ser vazio.";
        }

        if (gender == null || gender.trim().isEmpty()) {
            return "Erro: O gênero não pode ser vazio.";
        }

        GameCategory category = gameCategoryDAO.findById(idCategory);

        if (category == null) {
            return "Erro: Categoria não encontrada no sistema.";
        }

        Game game = new Game(title, gender, category, price);
        boolean success = gameDAO.addGame(game);

        if (success) {
            return "Sucesso: Jogo cadastrado no sistema!";
        } else {
            return "Erro: Falha ao tentar salvar no banco de dados.";
        }
    }
}
