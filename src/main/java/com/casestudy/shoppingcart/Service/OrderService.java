package com.casestudy.shoppingcart.Service;

import com.casestudy.shoppingcart.Entitites.CustomerOrder;
import com.casestudy.shoppingcart.Entitites.OrderItem;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    ResponseEntity<List<OrderItem>> createOrder(int userId);

    ResponseEntity<List<CustomerOrder>> getOrders(int userId);

    ResponseEntity<List<OrderItem>> getOrderItemsByOrderId(int orderId);

}
