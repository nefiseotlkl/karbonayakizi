package com.carbon.karbonayakizi.service;

import com.carbon.karbonayakizi.dto.FoodConsumptionRequestDTO;
import com.carbon.karbonayakizi.dto.UserFoodDTO;
import com.carbon.karbonayakizi.model.Food;
import com.carbon.karbonayakizi.model.UserFood;
import com.carbon.karbonayakizi.repository.FoodRepository;
import com.carbon.karbonayakizi.repository.UserFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CarbonCalculationService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private UserFoodRepository userFoodRepository;

    // Yalnızca karbon ayak izini hesaplar
    public double calculateFoodCarbonEmission(FoodConsumptionRequestDTO request) {
        Food food = foodRepository.findByName(request.getFoodName())
                .orElseThrow(() -> new RuntimeException("Food not found: " + request.getFoodName()));
        return food.getCo2EmissionPerPortion() * request.getQuantityInKg();
    }

    // Kullanıcı yemeğini kaydeder
    public String recordUserFood(UserFoodDTO dto) {
        Food food = foodRepository.findByName(dto.getFoodName())
                .orElseThrow(() -> new RuntimeException("Food not found: " + dto.getFoodName()));

        double emission = food.getCo2EmissionPerPortion() * dto.getPortion();

        UserFood userFood = new UserFood();
        userFood.setUserId(dto.getUserId());
        userFood.setFood(food);
        userFood.setPortion(dto.getPortion());
        userFood.setEmission(emission);
        userFood.setRecordDate(LocalDate.parse(dto.getRecordDate())); // Kullanıcının girdiği tarih (örnek: "2025-05-17")

        userFoodRepository.save(userFood);

        return "Kayıt başarılı. Karbon ayak izi: " + emission + " kg CO₂";
    }
}
