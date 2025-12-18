package com.hospital.controller;

import com.hospital.service.SymptomService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/symptom")
@CrossOrigin("*")
public class SymptomController {

    private final SymptomService symptomService;

    public SymptomController(SymptomService symptomService) {
        this.symptomService = symptomService;
    }

    @GetMapping("/suggest")
    public String suggestDoctor(@RequestParam String symptom) {
        return symptomService.suggestSpecialization(symptom);
    }
}
