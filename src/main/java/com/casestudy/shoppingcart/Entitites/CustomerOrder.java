package com.casestudy.shoppingcart.Entitites;

import javax.persistence.*;
import java.util.List;


@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    private String status;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "order")
    private List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userID")
    private User user;

    public CustomerOrder() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CustomerOrder(User user) {
        this.user = user;
    }

    public CustomerOrder( User user,String status) {
        this.status = status;
        this.user = user;
    }

    public CustomerOrder(int orderId, String status, List<OrderItem> orderItems) {
        this.orderId = orderId;
        this.status = status;
        this.orderItems = orderItems;
    }
}
