package com.mauricio.gamestore.model.service;

import com.mauricio.gamestore.model.dao.GameDAO;
import com.mauricio.gamestore.model.entity.Game;
import com.mauricio.gamestore.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

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
}
