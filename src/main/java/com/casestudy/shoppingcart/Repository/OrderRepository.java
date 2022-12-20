package com.casestudy.shoppingcart.Repository;

import com.casestudy.shoppingcart.Entitites.Cart;
import com.casestudy.shoppingcart.Entitites.CustomerOrder;
import com.casestudy.shoppingcart.Entitites.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@EnableJpaRepositories
@Repository
public interface OrderRepository extends JpaRepository<CustomerOrder,Integer> {


//    @Query(value="select cor from CustomerOrder cor where cor.user.userID=:uid and cor.status=:s")
//    CustomerOrder getActiveOrderByUserId(@Param("uid") int userId, @Param("s") String status);


    @Modifying
    @Transactional
    @Query(value="update CustomerOrder cor set cor.status=:status where cor.orderId=:orderId")
    int updateStatusOfOrder(@Param("status") String status, @Param("orderId") int orderId );

    @Query(value="select order.orderItems from CustomerOrder order where order.orderId=:orderId")
    List<OrderItem> getCompletedOrderByOrderId(@Param("orderId") int orderId);


    @Query(value="select order from CustomerOrder order where order.user.userID=:uid and order.status=:s")
   List<CustomerOrder> getOrdersByUserId(@Param("uid") int UserId, @Param("s") String status);

}
