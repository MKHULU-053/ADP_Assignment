package za.ac.cput.orderprocessingsystem.factory;

import za.ac.cput.orderprocessingsystem.domain.Customer;
import za.ac.cput.junit.Before;
import za.ac.cput.junit.Test;
import static org.junit.Assert.*;

/* CustomerFectoryTest.java
CustomerFectoryTest model class
Author: Nicholus Sithole (220104336)
Date: 17 March 2025
*/

public class CustomerFactoryTest {
    @Test
    public void testCreateCustomer() {
        Customer customer = CustomerFactory.createCustomer(1, "John Doe", "123 Main St", "0211234567");
        assertNotNull(customer);
        assertEquals("John Doe", customer.getCustomerName());
    }

    @Test
    public void testCustomerEquality() {
        Customer customer1 = CustomerFactory.createCustomer(1, "John Doe", "123 Main St", "0211234567");
        Customer customer2 = CustomerFactory.createCustomer(1, "Jane Smith", "456 Oak Ave", "0217654321");

        assertEquals(customer1, customer2);
    }
}
