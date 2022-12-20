package com.casestudy.shoppingcart.Service;

import com.casestudy.shoppingcart.Entitites.Cart;
import com.casestudy.shoppingcart.Entitites.CartItem;
import com.casestudy.shoppingcart.Entitites.CustomerOrder;
import com.casestudy.shoppingcart.Entitites.OrderItem;
import com.casestudy.shoppingcart.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;



    @Override
    public ResponseEntity<List<OrderItem>> createOrder(int userId) {
        Cart cart = cartRepository.getCartByUserId(userId);
        List<CartItem> cartItems = cart.getCartItemList();
        if(cartItems.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
        else {
                CustomerOrder activeOrder = new CustomerOrder(userRepository.getProfileByUserId(userId), "active");
                orderRepository.save(activeOrder);
                List<OrderItem> orderItemsList = new ArrayList<>();

                for (CartItem ci : cartItems) {
                    OrderItem orderItem = new OrderItem(ci.getProduct(), ci.getQuantity(), activeOrder);
                    orderItemRepository.save(orderItem);
                    orderItemsList.add(orderItem);
                }
                int orderUpdated = orderRepository.updateStatusOfOrder("complete",activeOrder.getOrderId());
                int clearCart = cartItemRepository.ClearCartItems(cart.getCartId());
               List<OrderItem> order = orderRepository.getCompletedOrderByOrderId(activeOrder.getOrderId());
                return new ResponseEntity<>(order, HttpStatus.OK);

        }

    }

    @Override
    public ResponseEntity<List<CustomerOrder>> getOrders(int userId) {
        List<CustomerOrder> ordersList= orderRepository.getOrdersByUserId(userId,"complete");
        return new ResponseEntity<>(ordersList,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<OrderItem>> getOrderItemsByOrderId(int orderId) {
        List<OrderItem> orderItems = orderRepository.getCompletedOrderByOrderId(orderId);
        return new ResponseEntity<>(orderItems,HttpStatus.OK);
    }
}
