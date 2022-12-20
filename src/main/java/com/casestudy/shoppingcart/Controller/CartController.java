package com.casestudy.shoppingcart.Controller;

import com.casestudy.shoppingcart.Entitites.Cart;
import com.casestudy.shoppingcart.Entitites.CartItem;
import com.casestudy.shoppingcart.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/cart")
public class CartController  {

    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}/getCart")
    public ResponseEntity<Cart> getCart(@PathVariable("userId") Integer userId){
        return cartService.getCartByUserId(userId);
    }

    @GetMapping("/{userId}/getCartItem/{cartitemId}")
    public ResponseEntity<CartItem> getCartItem(@PathVariable("userId") Integer userId, @PathVariable("cartitemId") Integer cartItemId){
        return cartService.getCartItem(cartItemId,userId);
    }

    @GetMapping("/{userId}/add/{productId}")
    public ResponseEntity<CartItem> addCartItem(@PathVariable("userId") Integer userId, @PathVariable("productId") Integer productId){
        return cartService.addCartItem(userId,productId);
    }

    @GetMapping("/{userId}/remove/{productId}")
    public ResponseEntity<String> RemoveFromCart(@PathVariable("userId") Integer userId, @PathVariable("productId") Integer productId){
        return cartService.deleteCartItem(productId,userId);
    }

    @PostMapping(value= "/{userId}/changeQuantity/{productId}")
    public ResponseEntity<CartItem> changeProductQuantity(@PathVariable("userId") Integer userId, @PathVariable("productId") Integer productId, @RequestBody int quantity){
        return cartService.changeProductQuantity(productId,userId,quantity);
    }
    @GetMapping(value= "/{userId}/increaseQuantity/{productId}")
    public ResponseEntity<CartItem> increaseQuantity(@PathVariable("userId") Integer userId, @PathVariable("productId") Integer productId){
        return cartService.increaseProductQuantity(productId,userId);
    }
    @GetMapping(value= "/{userId}/decreaseQuantity/{productId}")
    public ResponseEntity<CartItem> decreaseQuantity(@PathVariable("userId") Integer userId, @PathVariable("productId") Integer productId){
        return cartService.decreaseProductQuantity(productId,userId);
    }


}
