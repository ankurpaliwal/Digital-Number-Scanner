package com.sc.digital.number.scanner.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constant {
    //allowed maximum length per line is 27
    public static final int LINE_MAX_LENGTH = 27;
    //digital representation of numbers between 0 to 9
    public static final String[] NUMBERS_AS_STRING_ARR = {"._.|.||_|", ".....|..|", "._.._||_.", "._.._|._|", "...|_|..|", "._.|_.._|", "._.|_.|_|", "._...|..|", "._.|_||_|", "._.|_|._|"};
    public static final int NUMBER_LENGTH = 3;
    public static final int CHUNK_SIZE = 3;
    public static final int COMPLETE_NUMBER_LENGTH = 9;
    public static final String ILLEGAL_WORD="ILL";
    public static final String ILLEGAL_CHAR="?";
}
