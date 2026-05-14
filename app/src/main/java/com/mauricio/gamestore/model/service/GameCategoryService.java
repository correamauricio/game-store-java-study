package com.mauricio.gamestore.model.service;

import com.mauricio.gamestore.model.dao.GameCategoryDAO;
import com.mauricio.gamestore.model.entity.GameCategory;
import com.mauricio.gamestore.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GameCategoryService {
    public GameCategory findById(int id) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            GameCategoryDAO dao = new GameCategoryDAO(conn);
            return dao.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar categoria", e);
        }
    }

    public List<GameCategory> findAll() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            GameCategoryDAO dao = new GameCategoryDAO(conn);
            return dao.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar todas as categorias", e);
        }
    }
}

