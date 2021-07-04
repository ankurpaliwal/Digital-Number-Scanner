package com.sc.digital.number.scanner.service;

import com.sc.digital.number.scanner.constant.Constant;
import com.sc.digital.number.scanner.exception.DigitalNumberScannerValidationException;
import com.sc.digital.number.scanner.exception.InvalidPatternException;
import com.sc.digital.number.scanner.parser.FileParser;
import com.sc.digital.number.scanner.util.DigitalNumberUtility;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class DigitalNumberScannerService {

    public List<String> parseFileAndDetermineNumbers(String file)
                    throws DigitalNumberScannerValidationException, InvalidPatternException {
        FileParser parser = new FileParser(file);
        StringBuilder builder;
        List<String> numbersList = new ArrayList<>();
        int invalidCharCount;

        while (parser.hasNextNumberLine()) {
            builder = new StringBuilder();
            invalidCharCount = 0;
            List<String> numberCodesStringList = DigitalNumberUtility.getNumbersListAsString(parser.getFileChunk());
            if (numberCodesStringList != null) {
                for (String numberCode : numberCodesStringList) {
                    String number = DigitalNumberUtility.getNumberAsString(numberCode);
                    if (number == Constant.ILLEGAL_CHAR) {
                        invalidCharCount++;
                    }
                    builder.append(number);
                }
            }

            if (invalidCharCount > 0) {
                builder.append(Constant.ILLEGAL_WORD);
            }
            numbersList.add(builder.toString());
        }
        return numbersList;
    }
}
