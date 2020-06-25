package com.buyalskaya.array.typesort;

import java.util.function.Function;

public class MaxRowElement implements Function<int[][], int[]> {

    @Override
    public int[] apply(int[][] matrix) {
        if (matrix == null) {
            return new int[]{};
        }
        int amountRow = matrix.length;
        int[] maxRowElement = new int[amountRow];
        for (int i = 0; i < amountRow; i++) {
            maxRowElement[i] = findMaximum(matrix[i]);
        }
        return maxRowElement;
    }

    private int findMaximum(int[] array) {
        if (array.length <= 0) {
            return Integer.MIN_VALUE;
        }
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }
}