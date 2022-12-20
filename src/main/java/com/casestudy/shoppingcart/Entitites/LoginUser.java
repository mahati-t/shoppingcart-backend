package com.casestudy.shoppingcart.Entitites;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoginUser {
    @Id
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LoginUser(int userId) {
        this.userId = userId;
    }

    public LoginUser() {
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "userId=" + userId +
                '}';
    }
}
