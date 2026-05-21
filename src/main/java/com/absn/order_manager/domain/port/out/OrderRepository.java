package com.absn.order_manager.domain.port.out;

import com.absn.order_manager.domain.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> findByCustomer(Long customerId);
}
