package com.hospital.service;

import org.springframework.stereotype.Service;

@Service
public class SymptomService {

    public String suggestSpecialization(String symptom) {

        symptom = symptom.toLowerCase();

        if (symptom.contains("fever") || symptom.contains("cold")) {
            return "General Physician";
        } else if (symptom.contains("heart") || symptom.contains("chest")) {
            return "Cardiologist";
        } else if (symptom.contains("skin")) {
            return "Dermatologist";
        } else if (symptom.contains("eye")) {
            return "Ophthalmologist";
        } else {
            return "General Physician";
        }
    }
}
