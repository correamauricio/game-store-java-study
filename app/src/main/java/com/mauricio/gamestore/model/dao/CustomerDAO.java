package com.mauricio.gamestore.model.dao;

import com.mauricio.gamestore.model.entity.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private final Connection conn;

    public CustomerDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT id, nome, email, idade FROM cliente";

        try (PreparedStatement stmt = this.conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Customer customer = new Customer(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getInt("idade")
                );
                customers.add(customer);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar clientes: " + e.getMessage());
        }
        return customers;
    }

    public Customer findById(int id) {
        String sql = "SELECT id, nome, email, idade FROM cliente WHERE id = ?";
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Customer(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getInt("idade")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar cliente por ID: " + e.getMessage());
        }
        return null;
    }

    public boolean update(Customer customer) {
        String sql = "UPDATE cliente SET nome = ?, email = ?, idade = ? WHERE id = ?";
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());
            stmt.setInt(3, customer.getAge());
            stmt.setInt(4, customer.getId());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar cliente: " + e.getMessage());
            return false;
        }
    }
}
