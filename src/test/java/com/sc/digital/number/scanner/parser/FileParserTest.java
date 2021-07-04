package com.sc.digital.number.scanner.parser;
import com.sc.digital.number.scanner.exception.DigitalNumberScannerValidationException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;



public class FileParserTest {

    private FileParser parser;

    @Test
     public void testValidSingleChunkParser() throws DigitalNumberScannerValidationException {
        parser = new FileParser("/SingleChunk.txt");
        List<String> numberLines = parser.getFileChunk();
        Assert.assertEquals(3, numberLines.size());

    }

    @Test
    public void testValidMultipleChunkParser() throws DigitalNumberScannerValidationException {
        parser = new FileParser("/MultipleChunksWithIllegalRow.txt");
        List<String> numberLines = new ArrayList<>();
        while (parser.hasNextNumberLine()) {
            numberLines.addAll(parser.getFileChunk());
        }
        Assert.assertEquals(12, numberLines.size());

    }

    @Test(expected = DigitalNumberScannerValidationException.class)
    public void testEmptyFileParser() throws DigitalNumberScannerValidationException {
        parser = new FileParser("/Empty.txt");
        List<String> numberLines = parser.getFileChunk();
    }

    @Test(expected = DigitalNumberScannerValidationException.class)
    public void testThrowDigitalScannerValidationException() throws DigitalNumberScannerValidationException {
        parser = new FileParser("/BadFile.txt");
        parser.getFileChunk();
    }
}
