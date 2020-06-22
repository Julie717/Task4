package com.buyalskaya.array.validator;

import java.util.regex.Pattern;

public class DataValidator {
    private static final String CHECK_NUMBER = "-?\\d+";
    public static final int MIN_NUMBER_INT = -1000;
    public static final int MAX_NUMBER_INT = 1000;

    public boolean validateData(String[] numbers) {
        int number;
        int size = numbers.length;
        int validate = 0;
        for (int i = 0; i < size; i++) {
            if (validateIsInteger(numbers[i])) {
                number = Integer.parseInt(numbers[i]);
                validate = validate + ((validateNumber(number)) ? 1 : 0);
            }
        }
        return validate == size;
    }

    public boolean validateIsInteger(String number) {
        if (number == null) {
            return false;
        }
        return Pattern.matches(CHECK_NUMBER, number);
    }

    public boolean validateNumber(int number) {
        return ((number >= MIN_NUMBER_INT) && (number <= MAX_NUMBER_INT));
    }
}