package com.sc.digital.number.scanner.exception;

public class InvalidPatternException extends Exception {

    private ExceptionType exceptionType;

    public InvalidPatternException(ExceptionType exceptionType, String digitlNumberAsString) {
        super(digitlNumberAsString + "  - is not of correct length");
        this.exceptionType = exceptionType;
    }

    public ExceptionType getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(ExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }
}
