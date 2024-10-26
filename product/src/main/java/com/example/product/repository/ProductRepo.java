package com.example.product.repository;

import com.example.product.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepo extends JpaRepository<ProductModel,Integer> {
    @Query(value = "SELECT * FROM user_modal WHERE user_id=?1",nativeQuery = true)
    ProductModel findUserById(Integer id);
}
