package com.mauricio.gamestore.controller;

import com.mauricio.gamestore.model.entity.Customer;
import com.mauricio.gamestore.model.service.CustomerService;
import java.util.List;

public class CustomerController {
    private final CustomerService customerService;

    public CustomerController() {
        this.customerService = new CustomerService();
    }

    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}
