package com.casestudy.shoppingcart.Controller;

import com.casestudy.shoppingcart.Entitites.User;
import com.casestudy.shoppingcart.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<User>userLogin(@RequestBody User user){
        return userService.userLogin(user);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> userSignUp(@RequestBody User user){
        return userService.userSignup(user);
    }


    @PostMapping("/logout")
    public  ResponseEntity userLogout(@RequestBody int userId){
        return userService.userLogout(userId);
    }

    @GetMapping("/getprofile/{userId}")
    public ResponseEntity<User> getUserProfileByUserId(@PathVariable("userId") Integer userId){
        return userService.getProfileByUserId(userId);
    }

    @PostMapping("/updateprofile")
    public ResponseEntity<User> updateUserProfile(@RequestBody User user){
        return userService.updateProfileOfUser(user);
    }
}
