package com.carbon.karbonayakizi.controller;

import com.carbon.karbonayakizi.dto.UserEmissionSummaryDTO;
import com.carbon.karbonayakizi.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suggestions")
public class SuggestionController {

    private final SuggestionService suggestionService;

    @Autowired
    public SuggestionController(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    @PostMapping
    public List<String> getSuggestions(@RequestBody UserEmissionSummaryDTO userEmissionSummaryDTO) {
        return suggestionService.generateSuggestions(userEmissionSummaryDTO);
    }
}
