package com.absn.order_manager.application;

import com.absn.order_manager.domain.Order;
import com.absn.order_manager.domain.OrderStatus;
import com.absn.order_manager.domain.port.out.OrderRepository;
import com.absn.order_manager.objectmother.OrderObjectMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    private Order order1;
    private Order order2;

    @BeforeEach
    void setUp() {
        order1 = OrderObjectMother.createCheapOrder();
        order2 = OrderObjectMother.createExpensiveOrder();
    }

    @Test
    void shouldReturnOrdersByCustomer() {

        Long customerId = 1L;

        when(orderRepository.findByCustomer(customerId)).thenReturn(List.of(order1, order2));

        List<Order> result = orderService.getOrdersByCustomer(customerId);

        assertEquals(2, result.size());
        assertEquals(order1, result.get(0));
        assertEquals(order2, result.get(1));
    }

    @Test
    void shouldGroupOrdersByStatus() {

        List<Order> orders = List.of(order1, order2);

        Map<OrderStatus, List<Order>> result = orderService.groupByStatus(orders);

        assertEquals(2, result.size());

        assertTrue(result.containsKey(OrderStatus.PENDING));
        assertTrue(result.containsKey(OrderStatus.CONFIRMED));

        assertEquals(1, result.get(OrderStatus.PENDING).size());
        assertEquals(1, result.get(OrderStatus.CONFIRMED).size());
    }

    @Test
    void shouldFindMostExpensiveOrder() {

        List<Order> orders = List.of(order1, order2);

        Optional<Order> result = orderService.findMostExpensive(orders);

        assertTrue(result.isPresent());
        assertEquals(order2, result.get());
    }

    @Test
    void shouldReturnEmptyOptionalWhenOrderListIsEmpty() {

        Optional<Order> result = orderService.findMostExpensive(List.of());

        assertTrue(result.isEmpty());
    }
}