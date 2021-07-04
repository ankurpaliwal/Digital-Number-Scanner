package com.sc.digital.number.scanner.validator;

import com.sc.digital.number.scanner.exception.DigitalNumberScannerValidationException;
import com.sc.digital.number.scanner.validation.ValidatorService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ValidatorServiceTest {

    private ValidatorService validatorService;
    private List<String> chunk;
    private String line;
    private boolean isValieLine, isValieChunk;

    @Before
    public void setUp() {
        validatorService = new ValidatorService();
        line = "";
        chunk = new ArrayList<>();
    }

    @After
    public void cleanUp() {
        validatorService = null;
        chunk = null;
    }

    @Test
    public void testValidLine() throws DigitalNumberScannerValidationException {
        line = "...._.._....._.._.._.._.._.";
        isValieLine = validatorService.validateLine(line);
        assertTrue(isValieLine);
    }

    @Test(expected = DigitalNumberScannerValidationException.class)
    public void testInvalidLineThrowsException() throws DigitalNumberScannerValidationException {
        line = "...._.._....._.._.._.._.._.._|";
        validatorService.validateLine(line);
    }

    @Test
    public void testValidChunk() {
        chunk.add("...._.._....._.._.._.._.._.");
        chunk.add("..|._|._||_||_.|_...||_||_|");
        chunk.add("..||_.._|..|._||_|..||_|._|");
        boolean isValieChunk = validatorService.valideteChunkSize(chunk);
        assertTrue(isValieChunk);
    }

    @Test
    public void testInValidChunk() {
        chunk.add("...._.._....._.._.._.._.._.");
        chunk.add("..|._|._||_||_.|_...||_||_|");
        chunk.add("..||_.._|..|._||_|..||_|._|");
        chunk.add("..||_.._|..|._||_|..||_|._.");
        isValieChunk = validatorService.valideteChunkSize(chunk);
        assertFalse(isValieChunk);
    }
}
