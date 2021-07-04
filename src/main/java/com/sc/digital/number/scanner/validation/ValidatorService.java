package com.sc.digital.number.scanner.validation;

import com.sc.digital.number.scanner.constant.Constant;
import com.sc.digital.number.scanner.exception.DigitalNumberScannerValidationException;
import com.sc.digital.number.scanner.exception.ExceptionType;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class ValidatorService implements Validator {

    @Override
    public boolean validateLine(String line) throws DigitalNumberScannerValidationException {
        if (!StringUtils.isBlank(line)
                        && (line.length() < Constant.LINE_MAX_LENGTH
                        || line.length() > Constant.LINE_MAX_LENGTH)){
            throw new DigitalNumberScannerValidationException(
                            ExceptionType.VALIDATION_EXCEPTION, "Row length was expected to be " + Constant.LINE_MAX_LENGTH
                            + " but was found " + line.length());
        }
        return true;
    }

    @Override
    public boolean valideteChunkSize(List<String> chunk) {
        if (CollectionUtils.isNotEmpty(chunk) && chunk.size() == Constant.CHUNK_SIZE){
            return true;
        }
        return false;
    }

}
