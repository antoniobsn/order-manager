package com.absn.order_manager.adapter.in.web;

import com.absn.order_manager.model.Order;
import com.absn.order_manager.model.port.in.OrderUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final OrderUseCase orderUseCase;

    public CustomerController(OrderUseCase orderUseCase) {
        this.orderUseCase = orderUseCase;
    }

    @GetMapping("{customerId}/orders")
    public ResponseEntity<List<Order>>orderByCustomer(@PathVariable Long customerId) {
        List<Order> orders = orderUseCase.getOrdersByCustomer(customerId);

        if (orders.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(orders);
    }
}
