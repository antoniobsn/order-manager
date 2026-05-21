package com.absn.order_manager.application;

import com.absn.order_manager.domain.Order;
import com.absn.order_manager.domain.OrderStatus;
import com.absn.order_manager.domain.port.in.OrderUseCase;
import com.absn.order_manager.domain.port.out.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService implements OrderUseCase {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getOrdersByCustomer(Long customerId) {
        return orderRepository.findByCustomer(customerId);
    }

    @Override
    public Map<OrderStatus, List<Order>> groupByStatus(List<Order> orders) {
        return orders.stream().collect(Collectors.groupingBy(Order::getOrderStatus));
    }

    @Override
    public Optional<Order> findMostExpensive(List<Order> orders) {
        return orders.stream().max(Comparator.comparing(Order::calculateTotal));
    }
}
