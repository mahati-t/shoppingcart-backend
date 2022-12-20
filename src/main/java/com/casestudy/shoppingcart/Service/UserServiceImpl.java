package com.casestudy.shoppingcart.Service;

import com.casestudy.shoppingcart.Entitites.LoginUser;
import com.casestudy.shoppingcart.Entitites.User;
import com.casestudy.shoppingcart.Repository.LoginRepository;
import com.casestudy.shoppingcart.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginRepository loginRepository;


    @Override
    public ResponseEntity<User> userLogin(User user) {
        User u = userRepository.ValidateUsernameAndPassword(user.getEmail(),user.getPassword());
        if(u == null){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        else{
            loginRepository.save(new LoginUser(u.getUserID()));
            return new ResponseEntity<>(u,HttpStatus.OK);
        }

    }

    @Override
    public ResponseEntity<String> userSignup(User user) {
        String emailId = user.getEmail();
        User u = userRepository.findByEmail(emailId);
        if(u == null){
            userRepository.save(new User(user.getName(),user.getEmail(),user.getPassword()));
            User newUser = userRepository.findByEmail(emailId);
            return  new ResponseEntity<>( "userId: " + newUser.getUserID(),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("user already Exist",HttpStatus.BAD_REQUEST);
        }

    }


    @Override
    public ResponseEntity userLogout(int userId) {
        LoginUser loginUser = loginRepository.findByUserId(userId);
        if(loginUser == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            loginRepository.delete(loginUser);
            return new ResponseEntity(HttpStatus.OK);
        }

    }

    @Override
    public ResponseEntity<User> getProfileByUserId(int userId) {
        User user = userRepository.getProfileByUserId(userId);
        if (user == null) {
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {

            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<User> updateProfileOfUser(User user) {
        int r = userRepository.updateUserProfile(user.getName(),user.getEmail(),user.getPhoneNumber(),user.getStreet(),user.getCity(),user.getState(),user.getPinCode(),user.getUserID());
        User updatedResponse = userRepository.getProfileByUserId(user.getUserID());
        return new ResponseEntity<>(updatedResponse,HttpStatus.OK);
    }


}
