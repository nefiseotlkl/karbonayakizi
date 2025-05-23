package com.carbon.karbonayakizi.dto;

import lombok.Data;

@Data
public class UserEmissionSummaryDTO {

    private Long userId;

    private double totalFoodEmission;
    private double totalTransportEmission;
    private double totalBillEmission;

    private double totalEmission; // Toplam hepsi

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public double getTotalFoodEmission() {
        return totalFoodEmission;
    }
    public void setTotalFoodEmission(double totalFoodEmission) {
        this.totalFoodEmission = totalFoodEmission;
    }
    public double getTotalTransportEmission() {
        return totalTransportEmission;
    }
    public void setTotalTransportEmission(double totalTransportEmission) {
        this.totalTransportEmission = totalTransportEmission;
    }
    public double getTotalBillEmission() {
        return totalBillEmission;
    }
    public void setTotalBillEmission(double totalBillEmission) {
        this.totalBillEmission = totalBillEmission;
    }
    public double getTotalEmission() {
        return totalEmission;
    }
    public void setTotalEmission(double totalEmission) {
        this.totalEmission = totalEmission;
    }
}
