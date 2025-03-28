package za.ac.cput.orderprocessingsystem.domain;

import java.util.Objects;

/* Customer.java
Customer model class
Author: Nicholus Sithole (220104336)
Date: 14 March 2025
*/

public class Customer {
    private int customerID;
    private String customerName;
    private String address;
    private String phone;

    private Customer(Builder builder) {
        this.customerID = builder.customerID;
        this.customerName = builder.customerName;
        this.address = builder.address;
        this.phone = builder.phone;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerID == customer.customerID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerID);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public static class Builder {
        private int customerID;
        private String customerName;
        private String address;
        private String phone;

        public Builder customerID(int customerID) {
            this.customerID = customerID;
            return this;
        }

        public Builder customerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

}
