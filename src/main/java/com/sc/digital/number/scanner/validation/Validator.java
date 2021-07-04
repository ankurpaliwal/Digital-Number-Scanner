package com.sc.digital.number.scanner.validation;

import com.sc.digital.number.scanner.exception.DigitalNumberScannerValidationException;

import java.util.List;

public interface Validator {
    boolean validateLine(String line) throws DigitalNumberScannerValidationException;

    boolean valideteChunkSize(List<String> line);
}
