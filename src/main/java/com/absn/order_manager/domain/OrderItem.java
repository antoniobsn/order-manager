package com.absn.order_manager.domain;

import java.math.BigDecimal;

public class OrderItem {
    private Long id;
    private Long itemId;
    private int quantity;
    private BigDecimal unitPrice;

    public OrderItem(Long itemId, int quantity, BigDecimal unitPrice) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }
}
