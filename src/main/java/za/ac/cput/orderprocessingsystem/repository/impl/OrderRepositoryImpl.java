package za.ac.cput.orderprocessingsystem.repository.impl;

import za.ac.cput.orderprocessingsystem.repository.OrderRepository;
import za.ac.cput.orderprocessingsystem.domain.Order;

import java.util.*;
import java.util.stream.Collectors;

public class OrderRepositoryImpl implements OrderRepository {
    private static OrderRepositoryImpl repository = null;
    private Map<Integer, Order> orders;

    private OrderRepositoryImpl() {
        orders = new HashMap<>();
        initializeTestData();
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders.values());
    }

    private void initializeTestData() {
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date yesterday = cal.getTime();

        Order o1 = new Order.Builder()
                .orderId(1)
                .customerId(1001)
                .productId(2001)
                .amount(1500.99f)
                .orderDate(yesterday)
                .build();

        Order o2 = new Order.Builder()
                .orderId(2)
                .customerId(1001)
                .productId(2002)
                .amount(2500.50f)
                .orderDate(today)
                .build();

        Order o3 = new Order.Builder()
                .orderId(3)
                .customerId(1002)
                .productId(2001)
                .amount(1800.00f)
                .orderDate(today)
                .build();

        orders.put(o1.getOrderId(), o1);
        orders.put(o2.getOrderId(), o2);
        orders.put(o3.getOrderId(), o3);
    }

    public static OrderRepositoryImpl getInstance() {
        if (repository == null) {
            repository = new OrderRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Order create(Order order) {
        orders.put(order.getOrderId(), order);
        return order;
    }

    @Override
    public Order read(Integer id) {
        return orders.get(id);
    }

    @Override
    public Order update(Order order) {
        orders.put(order.getOrderId(), order);
        return order;
    }

    @Override
    public void delete(Integer id) {
        orders.remove(id);
    }

    @Override
    public List<Order> findOrdersByCustomer(int customerId) {
        return orders.values().stream()
                .filter(o -> o.getCustomerId() == customerId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> findOrdersByProduct(int productId) {
        return orders.values().stream()
                .filter(o -> o.getProductId() == productId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> findOrdersByDateRange(Date startDate, Date endDate) {
        return orders.values().stream()
                .filter(o -> !o.getOrderDate().before(startDate) && !o.getOrderDate().after(endDate))
                .collect(Collectors.toList());
    }
}
