package za.ac.cput.orderprocessingsystem.repository.impl;

import za.ac.cput.orderprocessingsystem.domain.Customer;
import za.ac.cput.orderprocessingsystem.factory.CustomerFactory;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

/* CustomerRepositoryTest.java
CustomerRepositoryTest model class
Author: Nicholus Sithole (220104336)
Date: 23 March 2025
*/

public class CustomerRepositoryImlTest {
    private CustomerRepositoryImpl repository;

    @Before
    public void setUp() throws Exception {
        repository = CustomerRepositoryImpl.getInstance();
    }

    // Existing CRUD tests...

    @Test
    public void testFindCustomersByName() {
        List<Customer> johns = repository.findCustomersByName("john");
        assertEquals(1, johns.size());
        assertEquals("John Doe", johns.get(0).getCustomerName());
    }

    @Test
    public void testFindCustomerByPhone() {
        Customer customer = repository.findCustomerByPhone("0211234567");
        assertNotNull(customer);
        assertEquals("John Doe", customer.getCustomerName());
    }

    @Test
    public void testFindCustomersByLocation() {
        List<Customer> capeTownCustomers = repository.findCustomersByLocation("Cape Town");
        assertEquals(1, capeTownCustomers.size());
        assertEquals("John Doe", capeTownCustomers.get(0).getCustomerName());
    }

    @Test
    public void testGetActiveCustomers() {
        List<Customer> activeCustomers = repository.getActiveCustomers();
        assertTrue(activeCustomers.size() >= 3); // Our test data has 3 customers
    }

    @Test
    public void testCountCustomers() {
        assertEquals(3, repository.countCustomers());
    }

    @Test
    public void testSearchCustomers() {
        // Search by name only
        List<Customer> nameResults = repository.searchCustomers("Jane", null, null);
        assertEquals(1, nameResults.size());
        assertEquals("Jane Smith", nameResults.get(0).getCustomerName());

        // Search by location only
        List<Customer> locationResults = repository.searchCustomers(null, "Johannesburg", null);
        assertEquals(1, locationResults.size());
        assertEquals("Jane Smith", locationResults.get(0).getCustomerName());

        // Search by phone only
        List<Customer> phoneResults = repository.searchCustomers(null, null, "0319876543");
        assertEquals(1, phoneResults.size());
        assertEquals("Robert Johnson", phoneResults.get(0).getCustomerName());

        // Combined search
        List<Customer> combinedResults = repository.searchCustomers("Robert", "Durban", "0319876543");
        assertEquals(1, combinedResults.size());
    }
}
