package com.carbon.karbonayakizi.repository;

import com.carbon.karbonayakizi.model.UserFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserFoodRepository extends JpaRepository<UserFood, Long> {
    List<UserFood> findByUserId(Long userId);
}
