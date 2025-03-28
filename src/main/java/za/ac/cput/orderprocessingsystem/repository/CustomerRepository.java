package za.ac.cput.orderprocessingsystem.repository;

import za.ac.cput.orderprocessingsystem.domain.Customer;
import java.util.List;

public interface CustomerRepository extends Repository<Customer, Integer>{
    // Find customers by name (partial match)
    List<Customer> findCustomersByName(String name);

    // Find customers by phone number (exact match)
    Customer findCustomerByPhone(String phone);

    // Find customers in a specific area (address contains location)
    List<Customer> findCustomersByLocation(String location);

    // Get customers who have placed orders (for reporting)
    List<Customer> getActiveCustomers();

    // Count total customers in the system
    int countCustomers();

    // Search customers with multiple criteria
    List<Customer> searchCustomers(String name, String location, String phone);
}
