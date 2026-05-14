package com.mauricio.gamestore.controller;

import com.mauricio.gamestore.model.dto.request.CustomerRequestDTO;
import com.mauricio.gamestore.model.dto.response.CustomerResponseDTO;
import com.mauricio.gamestore.model.entity.Customer;
import com.mauricio.gamestore.model.service.CustomerService;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerController {
    private final CustomerService customerService;

    public CustomerController() {
        this.customerService = new CustomerService();
    }

    public List<CustomerResponseDTO> getAllCustomers() {
        return customerService.getAllCustomers().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public CustomerResponseDTO findById(int id) {
        Customer customer = customerService.findById(id);
        return (customer != null) ? convertToResponseDTO(customer) : null;
    }

    public boolean registerCustomer(CustomerRequestDTO request) {
        Customer customer = new Customer(request.getName(), request.getEmail(), request.getAge());
        return customerService.registerCustomer(customer);
    }

    public boolean updateCustomer(int id, CustomerRequestDTO request) {
        Customer customer = new Customer(id, request.getName(), request.getEmail(), request.getAge());
        return customerService.updateCustomer(customer);
    }

    private CustomerResponseDTO convertToResponseDTO(Customer customer) {
        return new CustomerResponseDTO(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getAge()
        );
    }
}
