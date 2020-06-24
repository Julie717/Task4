package com.buyalskaya.array.service;

import com.buyalskaya.array.comparator.AscendantComparator;
import com.buyalskaya.array.comparator.DescendantComparator;
import com.buyalskaya.array.comparator.NumberComparable;
import com.buyalskaya.array.entity.ShellArray;
import com.buyalskaya.array.exception.ProjectException;

import java.util.OptionalInt;

public class ArrayService {

    public OptionalInt searchIndexMinOrMax(ShellArray shellArray, int startIndex,
                                           NumberComparable numberComparable) {
        //AscendantComparator - max, DescendantComparator - min
        if (shellArray == null || shellArray.length() <= 0 ||
                startIndex < 0 || startIndex >= shellArray.length()) {
            return OptionalInt.empty();
        }
        int desiredIndex = startIndex;
        int length = shellArray.length();
        for (int i = startIndex + 1; i < length; i++) {
            if (numberComparable.compareTo(shellArray.getElement(i).getAsInt(),
                    shellArray.getElement(desiredIndex).getAsInt())) {
                desiredIndex = i;
            }
        }
        return OptionalInt.of(desiredIndex);
    }

    public OptionalInt searchMinElement(ShellArray shellArray) {
        int firstIndex = 0;
        OptionalInt minElementIndex = searchIndexMinOrMax(shellArray, firstIndex, new DescendantComparator());
        OptionalInt minElement = OptionalInt.empty();
        if (minElementIndex.isPresent()) {
            minElement = OptionalInt.of(shellArray.getElement(minElementIndex.getAsInt()).getAsInt());
        }
        return minElement;
    }

    public OptionalInt searchMaxElement(ShellArray shellArray) {
        int firstIndex = 0;
        OptionalInt maxElementIndex = searchIndexMinOrMax(shellArray, firstIndex, new AscendantComparator());
        OptionalInt maxElement = OptionalInt.empty();
        if (maxElementIndex.isPresent()) {
            maxElement = OptionalInt.of(shellArray.getElement(maxElementIndex.getAsInt()).getAsInt());
        }
        return maxElement;
    }

    public OptionalInt binarySearchIndexElement(ShellArray shellArray, int number) throws ProjectException {
        if (shellArray != null) {
            if (!isAscendingOrderedArray(shellArray)) {
                throw new ProjectException("Array hasn't ascending order");
            }
            int firstIndex = 0;
            int lastIndex = shellArray.length() - 1;
            int middleIndex;
            int elementMiddleIndex;
            while (firstIndex <= lastIndex) {
                middleIndex = firstIndex + (lastIndex - firstIndex) / 2;
                elementMiddleIndex = shellArray.getElement(middleIndex).getAsInt();
                if (number == elementMiddleIndex) {
                    return OptionalInt.of(middleIndex);
                }
                if (number > elementMiddleIndex) {
                    firstIndex = middleIndex + 1;
                }
                if (number < elementMiddleIndex) {
                    lastIndex = middleIndex - 1;
                }
            }
        }
        return OptionalInt.empty();
    }

    private boolean isAscendingOrderedArray(ShellArray shellArray) {
        boolean isOrdered = true;
        for (int i = 1; i < shellArray.length(); i++) {
            if (shellArray.getElement(i - 1).getAsInt() > shellArray.getElement(i).getAsInt()) {
                isOrdered = false;
            }
        }
        return isOrdered;
    }

    public ShellArray searchPrimeNumber(ShellArray shellArray) {
        ShellArray primeArray = new ShellArray();
        NumberService numberService = new NumberService();
        if (shellArray != null) {
            for (int i = 0; i < shellArray.length(); i++) {
                if (numberService.isPrime(shellArray.getElement(i).getAsInt())) {
                    primeArray.add(shellArray.getElement(i).getAsInt());
                }
            }
        }
        return primeArray;
    }

    public ShellArray searchFibonacciNumber(ShellArray shellArray) {
        ShellArray fibonacciArray = new ShellArray();
        NumberService numberService = new NumberService();
        if (shellArray != null) {
            for (int i = 0; i < shellArray.length(); i++) {
                if (numberService.isFibonacci(shellArray.getElement(i).getAsInt())) {
                    fibonacciArray.add(shellArray.getElement(i).getAsInt());
                }
            }
        }
        return fibonacciArray;
    }

    public ShellArray searchNumberWithDifferentDigits(ShellArray shellArray,
                                                      int numberDigit) throws ProjectException {
        if (numberDigit <= 0) {
            throw new ProjectException("Incorrect number of digits");
        }
        ShellArray resultArray = new ShellArray();
        if (shellArray != null) {
            int amountOfDigit;
            NumberService numberService = new NumberService();
            for (int i = 0; i < shellArray.length(); i++) {
                amountOfDigit = numberService.calculateNumberDigit(shellArray.getElement(i).getAsInt());
                if (amountOfDigit == numberDigit) {
                    if (numberService.isDifferentDigits(shellArray.getElement(i).getAsInt())) {
                        resultArray.add(shellArray.getElement(i).getAsInt());
                    }
                }
            }
        }
        return resultArray;
    }
}