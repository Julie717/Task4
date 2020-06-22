package com.buyalskaya.array.service;

import com.buyalskaya.array.entity.ShellArray;
import com.buyalskaya.array.exception.ProjectException;

import java.util.Optional;

public class ArrayService {
    public Optional<Integer> findIndexElement(ShellArray shellArray, int number) throws ProjectException {
        if (shellArray != null) {
            if (!isAscendingOrderedArray(shellArray)) {
                throw new ProjectException("Array hasn't ascending order");
            }
            int[] array = shellArray.getArray();
            int firstIndex = 0;
            int lastIndex = array.length - 1;
            int middleIndex;
            while (firstIndex <= lastIndex) {
                middleIndex = firstIndex + (lastIndex - firstIndex) / 2;
                if (number == array[middleIndex]) {
                    return Optional.of(middleIndex);
                }
                if (number > array[middleIndex]) {
                    firstIndex = middleIndex + 1;
                }
                if (number < array[middleIndex]) {
                    lastIndex = middleIndex - 1;
                }
            }
        }
        return Optional.empty();
    }

    private boolean isAscendingOrderedArray(ShellArray shellArray) {
        boolean isOrdered = true;
        int[] array = shellArray.getArray();
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                isOrdered = false;
            }
        }
        return isOrdered;
    }

    public ShellArray findPrimeNumber(ShellArray shellArray) {
        ShellArray primeArray = new ShellArray();
        if (shellArray != null) {
            int[] array = shellArray.getArray();
            for (int i = 0; i < array.length; i++) {
                if (isPrime(array[i])) {
                    primeArray.add(array[i]);
                }
            }
        }
        return primeArray;
    }

    private boolean isPrime(int number) {
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

    public ShellArray findFibonacciNumber(ShellArray shellArray) {
        ShellArray fibonacciArray = new ShellArray();
        if (shellArray != null) {
            int[] array = shellArray.getArray();
            for (int i = 0; i < array.length; i++) {
                if (isFibonacci(array[i])) {
                    fibonacciArray.add(array[i]);
                }
            }
        }
        return fibonacciArray;
    }

    private boolean isFibonacci(int number) {
        int firstFibonacci = 1;
        int secondFibonacci = 1;
        int temp;
        for (int i = 1; i <= number; i++) {
            if (number == firstFibonacci || number == secondFibonacci) {
                return true;
            }
            temp = firstFibonacci;
            firstFibonacci = secondFibonacci;
            secondFibonacci = temp + secondFibonacci;
        }
        return false;
    }

    public ShellArray findNumberWithoutIdenticalDigits(ShellArray shellArray, int numberDigit) throws ProjectException {
        if (numberDigit <= 0) {
            throw new ProjectException("Incorrect number of digits");
        }
        ShellArray resultArray = new ShellArray();
        if (shellArray != null) {
            int[] array = shellArray.getArray();
            int amountOfDigit;
            for (int i = 0; i < array.length; i++) {
                amountOfDigit = calculateNumberDigit(array[i]);
                if (amountOfDigit == numberDigit) {
                    if (isDifferentDigits(array[i])) {
                        resultArray.add(array[i]);
                    }
                }
            }
        }
        return resultArray;
    }

    private int calculateNumberDigit(int number) {
        String numberString = Integer.toString(number);
        return (number >= 0) ? numberString.length() : (numberString.length() - 1); //-1 because a sign "-"
    }

    private boolean isDifferentDigits(int number) {
        String numberString = Integer.toString(number);
        for (int i = 0; i < numberString.length(); i++) {
            for (int j = i + 1; j < numberString.length(); j++) {
                if (numberString.charAt(i) == numberString.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}