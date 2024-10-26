package com.example.order.repository;

import com.example.order.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<OrderModel,Integer> {
    @Query(value = "SELECT * FROM user_modal WHERE user_id=?1",nativeQuery = true)
    OrderModel findUserById(Integer id);
}
