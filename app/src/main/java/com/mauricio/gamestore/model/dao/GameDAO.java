package com.mauricio.gamestore.model.dao;

import com.mauricio.gamestore.model.entity.Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GameDAO {
    private final Connection conn;

    public GameDAO(Connection conn) {
        this.conn = conn;
    }
    public boolean addGame(Game game) {
        String sql = "INSERT INTO jogo (titulo, genero, preco, categoria_id) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {
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
