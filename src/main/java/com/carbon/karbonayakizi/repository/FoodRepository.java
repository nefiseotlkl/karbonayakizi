package com.carbon.karbonayakizi.repository;

import com.carbon.karbonayakizi.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {
    Optional<Food> findByName(String name);
}
