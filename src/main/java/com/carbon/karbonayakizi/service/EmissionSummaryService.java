package com.carbon.karbonayakizi.service;

import com.carbon.karbonayakizi.dto.UserEmissionSummaryDTO;
//import com.carbon.karbonayakizi.model.UserBill;
import com.carbon.karbonayakizi.model.UserFood;
//import com.carbon.karbonayakizi.model.UserTransport;
//import com.carbon.karbonayakizi.repository.UserBillRepository;
import com.carbon.karbonayakizi.repository.UserFoodRepository;
//import com.carbon.karbonayakizi.repository.UserTransportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmissionSummaryService {

    private final UserFoodRepository userFoodRepository;
    // private final UserBillRepository userBillRepository;
    private final UserTransportRepository userTransportRepository;

    public UserEmissionSummaryDTO generateSummary(Long userId) {
        List<UserFood> foods = userFoodRepository.findByUserId(userId);
        List<UserBill> bills = userBillRepository.findByUserId(userId);
        List<UserTransport> transports = userTransportRepository.findByUserId(userId);

        double foodEmission = foods.stream().mapToDouble(UserFood::getCo2Emission).sum();
        double billEmission = bills.stream().mapToDouble(UserBill::getCo2Equivalent).sum();

        double transportEmission = transports.stream().mapToDouble(transport -> {
            double factor = getEmissionFactor(transport.getVehicleType());
            return transport.getKm() * factor;
        }).sum();

        double total = foodEmission + billEmission + transportEmission;

        UserEmissionSummaryDTO dto = new UserEmissionSummaryDTO();
        dto.setUserId(userId);
        dto.setTotalFoodEmission(foodEmission);
        dto.setTotalBillEmission(billEmission);
        dto.setTotalTransportEmission(transportEmission);
        dto.setTotalEmission(total);

        return dto;
    }

    private double getEmissionFactor(String vehicleType) {
        return switch (vehicleType.toLowerCase()) {
            case "car" -> 0.21;
            case "bus" -> 0.10;
            case "bike" -> 0.0;
            case "train" -> 0.06;
            default -> 0.15; // varsayılan değer
        };
    }
}
