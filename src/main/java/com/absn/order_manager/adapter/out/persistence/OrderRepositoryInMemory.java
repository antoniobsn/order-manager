package com.absn.order_manager.adapter.out.persistence;

import com.absn.order_manager.model.Order;
import com.absn.order_manager.model.OrderItem;
import com.absn.order_manager.model.OrderStatus;
import com.absn.order_manager.model.port.out.OrderRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepositoryInMemory implements OrderRepository {

    private final Map<Long, Order> orderEntity = new HashMap<>();

    private Long sequence = 1L;

    public OrderRepositoryInMemory() {

        Order order1 = new Order(sequence, List.of(new OrderItem(sequence, 1, new BigDecimal(70))), OrderStatus.PENDING);
        order1.setId(sequence++);
        orderEntity.put(sequence, order1);

        Order order2 = new Order(sequence, List.of(new OrderItem(sequence, 2, new BigDecimal(80))), OrderStatus.CONFIRMED);
        order2.setId(sequence++);
        orderEntity.put(sequence, order2);

        Order order3 = new Order(sequence, List.of(new OrderItem(sequence, 3, new BigDecimal(90))), OrderStatus.SHIPPED);
        order3.setId(sequence++);
        orderEntity.put(sequence, order3);

        Order order4 = new Order(sequence, List.of(new OrderItem(sequence, 4, new BigDecimal(100))), OrderStatus.CANCELLED);
        order4.setId(sequence++);
        orderEntity.put(sequence, order4);

        Order order5 = new Order(sequence, List.of(new OrderItem(sequence, 5, new BigDecimal(110))), OrderStatus.CANCELLED);
        order5.setId(sequence++);
        orderEntity.put(sequence, order5);
    }

    @Override
    public List<Order> findByCustomer(Long customerId) {
        return orderEntity.values().stream()
                .filter(order -> order.getCustomerId().equals(customerId))
                .toList();
    }
}
