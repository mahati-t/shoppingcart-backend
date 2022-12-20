package com.casestudy.shoppingcart.Repository;

import com.casestudy.shoppingcart.Entitites.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<LoginUser,Integer> {
    LoginUser findByUserId(int Userid);
}
