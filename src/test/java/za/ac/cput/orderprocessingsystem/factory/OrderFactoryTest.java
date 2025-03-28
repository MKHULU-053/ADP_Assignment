package za.ac.cput.orderprocessingsystem.factory;

import za.ac.cput.orderprocessingsystem.domain.Order;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class OrderFactoryTest {
    @Test
    public void testCreateOrder() {
        Date orderDate = new Date();
        Order order = OrderFactory.createOrder(1, 1001, 2001, 1500.99f, orderDate);

        assertNotNull(order);
        assertEquals(1, order.getOrderId());
        assertEquals(1001, order.getCustomerId());
        assertEquals(2001, order.getProductId());
        assertEquals(1500.99f, order.getAmount(), 0.001);
        assertEquals(orderDate, order.getOrderDate());
    }

    @Test
    public void testOrderEquality() {
        Date orderDate = new Date();
        Order order1 = OrderFactory.createOrder(1, 1001, 2001, 1500.99f, orderDate);
        Order order2 = OrderFactory.createOrder(1, 1002, 2002, 2000.50f, orderDate);

        assertEquals(order1, order2);
    }
}
