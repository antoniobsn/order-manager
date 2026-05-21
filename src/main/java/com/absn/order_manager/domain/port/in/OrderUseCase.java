package com.absn.order_manager.domain.port.in;

import com.absn.order_manager.domain.Order;
import com.absn.order_manager.domain.OrderStatus;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface OrderUseCase {

    List<Order> getOrdersByCustomer(Long customerId);

    Map<OrderStatus, List<Order>> groupByStatus(List<Order> orders);

    Optional<Order> findMostExpensive(List<Order> orders);
}
