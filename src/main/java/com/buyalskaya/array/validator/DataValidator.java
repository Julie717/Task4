package com.buyalskaya.array.validator;

import java.util.regex.Pattern;

public class DataValidator {
    private static final String CHECK_NUMBER = "-?\\d+";

    public boolean isIntegerArray(String[] stringNumbers) {
        if (stringNumbers == null) {
            return false;
        }
        boolean validate = true;
        for (String stringNumber : stringNumbers) {
            if (!isIntegerNumber(stringNumber)) {
                validate = false;
            }
        }
        return validate;
    }

    public boolean isIntegerNumber(String number) {
        if (number == null) {
            return false;
        }
        return Pattern.matches(CHECK_NUMBER, number);
    }
}