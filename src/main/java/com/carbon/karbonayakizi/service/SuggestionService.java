package com.carbon.karbonayakizi.service;

import com.carbon.karbonayakizi.dto.UserEmissionSummaryDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Service
public class SuggestionService {

    private final List<Function<UserEmissionSummaryDTO, List<String>>> rules;

    public SuggestionService() {
        rules = List.of(
                dto -> {
                    List<String> suggestions = new ArrayList<>();
                    if (dto.getTotalFoodEmission() > 5) {
                        suggestions.add("Et tüketimini azaltmayı deneyin.");
                    }
                    return suggestions;
                },
                dto -> {
                    List<String> suggestions = new ArrayList<>();
                    if (dto.getTotalTransportEmission() > 10) {
                        suggestions.add("Toplu taşımayı daha fazla tercih edebilirsiniz.");
                        suggestions.add("Bisiklet kullanımı karbon ayak izinizi düşürebilir.");
                    }
                    return suggestions;
                },
                dto -> {
                    List<String> suggestions = new ArrayList<>();
                    if (dto.getTotalBillEmission() > 7) {
                        suggestions.add("Enerji tasarrufu için elektrik ve doğalgaz tüketiminizi azaltmayı düşünün.");
                    }
                    return suggestions;
                }
                // Yeni kuralları buraya kolayca ekleyebilirsin
        );
    }

    public List<String> generateSuggestions(UserEmissionSummaryDTO dto) {
        List<String> suggestions = new ArrayList<>();
        for (Function<UserEmissionSummaryDTO, List<String>> rule : rules) {
            suggestions.addAll(rule.apply(dto));
        }
        if (suggestions.isEmpty()) {
            suggestions.add("Harika! Karbon ayak izinizi iyi seviyede tutuyorsunuz.");
        }
        return suggestions;
    }
}
