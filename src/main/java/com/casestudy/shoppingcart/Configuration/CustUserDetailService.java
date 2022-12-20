package com.casestudy.shoppingcart.Configuration;

import com.casestudy.shoppingcart.Entitites.User;
import com.casestudy.shoppingcart.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        CustUserDetails userDetails = null;
        if(user !=null) {
            userDetails = new CustUserDetails();
            userDetails.setUser(user);
        }else {
            throw new UsernameNotFoundException("User does not exists with the given email");
        }
        return userDetails;
    }
}
