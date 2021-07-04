package com.sc.digital.number.scanner.parser;

import com.sc.digital.number.scanner.exception.DigitalNumberScannerValidationException;
import com.sc.digital.number.scanner.exception.ExceptionType;
import com.sc.digital.number.scanner.validation.ValidatorService;
import com.sc.digital.number.scanner.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class FileParser {

    private Scanner scanner;
    private Validator validator;

    public FileParser(String file) throws DigitalNumberScannerValidationException {
        InputStream inputStream = getClass().getResourceAsStream(file);
        if(inputStream != null){
            this.scanner = new Scanner(inputStream);
            scanner.useDelimiter("\n");
        }
        else{
            throw new DigitalNumberScannerValidationException(ExceptionType.VALIDATION_EXCEPTION, "File does not exist");
        }
        this.validator = new ValidatorService();
    }

    public List<String> getFileChunk() throws DigitalNumberScannerValidationException {

        List<String> lines = new ArrayList<>();
        String line = getNextLine().trim();
        boolean isValidationSuccess;
        while (!StringUtils.isBlank(line)) {
            isValidationSuccess = validator.validateLine(line);
            if (isValidationSuccess) {
                lines.add(line);
            }
            line = getNextLine().trim();
        }
        if(validator.valideteChunkSize(lines)){
            return lines;
        }
        else{
            throw new DigitalNumberScannerValidationException(ExceptionType.VALIDATION_EXCEPTION, "File content is not properly delimited");
        }

    }

    private String getNextLine() {
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        }
        return "";
    }

    public boolean hasNextNumberLine() {
        return scanner.hasNextLine();
    }
}
