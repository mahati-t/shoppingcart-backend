package com.casestudy.shoppingcart.Entitites;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int cartId;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = CartItem.class,mappedBy = "cart")
    private List<CartItem> cartItems;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="user_id")
    private User user;

    public Cart() {

    }

    public Cart(User user) {
        this.user = user;
    }

    public Cart(int cartId, List<CartItem> cartItems) {
        this.cartId = cartId;
        this.cartItems = cartItems;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public List<CartItem> getCartItemList() {
        return cartItems;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItems = cartItemList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cart(int cartId, List<CartItem> cartItemList, User user) {
        this.cartId = cartId;
        this.cartItems = cartItemList;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", cartItemList=" + cartItems +
                ", user=" + user +
                '}';
    }
}
