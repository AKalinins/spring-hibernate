package com.example.demo.dao;

import com.example.demo.domain.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();
    void saveCustomer(Customer customer);
    Customer getCustomerById(int id);
    void deleteCustomer(int id);
}
