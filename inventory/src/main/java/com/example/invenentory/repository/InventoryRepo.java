package com.example.invenentory.repository;

import com.example.invenentory.model.InventoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InventoryRepo extends JpaRepository<InventoryModel,Integer> {
    @Query(value = "SELECT * FROM user_modal WHERE user_id=?1",nativeQuery = true)
    InventoryModel findUserById(Integer id);
}
