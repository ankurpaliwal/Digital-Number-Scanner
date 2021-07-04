package com.sc.digital.number.scanner.util;

import com.sc.digital.number.scanner.constant.Constant;
import com.sc.digital.number.scanner.exception.ExceptionType;
import com.sc.digital.number.scanner.exception.InvalidPatternException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Slf4j
public class DigitalNumberUtility {

    private static final List<String> numAsStrList = Arrays.asList(Constant.NUMBERS_AS_STRING_ARR);

    public static String getNumberAsString(String strNumber) {
        int number = getIntegerNumber(strNumber);
        if (!StringUtils.isBlank(strNumber) && number < 0)
            return "?";
        return String.valueOf(number);
    }

    public static int getIntegerNumber(String strNumber) {
        return numAsStrList.indexOf(strNumber);
    }

    public static List<String> getNumbersListAsString(List<String> lines) throws InvalidPatternException {
        log.trace("Inside getNumbersListAsString()");
        List<String> numbersListAsString = new ArrayList<>();
        for (int i = 0; i <= Constant.LINE_MAX_LENGTH - Constant.NUMBER_LENGTH; i = i + Constant.NUMBER_LENGTH) {
            String digitalNumAsString = lines.get(0).substring(i, i + Constant.NUMBER_LENGTH)
                            + lines.get(1).substring(i, i + Constant.NUMBER_LENGTH)
                            + lines.get(2).substring(i, i + Constant.NUMBER_LENGTH);
            if (digitalNumAsString.length() != Constant.COMPLETE_NUMBER_LENGTH) {
                throw new InvalidPatternException(ExceptionType.BUSINESS_EXCEPTION, digitalNumAsString);
            }
          
            numbersListAsString.add(digitalNumAsString);
        }
        return numbersListAsString;
    }
}
