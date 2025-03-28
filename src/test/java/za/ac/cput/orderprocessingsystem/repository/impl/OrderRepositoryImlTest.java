package za.ac.cput.orderprocessingsystem.repository.impl;

import za.ac.cput.orderprocessingsystem.domain.Order;
import za.ac.cput.orderprocessingsystem.factory.OrderFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
/* Order.java
   Order model class
   Author: Avela Silo (230081525)
 */
public class OrderRepositoryImplTest {
    private OrderRepositoryImpl repository;
    private Date today;
    private Date yesterday;

    @Before
    public void setUp() throws Exception {
        repository = OrderRepositoryImpl.getInstance();

        today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        yesterday = cal.getTime();
    }

    @Test
    public void testCreate() {
        Order newOrder = OrderFactory.createOrder(4, 1003, 2003, 3000.00f, today);
        Order created = repository.create(newOrder);
        assertEquals(newOrder, created);
    }

    @Test
    public void testRead() {
        Order order = repository.read(1);
        assertNotNull(order);
        assertEquals(1001, order.getCustomerId());
    }

    @Test
    public void testUpdate() {
        Order order = repository.read(1);
        Order updatedOrder = new Order.Builder()
                .orderId(order.getOrderId())
                .customerId(1005) // changed
                .productId(order.getProductId())
                .amount(2000.00f) // changed
                .orderDate(order.getOrderDate())
                .build();

        repository.update(updatedOrder);
        Order retrieved = repository.read(1);
        assertEquals(1005, retrieved.getCustomerId());
        assertEquals(2000.00f, retrieved.getAmount(), 0.001);
    }

    @Test
    public void testDelete() {
        repository.delete(1);
        assertNull(repository.read(1));
    }

    @Test
    public void testFindOrdersByCustomer() {
        List<Order> customerOrders = repository.findOrdersByCustomer(1001);
        assertEquals(2, customerOrders.size());
    }

    @Test
    public void testFindOrdersByProduct() {
        List<Order> productOrders = repository.findOrdersByProduct(2001);
        assertEquals(2, productOrders.size());
    }

    @Test
    public void testFindOrdersByDateRange() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -2);
        Date twoDaysAgo = cal.getTime();

        List<Order> recentOrders = repository.findOrdersByDateRange(yesterday, today);
        assertEquals(3, recentOrders.size());

        List<Order> yesterdayOrders = repository.findOrdersByDateRange(twoDaysAgo, yesterday);
        assertEquals(1, yesterdayOrders.size());
    }
}

