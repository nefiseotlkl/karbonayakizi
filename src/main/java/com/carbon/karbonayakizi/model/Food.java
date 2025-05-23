package com.carbon.karbonayakizi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "foods")

public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "co2_emission_per_portion")
    private double co2EmissionPerPortion;
    public double getCo2EmissionPerPortion() {
        return co2EmissionPerPortion;
    }


}