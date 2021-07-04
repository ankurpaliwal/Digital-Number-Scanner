package com.sc.digital.number.scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DigitalNumberScannerTest {
    private DigitalNumberScanner digitalNumberScanner;
    String file;
    List<String> numbersList;

    @Before
    public void init(){
        digitalNumberScanner = new DigitalNumberScanner();
        numbersList = new ArrayList<>();
    }

    @Test
    public void testDigitalNumberScannerWithValidFile(){
        file="/MultipleChunks.txt";
        numbersList = digitalNumberScanner.scanAndPrintDigitalNumbers(file);
        Assert.assertEquals(
                        Arrays.asList(new String[] {"123456789", "123456789", "123456798"}), numbersList);
    }

    @Test
    public void testDigitalNumberScannerWithFileNotExists() {
        file="/MultipleChunks1.txt";
        numbersList = digitalNumberScanner.scanAndPrintDigitalNumbers(file);
        Assert.assertNull(numbersList);
    }

}
