package com.buyalskaya.array.entity;

import com.buyalskaya.array.validator.DataValidator;

import java.util.Arrays;
import java.util.StringJoiner;

public class ShellArray {
    private int[] array;

    public ShellArray() {
        array = new int[0];
    }

    public ShellArray(int size) {
        array = new int[size];
    }

    public ShellArray(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        if (array == null) {
            this.array = new int[0];
        } else {
            this.array = array;
        }
    }

    public boolean add(int number) {
        DataValidator dataValidator = new DataValidator();
        boolean isValidate = dataValidator.validateNumber(number);
        if (isValidate) {
            int newArrayLength = array.length + 1;
            int[] newArray = new int[newArrayLength];
            System.arraycopy(array, 0, newArray, 0, array.length);
            newArray[newArrayLength - 1] = number;
            setArray(newArray);
        }
        return isValidate;
    }

    public boolean remove(int index) {
        if (index > array.length - 1 || index < 0) {
            return false;
        }
        int newArrayLength = array.length - 1;
        int[] newArray = new int[newArrayLength];
        System.arraycopy(array, 0, newArray, 0, index);
        if (array.length != index) {
            System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
        }
        setArray(newArray);
        return true;
    }

    public int minElement() {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    public int maxElement() {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
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
        int arraySize = shellArray.array.length;
        int currentArraySize = array.length;
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
        int hashCode = array[0] * 31;
        for (int i = 1; i < array.length; i++) {
            hashCode = hashCode + array[i];
        }
        return hashCode;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ShellArray.class.getSimpleName() + "[", "]")
                .add("array=" + Arrays.toString(array))
                .toString();
    }
}