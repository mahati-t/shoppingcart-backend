package com.casestudy.shoppingcart.Service;

import com.casestudy.shoppingcart.Entitites.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    public ResponseEntity<User> userLogin(User user);

    public ResponseEntity<String> userSignup(User user);

    public ResponseEntity<String> userLogout(int userId);

    public  ResponseEntity<User> getProfileByUserId(int userId);

    public ResponseEntity<User> updateProfileOfUser(User user);



}
