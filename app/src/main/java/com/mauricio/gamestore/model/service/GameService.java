package com.mauricio.gamestore.model.service;

import com.mauricio.gamestore.model.dao.GameDAO;
import com.mauricio.gamestore.model.entity.Game;
import com.mauricio.gamestore.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameService {
    public boolean addGame(Game game) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            GameDAO dao = new GameDAO(conn);
            dao.addGame(game);
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar game " + e.getMessage());
        }
        return false;
    }

    public List<Game> getAllGames() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            GameDAO dao = new GameDAO(conn);
            return dao.getAllGames();
        } catch (SQLException e) {
            System.err.println("Erro ao listar jogos: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public Game getGameById(int id) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            GameDAO dao = new GameDAO(conn);
            return dao.findById(id);
        } catch (SQLException e) {
            System.err.println("Erro ao buscar jogo: " + e.getMessage());
        }
        return null;
    }

    public boolean updateGame(Game game) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            GameDAO dao = new GameDAO(conn);
            return dao.updateGame(game);
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar jogo: " + e.getMessage());
        }
        return false;
    }
}
