package za.ac.cput.orderprocessingsystem.factory;

import za.ac.cput.orderprocessingsystem.domain.Order;
import java.util.Date;

public class OrderFactory {
    public static Order createOrder(int orderId, int customerId, int productId, float amount, Date orderDate) {
        return new Order.Builder()
                .orderId(orderId)
                .customerId(customerId)
                .productId(productId)
                .amount(amount)
                .orderDate(orderDate)
                .build();
    }
}
