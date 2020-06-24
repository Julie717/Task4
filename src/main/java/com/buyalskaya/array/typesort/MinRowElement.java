package com.buyalskaya.array.typesort;

import java.util.function.Function;

public class MinRowElement implements Function<int[][], int[]> {

    @Override
    public int[] apply(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        int amountRow = matrix.length;
        int[] minRowElement = new int[amountRow];
        for (int i = 0; i < amountRow; i++) {
            minRowElement[i] = findMinimum(matrix[i]);
        }
        return minRowElement;
    }

    private int findMinimum(int[] array) {
        if (array.length <= 0) {
            return Integer.MIN_VALUE;
        }
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }
}