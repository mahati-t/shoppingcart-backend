package com.casestudy.shoppingcart.Controller;

import com.casestudy.shoppingcart.Entitites.CustomerOrder;
import com.casestudy.shoppingcart.Entitites.OrderItem;
import com.casestudy.shoppingcart.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping( "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{userId}/createOrder")
    public ResponseEntity<List<OrderItem>> createOrder(@PathVariable("userId") Integer userId){
        return orderService.createOrder(userId);
    }

    @GetMapping("/{userId}/getOrders")
    public  ResponseEntity<List<CustomerOrder>> getOrders(@PathVariable("userId") Integer userId){
        return orderService.getOrders(userId);
    }

    @GetMapping("/orderDetails/{orderId}")
    public ResponseEntity<List<OrderItem>> getOrderItemsByOrderId(@PathVariable("orderId") Integer orderId){
        return orderService.getOrderItemsByOrderId(orderId);
    }
}
