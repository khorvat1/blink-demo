package hr.khorvat.blink.service;

import hr.khorvat.blink.model.dto.MRZValidationDTO;

public interface MRZValidator {

    MRZValidationDTO validateMRZFields(String rawMRZString);
}
