package com.absn.order_manager.model.port.in;

import com.absn.order_manager.model.Order;
import com.absn.order_manager.model.OrderStatus;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface OrderUseCase {
    BigDecimal calculateTotal(Order order);

    List<Order> getOrdersByCustomer(Long customerId);

    Map<OrderStatus, List<Order>> groupByStatus(List<Order> orders);

    Optional<Order> findMostExpensive(List<Order> orders);
}
