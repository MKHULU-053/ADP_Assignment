package za.ac.cput.orderprocessingsystem.factory;

import za.ac.cput.orderprocessingsystem.domain.Customer;

/* CustomerFactory.java
CustomerFactory model class
Author: Nicholus Sithole (220104336)
Date: 17 March 2025
*/

public class CustomerFactory {
    public static Customer createCustomer(int customerID, String customerName, String address, String phone) {
        return new Customer.Builder()
                .customerID(customerID)
                .customerName(customerName)
                .address(address)
                .phone(phone)
                .build();
    }
}
