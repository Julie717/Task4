package com.buyalskaya.array.function;

import java.util.function.Function;

public class SumRowElement implements Function<int[][], int[]> {

    @Override
    public int[] apply(int[][] matrix) {
        if (matrix == null) {
            return new int[]{};
        }
        int amountRow = matrix.length;
        int[] sumRowElement = new int[amountRow];
        for (int i = 0; i < amountRow; i++) {
            sumRowElement[i] = calculateSum(matrix[i]);
        }
        return sumRowElement;
    }

    private int calculateSum(int[] array) {
        if (array.length <= 0) {
            return Integer.MIN_VALUE;
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        return sum;
    }
}