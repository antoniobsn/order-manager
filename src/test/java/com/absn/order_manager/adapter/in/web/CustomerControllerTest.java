package com.absn.order_manager.adapter.in.web;

import com.absn.order_manager.domain.Order;
import com.absn.order_manager.domain.port.in.OrderUseCase;
import com.absn.order_manager.objectmother.OrderObjectMother;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderUseCase orderUseCase;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnOrdersWhenCustomerHasOrders() throws Exception {
        Long customerId = 1L;

        Order order = OrderObjectMother.createExpensiveOrder();

        when(orderUseCase.getOrdersByCustomer(customerId))
                .thenReturn(List.of(order));

        mockMvc.perform(get("/api/customer/{customerId}/orders", customerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].customerId").value(customerId));
    }

    @Test
    void shouldReturn404WhenCustomerHasNoOrders() throws Exception {
        Long customerId = 2L;

        when(orderUseCase.getOrdersByCustomer(customerId))
                .thenReturn(List.of());

        mockMvc.perform(get("/api/customer/{customerId}/orders", customerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}