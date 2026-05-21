package com.absn.order_manager.domain;

import com.absn.order_manager.objectmother.OrderObjectMother;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void shouldReturnZeroWhenOrderHasNoItems() {

        Order order = OrderObjectMother.createEmptyOrder();

        BigDecimal result = order.calculateTotal();

        assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    void shouldCalculateTotalWithSingleItem() {

        Order order = OrderObjectMother.createCheapOrder();

        BigDecimal result = order.calculateTotal();

        assertEquals(BigDecimal.valueOf(5), result);
    }

    @Test
    void shouldCalculateTotalWithMultipleItems() {

        Order order = OrderObjectMother.createExpensiveOrder();

        BigDecimal result = order.calculateTotal();

        assertEquals(BigDecimal.valueOf(200), result);
    }
}