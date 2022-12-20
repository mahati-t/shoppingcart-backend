package com.casestudy.shoppingcart.Repository;

import com.casestudy.shoppingcart.Entitites.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Integer> {
    @Modifying
    @Transactional
    @Query(value="Delete from CartItem ci where ci.cart.cartId=:cartId")
    int ClearCartItems(@Param("cartId") int cartid);

}
