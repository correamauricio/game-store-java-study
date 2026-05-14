package com.mauricio.gamestore.model.dao;

import com.mauricio.gamestore.model.entity.GameCategory;
import com.mauricio.gamestore.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameCategoryDAO {

    public GameCategory findById(int id) {
        String sql = "SELECT * FROM categoria WHERE id = ?;";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

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
}