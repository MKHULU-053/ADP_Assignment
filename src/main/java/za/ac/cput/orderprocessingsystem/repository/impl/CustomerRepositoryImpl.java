package za.ac.cput.orderprocessingsystem.repository.impl;

import za.ac.cput.orderprocessingsystem.domain.Customer;
import za.ac.cput.orderprocessingsystem.repository.CustomerRepository;

import java.util.*;
import java.util.stream.Collectors;

/* CustomerRepositoryImpl.java
CustomerRepositoryImpl model class
Author: Nicholus Sithole (220104336)
Date: 23 March 2025
*/

public class CustomerRepositoryImpl implements CustomerRepository {
    private static CustomerRepositoryImpl repository = null;
    private Map<Integer, Customer> customers;

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    private CustomerRepositoryImpl() {
        customers = new HashMap<>();
        // Initialize with some test data
        initializeTestData();
    }

    private void initializeTestData() {
        Customer c1 = new Customer.Builder()
                .customerID(1)
                .customerName("John Doe")
                .address("123 Main St, Cape Town")
                .phone("0211234567")
                .build();

        Customer c2 = new Customer.Builder()
                .customerID(2)
                .customerName("Jane Smith")
                .address("456 Oak Ave, Johannesburg")
                .phone("0117654321")
                .build();

        Customer c3 = new Customer.Builder()
                .customerID(3)
                .customerName("Robert Johnson")
                .address("789 Pine Rd, Durban")
                .phone("0319876543")
                .build();

        customers.put(c1.getCustomerID(), c1);
        customers.put(c2.getCustomerID(), c2);
        customers.put(c3.getCustomerID(), c3);
    }

    public static CustomerRepositoryImpl getInstance() {
        if (repository == null) {
            repository = new CustomerRepositoryImpl();
        }
        return repository;
    }

    // Basic CRUD operations
    @Override
    public Customer create(Customer customer) {
        customers.put(customer.getCustomerID(), customer);
        return customer;
    }

    @Override
    public Customer read(Integer id) {
        return customers.get(id);
    }

    @Override
    public Customer update(Customer customer) {
        customers.put(customer.getCustomerID(), customer);
        return customer;
    }

    @Override
    public void delete(Integer id) {
        customers.remove(id);
    }

    // Custom query implementations
    @Override
    public List<Customer> findCustomersByName(String name) {
        return customers.values().stream()
                .filter(c -> c.getCustomerName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Customer findCustomerByPhone(String phone) {
        return customers.values().stream()
                .filter(c -> c.getPhone().equals(phone))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Customer> findCustomersByLocation(String location) {
        return customers.values().stream()
                .filter(c -> c.getAddress().toLowerCase().contains(location.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> getActiveCustomers() {
        // In a real system, this would join with orders table
        // For now, we'll return all customers as "active"
        return new ArrayList<>(customers.values());
    }

    @Override
    public int countCustomers() {
        return customers.size();
    }

    @Override
    public List<Customer> searchCustomers(String name, String location, String phone) {
        return customers.values().stream()
                .filter(c ->
                        (name == null || c.getCustomerName().toLowerCase().contains(name.toLowerCase())) &&
                                (location == null || c.getAddress().toLowerCase().contains(location.toLowerCase())) &&
                                (phone == null || c.getPhone().equals(phone)))
                                        .collect(Collectors.toList());
    }
}
