package com.buyalskaya.array.creator;

import com.buyalskaya.array.entity.ShellArray;
import com.buyalskaya.array.validator.DataValidator;

public class ShellArrayCreator {
    public static final int MIN_RANDOM_NUMBER = -50;
    public static final int MAX_RANDOM_NUMBER = 50;

    public ShellArray createShellArray(String[] data) {
        DataValidator dataValidator = new DataValidator();
        boolean isIntegerData = dataValidator.isIntegerArray(data);
        if (!isIntegerData) {
            return new ShellArray();
        }
        int size = data.length;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(data[i]);
        }
        return new ShellArray(array);
    }

    public ShellArray createRandomShellArray(int size) {
        ShellArray shellArray = new ShellArray(size);
        for (int i = 0; i < size; i++) {
            shellArray.setElement(i, MIN_RANDOM_NUMBER +
                    (int) (Math.random() * (MAX_RANDOM_NUMBER - MIN_RANDOM_NUMBER) + 1));
        }
        return shellArray;
    }
}