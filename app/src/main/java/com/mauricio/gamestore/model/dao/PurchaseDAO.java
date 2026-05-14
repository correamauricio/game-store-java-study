package com.mauricio.gamestore.model.dao;

import com.mauricio.gamestore.model.entity.Customer;
import com.mauricio.gamestore.model.entity.Game;
import com.mauricio.gamestore.model.entity.GameCategory;
import com.mauricio.gamestore.model.entity.Purchase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDAO {
    private final Connection conn;

    public PurchaseDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Purchase> getAllPurchases() {
        List<Purchase> purchases = new ArrayList<>();
        String sql = "SELECT co.id, co.data_compra, co.quantidade, " +
                     "cl.id AS cliente_id, cl.nome AS cliente_nome, cl.email AS cliente_email, cl.idade AS cliente_idade, " +
                     "j.id AS jogo_id, j.titulo AS jogo_titulo, j.genero AS jogo_genero, j.preco AS jogo_preco, " +
                     "cat.id AS categoria_id, cat.nome AS categoria_nome " +
                     "FROM compra co " +
                     "JOIN cliente cl ON co.cliente_id = cl.id " +
                     "JOIN jogo j ON co.jogo_id = j.id " +
                     "JOIN categoria cat ON j.categoria_id = cat.id";

        try (PreparedStatement stmt = this.conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Customer customer = new Customer(
                        rs.getInt("cliente_id"),
                        rs.getString("cliente_nome"),
                        rs.getString("cliente_email"),
                        rs.getInt("cliente_idade")
                );

                GameCategory category = new GameCategory(
                        rs.getInt("categoria_id"),
                        rs.getString("categoria_nome")
                );

                Game game = new Game(
                        rs.getInt("jogo_id"),
                        rs.getString("jogo_titulo"),
                        rs.getString("jogo_genero"),
                        category,
                        rs.getDouble("jogo_preco")
                );

                Purchase purchase = new Purchase(
                        rs.getInt("id"),
                        customer,
                        game,
                        rs.getDate("data_compra").toLocalDate(),
                        rs.getInt("quantidade")
                );
                purchases.add(purchase);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar compras: " + e.getMessage());
        }
        return purchases;
    }

    public Purchase getPurchaseById(int id) {
        String sql = "SELECT co.id, co.data_compra, co.quantidade, " +
                     "cl.id AS cliente_id, cl.nome AS cliente_nome, cl.email AS cliente_email, cl.idade AS cliente_idade, " +
                     "j.id AS jogo_id, j.titulo AS jogo_titulo, j.genero AS jogo_genero, j.preco AS jogo_preco, " +
                     "cat.id AS categoria_id, cat.nome AS categoria_nome " +
                     "FROM compra co " +
                     "JOIN cliente cl ON co.cliente_id = cl.id " +
                     "JOIN jogo j ON co.jogo_id = j.id " +
                     "JOIN categoria cat ON j.categoria_id = cat.id " +
                     "WHERE co.id = ?";

        try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Customer customer = new Customer(
                            rs.getInt("cliente_id"),
                            rs.getString("cliente_nome"),
                            rs.getString("cliente_email"),
                            rs.getInt("cliente_idade")
                    );

                    GameCategory category = new GameCategory(
                            rs.getInt("categoria_id"),
                            rs.getString("categoria_nome")
                    );

                    Game game = new Game(
                            rs.getInt("jogo_id"),
                            rs.getString("jogo_titulo"),
                            rs.getString("jogo_genero"),
                            category,
                            rs.getDouble("jogo_preco")
                    );

                    return new Purchase(
                            rs.getInt("id"),
                            customer,
                            game,
                            rs.getDate("data_compra").toLocalDate(),
                            rs.getInt("quantidade")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar compra por ID: " + e.getMessage());
        }
        return null;
    }
}
