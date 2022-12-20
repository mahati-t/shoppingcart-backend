package com.casestudy.shoppingcart.Service;

import com.casestudy.shoppingcart.Entitites.Cart;
import com.casestudy.shoppingcart.Entitites.CartItem;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CartService {

     ResponseEntity<Cart> getCartByUserId(int userId);


     ResponseEntity<CartItem> getCartItem(int cartItemId, int userId);

     ResponseEntity<CartItem> addCartItem( int userId,int productId);

     ResponseEntity<String> deleteCartItem(int productId, int userId);

     ResponseEntity<CartItem> changeProductQuantity(int productId, int userId, int quantity);
     ResponseEntity<CartItem> increaseProductQuantity(int productId, int userId);
     ResponseEntity<CartItem> decreaseProductQuantity(int productId, int userId);
}
