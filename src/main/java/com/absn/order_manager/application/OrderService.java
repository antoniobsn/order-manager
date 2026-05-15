package com.absn.order_manager.application;

import com.absn.order_manager.model.Order;
import com.absn.order_manager.model.OrderItem;
import com.absn.order_manager.model.OrderStatus;
import com.absn.order_manager.model.port.in.OrderUseCase;
import com.absn.order_manager.model.port.out.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    public BigDecimal calculateTotal(Order order) {

        List<OrderItem> orderItems = order.getOrderItems();

        BigDecimal total = orderItems.stream()
                .map(item -> item.getUnitPrice()
                        .multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return total;
    }

    @Override
    public List<Order> getOrdersByCustomer(Long customerId) {
        return orderRepository.findByCustomer(customerId);
    }

    @Override
    public Map<OrderStatus, List<Order>> groupByStatus(List<Order> orders) {

        Map<OrderStatus, List<Order>> ordersByStatus = orders.stream()
                .collect(Collectors.groupingBy(Order::getOrderStatus));

        return ordersByStatus;
    }

    @Override
    public Optional<Order> findMostExpensive(List<Order> orders) {

        Optional<Order> mostExpensive = orders.stream()
                .max((o1, o2) -> calculateTotal(o1).compareTo(calculateTotal(o2)));

        return mostExpensive;
    }
}
