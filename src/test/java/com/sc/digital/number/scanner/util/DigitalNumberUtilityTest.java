package com.sc.digital.number.scanner.util;

import com.sc.digital.number.scanner.exception.InvalidPatternException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DigitalNumberUtilityTest {


    @Test
    public void testValidPattern() {
        assertEquals(0, DigitalNumberUtility.getIntegerNumber("._.|.||_|"));
        assertEquals(1, DigitalNumberUtility.getIntegerNumber(".....|..|"));
        assertEquals(2, DigitalNumberUtility.getIntegerNumber("._.._||_."));
    }

    @Test
    public void testInValidPattern() {
        int number = DigitalNumberUtility.getIntegerNumber("._..._|_|");
        assertEquals(-1, number);
    }

    @Test
    public void testInValidSringPattern() {
        String numberStr = DigitalNumberUtility.getNumberAsString("._..._|_|");
        assertEquals("?", numberStr);
    }

    @Test
    public void testValidNumbersListAsString() throws InvalidPatternException {
        List<String> expectedNumStringList = new ArrayList<>();
        expectedNumStringList.add(".....|..|");
        expectedNumStringList.add("._.._||_.");
        expectedNumStringList.add("._.._|._|");
        expectedNumStringList.add("...|_|..|");
        expectedNumStringList.add("._.|_.._|");
        expectedNumStringList.add("._.|_.|_|");
        expectedNumStringList.add("._...|..|");
        expectedNumStringList.add("._.|_||_|");
        expectedNumStringList.add("._.|_|._|");

        List<String> inputList =new ArrayList<>();
        inputList.add("...._.._....._.._.._.._.._.");
        inputList.add("..|._|._||_||_.|_...||_||_|");
        inputList.add("..||_.._|..|._||_|..||_|._|");
        List<String> numberStrList = DigitalNumberUtility.getNumbersListAsString(inputList);

        assertEquals(expectedNumStringList, numberStrList);
    }
}
