package com.mauricio.gamestore.model.service;

import com.mauricio.gamestore.model.dao.PurchaseDAO;
import com.mauricio.gamestore.model.entity.Purchase;
import com.mauricio.gamestore.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PurchaseService {
    public List<Purchase> listAllPurchases() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PurchaseDAO dao = new PurchaseDAO(conn);
            return dao.getAllPurchases();
        } catch (SQLException e) {
            System.err.println("Erro ao listar compras: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public Purchase getPurchaseById(int id) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PurchaseDAO dao = new PurchaseDAO(conn);
            return dao.getPurchaseById(id);
        } catch (SQLException e) {
            System.err.println("Erro ao buscar compra por ID: " + e.getMessage());
        }
        return null;
    }

    public void updatePurchase(Purchase purchase) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PurchaseDAO dao = new PurchaseDAO(conn);
            dao.updatePurchase(purchase);
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar compra: " + e.getMessage());
        }
    }
}
