package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.OrderDTO;
import com.bridgelabz.bookstore.model.OrderData;

import java.util.List;

public interface IOrderService {
    String insert(OrderDTO orderDTO);

    List<OrderData> getAllOrder(String token);

    OrderData getOrderById(String token);

    OrderData cancelOrderById(String token, int userId);
}
