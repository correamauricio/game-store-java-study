package com.mauricio.gamestore.model.dao;

import com.mauricio.gamestore.model.entity.Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mauricio.gamestore.model.entity.GameCategory;

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

    public List<Game> getAllGames() {
        List<Game> games = new ArrayList<>();
        String sql = "SELECT j.titulo, j.genero, j.preco, c.id AS categoria_id, c.nome AS categoria_nome " +
                     "FROM jogo j " +
                     "JOIN categoria c ON j.categoria_id = c.id";

        try (PreparedStatement stmt = this.conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                GameCategory category = new GameCategory(
                        rs.getInt("categoria_id"),
                        rs.getString("categoria_nome")
                );
                Game game = new Game(
                        rs.getString("titulo"),
                        rs.getString("genero"),
                        category,
                        rs.getDouble("preco")
                );
                games.add(game);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar jogos: " + e.getMessage());
        }
        return games;
    }
}
