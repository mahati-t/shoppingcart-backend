package com.casestudy.shoppingcart.Repository;

import com.casestudy.shoppingcart.Entitites.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {
}
