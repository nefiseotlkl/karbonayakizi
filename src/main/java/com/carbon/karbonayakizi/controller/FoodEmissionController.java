package com.carbon.karbonayakizi.controller;

import com.carbon.karbonayakizi.dto.UserFoodDTO;
import com.carbon.karbonayakizi.service.CarbonCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emission")
public class FoodEmissionController {

    @Autowired
    private CarbonCalculationService carbonCalculationService;

    @PostMapping("/food")
    public ResponseEntity<String> recordFoodConsumption(@RequestBody UserFoodDTO dto) {
        String result = carbonCalculationService.recordUserFood(dto);
        return ResponseEntity.ok(result);
    }


    @PostMapping("/food/save")
    public ResponseEntity<String> saveUserFood(@RequestBody UserFoodDTO dto) {
        String result = carbonCalculationService.recordUserFood(dto);
        return ResponseEntity.ok(result);
    }
}
