package com.mauricio.gamestore.model.service;

import com.mauricio.gamestore.model.dao.CustomerDAO;
import com.mauricio.gamestore.model.entity.Customer;
import com.mauricio.gamestore.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    public List<Customer> getAllCustomers() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            CustomerDAO dao = new CustomerDAO(conn);
            return dao.getAllCustomers();
        } catch (SQLException e) {
            System.err.println("Erro ao listar clientes: " + e.getMessage());
        }
        return new ArrayList<>();
    }
}
