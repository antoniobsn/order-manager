package com.absn.order_manager.objectmother;

import com.absn.order_manager.model.Item;
import com.absn.order_manager.model.Order;
import com.absn.order_manager.model.OrderItem;
import com.absn.order_manager.model.OrderStatus;

import java.math.BigDecimal;
import java.util.List;

public class OrderObjectMother {

    public static Order createDefault() {
        return new Order(
                1L,
                List.of(createItem(BigDecimal.valueOf(10), 2)),
                OrderStatus.PENDING
        );
    }

    public static Order createWithCustomer(Long customerId) {
        return new Order(
                customerId,
                List.of(createItem(BigDecimal.valueOf(10), 2)),
                OrderStatus.PENDING
        );
    }

    public static Order createWithStatus(OrderStatus status) {
        return new Order(
                1L,
                List.of(createItem(BigDecimal.valueOf(10), 2)),
                status
        );
    }

    public static Order createWithItems(List<OrderItem> items) {
        return new Order(
                1L,
                items,
                OrderStatus.PENDING
        );
    }

    public static Order createEmptyOrder() {
        return new Order(
                1L,
                List.of(),
                OrderStatus.PENDING
        );
    }

    public static Order createExpensiveOrder() {
        Order order = new Order(
                1L,
                List.of(
                        createItem(BigDecimal.valueOf(100), 1),
                        createItem(BigDecimal.valueOf(50), 2)
                ),
                OrderStatus.CONFIRMED
        );
        order.setId(1L);
        return order;
    }

    public static Order createCheapOrder() {
        return new Order(
                2L,
                List.of(
                        createItem(BigDecimal.valueOf(5), 1)
                ),
                OrderStatus.PENDING
        );
    }

    private static OrderItem createItem(BigDecimal unitPrice, int quantity) {

        Item item = new Item("Old skool");
        item.setId(1L);

        return new OrderItem(item.getId(), quantity, unitPrice);
    }
}
