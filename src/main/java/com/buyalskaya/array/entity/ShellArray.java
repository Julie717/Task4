package com.buyalskaya.array.entity;

import java.util.OptionalInt;

public class ShellArray {
    private static final int DEFAULT_SIZE = 0;
    public static final int MIN_NUMBER_INT = -1000;
    public static final int MAX_NUMBER_INT = 1000;
    private int[] array;

    public ShellArray() {
        array = new int[DEFAULT_SIZE];
    }

    public ShellArray(int size) {
        if (size < 0) {
            size = DEFAULT_SIZE;
        }
        array = new int[size];
    }

    public ShellArray(int[] array) {
        if (isCorrectInputArray(array)) {
            this.array = array;
        } else {
            this.array = new int[DEFAULT_SIZE];
        }
    }

    public OptionalInt getElement(int index) {
        if (isCorrectIndex(index)) {
            return OptionalInt.of(array[index]);
        }
        return OptionalInt.empty();
    }

    public void setElement(int index, int element) {
        boolean isCorrectIndex = isCorrectIndex(index);
        boolean isCorrectNumber = isCorrectNumber(element);
        if (isCorrectIndex && isCorrectNumber) {
            array[index] = element;
        }
    }

    public int length() {
        return array.length;
    }

    private boolean isCorrectIndex(int index) {
        return (index >= 0) && (index < length());
    }

    private boolean isCorrectNumber(int number) {
        return ((number >= MIN_NUMBER_INT) && (number <= MAX_NUMBER_INT));
    }

    private boolean isCorrectInputArray(int[] array) {
        boolean isCorrect = false;
        if (array != null) {
            isCorrect = true;
            for (int value : array) {
                if (!isCorrectNumber(value)) {
                    isCorrect = false;
                }
            }
        }
        return isCorrect;
    }

    public boolean add(int number) {
        boolean isCorrectNumber = isCorrectNumber(number);
        if (isCorrectNumber) {
            int arrayLength = length();
            int newArrayLength = arrayLength + 1;
            int[] newArray = new int[newArrayLength];
            arrayCopy(array, 0, newArray, 0, arrayLength);
            newArray[newArrayLength - 1] = number;
            array = newArray;
        }
        return isCorrectNumber;
    }

    public boolean remove(int index) {
        if (!isCorrectIndex(index)) {
            return false;
        }
        int arrayLength = length();
        int newArrayLength = arrayLength - 1;
        int[] newArray = new int[newArrayLength];
        arrayCopy(array, 0, newArray, 0, index);
        if (arrayLength != index) {
            arrayCopy(array, index + 1, newArray, index, arrayLength - index - 1);
        }
        array = newArray;
        return true;
    }

    private void arrayCopy(int[] sourceArray, int sourceStartPosition,
                           int[] receiverArray, int receiverStartPosition, int amountCopyElement) {
        for (int i = 0; i < amountCopyElement; i++) {
            receiverArray[i + receiverStartPosition] = sourceArray[sourceStartPosition + i];
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        ShellArray shellArray = (ShellArray) obj;
        int arraySize = shellArray.length();
        int currentArraySize = length();
        if (arraySize != currentArraySize) {
            return false;
        }
        for (int i = 0; i < arraySize; i++) {
            if (shellArray.array[i] != array[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int length = length();
        int hashCode;
        if (length <= 0) {
            hashCode = 0;
        } else {
            hashCode = array[0] * 31;
            for (int i = 1; i < array.length; i++) {
                hashCode = hashCode + array[i];
            }
        }
        return hashCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(ShellArray.class.getSimpleName());
        int length = length();
        sb.append("{array = [");
        if (length > 0) {
            for (int i = 0; i < length - 1; i++) {
                sb.append(array[i]);
                sb.append(", ");
            }
            sb.append(array[length - 1]);
        }
        sb.append("]}");
        return sb.toString();
    }
}