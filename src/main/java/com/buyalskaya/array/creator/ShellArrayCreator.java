package com.buyalskaya.array.creator;

import com.buyalskaya.array.entity.ShellArray;

public class ShellArrayCreator {
    public static final int MIN_RANDOM_NUMBER = -50;
    public static final int MAX_RANDOM_NUMBER = 50;

    public ShellArray createShellArray(String[] data) {
        int size = data.length;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(data[i]);
        }
        return new ShellArray(array);
    }

    public ShellArray createRandomShellArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = MIN_RANDOM_NUMBER + (int) (Math.random() * (MAX_RANDOM_NUMBER - MIN_RANDOM_NUMBER) + 1);
        }
        return new ShellArray(array);
    }
}