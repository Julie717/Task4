package com.buyalskaya.array.service;

public class NumberService {
    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isFibonacci(int number) {
        if (number < 1) {
            return false;
        }
        int firstFibonacci = 1;
        int secondFibonacci = 1;
        int temp;
        boolean isFibonacci = false;
        for (int i = 1; i <= number; i++) {
            if (number == firstFibonacci || number == secondFibonacci) {
                isFibonacci = true;
            }
            temp = firstFibonacci;
            firstFibonacci = secondFibonacci;
            secondFibonacci = temp + secondFibonacci;
        }
        return isFibonacci;
    }

    public int calculateNumberDigit(int number) {
        String numberString = Integer.toString(number);
        return (number >= 0) ? numberString.length() : (numberString.length() - 1); //-1 because a sign "-"
    }

    public boolean isDifferentDigits(int number) {
        int startIndex = (number >= 0) ? 0 : 1; // because sign "-"
        String numberString = Integer.toString(number);
        int length = numberString.length();
        for (int i = startIndex; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (numberString.charAt(i) == numberString.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}