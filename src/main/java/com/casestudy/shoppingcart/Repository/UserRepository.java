package com.casestudy.shoppingcart.Repository;

import com.casestudy.shoppingcart.Entitites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "select u from User u where u.email =:email and u.password=:pass")
    public User ValidateUsernameAndPassword(@Param("email") String email, @Param("pass") String password);

    @Query(value = "select u from User  u where u.userID=:uid")
    public User getProfileByUserId(@Param("uid") int userId );

    @Modifying
    @Transactional
    @Query(value = "update User u Set u.name=:name, u.email=:email, u.phoneNumber=:phonenumber,u.street=:street, u.city=:city, u.state=:state, u.pinCode=:pinCode where u.userID=:userId")
    public int updateUserProfile(@Param("name") String name, @Param("email") String email, @Param("phonenumber") String phoneNumber, @Param("street") String street, @Param("city") String city, @Param("state") String state, @Param("pinCode") String pincode, @Param("userId") int userId );


    User findByEmail(String email);
}
