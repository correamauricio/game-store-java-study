package com.mauricio.gamestore.model.dao;

import com.mauricio.gamestore.model.entity.Game;
import com.mauricio.gamestore.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GameDAO {
    public boolean addGame(Game game) {
        String sql = "INSER INTO jogo (titulo, genero, preco, categoria_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, game.getTitle());
            stmt.setString(2, game.getGender());
            stmt.setDouble(3, game.getPrice());
            stmt.setInt(4, game.getCategory().getId());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
