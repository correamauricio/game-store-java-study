package com.mauricio.gamestore.model.dao;

import com.mauricio.gamestore.model.entity.GameCategory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameCategoryDAO {
    private final Connection conn;

    public GameCategoryDAO(Connection conn) {
        this.conn = conn;
    }

    public GameCategory findById(int id) {
        String sql = "SELECT * FROM categoria WHERE id = ?;";

        try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return new GameCategory(
                        resultSet.getInt("id"),
                        resultSet.getString("nome")
                );
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public List<GameCategory> findAll() {
        String sql = "SELECT * FROM categoria;";
        List<GameCategory> gameCategories = new ArrayList<>();

        try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                gameCategories.add(new GameCategory(
                        resultSet.getInt("id"),
                        resultSet.getString("nome")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar as categorias: " + e.getMessage());
        }
        return gameCategories;
    }
}