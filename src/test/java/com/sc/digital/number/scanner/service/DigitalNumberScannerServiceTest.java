package com.sc.digital.number.scanner.service;

import com.sc.digital.number.scanner.exception.DigitalNumberScannerValidationException;
import com.sc.digital.number.scanner.exception.InvalidPatternException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DigitalNumberScannerServiceTest {

    private DigitalNumberScannerService scanner;
    private List<String> numbersList;

    @Before
    public void setUp() {
        scanner = new DigitalNumberScannerService();
        numbersList = new ArrayList<>();
    }

    @After
    public void cleanUp() {
        scanner = null;
        numbersList = null;
    }

    @Test
    public void testValidSingleChunkFile() throws DigitalNumberScannerValidationException, InvalidPatternException {
        numbersList = scanner.parseFileAndDetermineNumbers("/SingleChunk.txt");
        Assert.assertEquals("123456789", numbersList.get(0));
    }

    @Test
    public void testValidMultipleChunkFile() throws DigitalNumberScannerValidationException, InvalidPatternException {
        numbersList = scanner.parseFileAndDetermineNumbers("/MultipleChunks.txt");
        Assert.assertEquals(
                        Arrays.asList(new String[] {"123456789", "123456789", "123456798"}), numbersList);
    }

    @Test
    public void testRandomPattern() throws DigitalNumberScannerValidationException, InvalidPatternException {
        numbersList = scanner.parseFileAndDetermineNumbers("/RandomPattern.txt");
        Assert.assertEquals("1???56799ILL", numbersList.get(0));
    }

    @Test
    public void testRandomMultipleChunks() throws DigitalNumberScannerValidationException, InvalidPatternException {
        numbersList = scanner.parseFileAndDetermineNumbers("/MultipleChunksWithIllegalRow.txt");
        Assert.assertEquals(
                        Arrays.asList(new String[] {"123456789", "1???56799ILL", "123?56789ILL", "113456789"}), numbersList);
    }

    @Test
    public void testEmptyFile() throws DigitalNumberScannerValidationException, InvalidPatternException {
        numbersList = scanner.parseFileAndDetermineNumbers("/Empty.txt");
        Assert.assertEquals(0, numbersList.size());
    }

    @Test
    public void testCorruptFile() throws DigitalNumberScannerValidationException, InvalidPatternException {
        numbersList = scanner.parseFileAndDetermineNumbers("/CorruptFile.txt");
        Assert.assertEquals(
                        Arrays.asList(new String[] {"?????????ILL", "?????????ILL"}), numbersList);
    }
}
