package com.carbon.karbonayakizi.dto;

import lombok.Data;
@Data
public class FoodConsumptionRequestDTO {

    private String foodName;
    private double quantityInKg;
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getQuantityInKg() {
        return quantityInKg;
    }

    public void setQuantityInKg(double quantityInKg) {
        this.quantityInKg = quantityInKg;
    }
}
