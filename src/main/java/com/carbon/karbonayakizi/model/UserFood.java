package com.carbon.karbonayakizi.model;
import jakarta.persistence.*;
import java.time.LocalDate;

import lombok.Data;
@Data
@Entity
@Table(name = "user_foods")
public class UserFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    private Food food;

    @Column(name = "portion")
    private double portion;

    @Column(name = "emission")
    private double emission;

    @Column(name = "record_date")
    private LocalDate recordDate;

    // Lombok kullanmıyorsan:
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Food getFood() { return food; }
    public void setFood(Food food) { this.food = food; }

    public double getPortion() { return portion; }
    public void setPortion(double portion) { this.portion = portion; }

    public double getEmission() { return emission; }
    public void setEmission(double emission) { this.emission = emission; }

    public LocalDate getRecordDate() { return recordDate; }
    public void setRecordDate(LocalDate recordDate) { this.recordDate = recordDate; }

}
