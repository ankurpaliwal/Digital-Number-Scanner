package com.sc.digital.number.scanner.exception;

public class DigitalNumberScannerValidationException extends Exception {

    private static final long serialVersionUID = 1L;

    private ExceptionType exceptionType;

    public DigitalNumberScannerValidationException(ExceptionType exceptionType, String exceptionMessage) {
        super(exceptionMessage);
        this.exceptionType = exceptionType;
    }


    public ExceptionType getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(ExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }
}
