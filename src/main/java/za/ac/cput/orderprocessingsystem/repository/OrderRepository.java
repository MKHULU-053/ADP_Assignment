package za.ac.cput.orderprocessingsystem.repository;

import za.ac.cput.orderprocessingsystem.domain.Order;

import java.util.Date;
import java.util.List;
/*OrderRepository.java
OrderRepository model class
Author : Ntabeleng Shuma(230575129)*/

public interface OrderRepository extends Repository<Order, Integer>{

    List<Order> findOrdersByCustomer(int customerId);
    List<Order> findOrdersByProduct(int productId);
    List<Order> findOrdersByDateRange(Date startDate, Date endDate);

}
