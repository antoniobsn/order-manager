package com.absn.order_manager.domain;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    private Long id;
    private Long customerId;
    private List<OrderItem> orderItems;
    private OrderStatus orderStatus;

    public Order(Long customerId, List<OrderItem> orderItems, OrderStatus orderStatus) {
        this.customerId = customerId;
        this.orderItems = orderItems;
        this.orderStatus = orderStatus;
    }

    public BigDecimal calculateTotal() {

        return orderItems.stream()
                .map(item -> item.getUnitPrice()
                        .multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
}
