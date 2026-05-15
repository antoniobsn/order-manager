package com.absn.order_manager.model.port.out;

import com.absn.order_manager.model.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> findByCustomer(Long customerId);
}
