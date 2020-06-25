package com.buyalskaya.array.creator;

import com.buyalskaya.array.validator.DataValidator;

public class MatrixCreator {
    public int[][] createMatrix(String[][] data) {
        DataValidator dataValidator = new DataValidator();
        boolean isIntegerData = dataValidator.isIntegerMatrix(data);
        if (!isIntegerData) {
            return new int[][]{};
        }
        int amountRow = data.length;
        int[][] matrix = new int[amountRow][];
        int amountColumn;
        for (int i = 0; i < amountRow; i++) {
            amountColumn = data[i].length;
            matrix[i] = new int[amountColumn];
            for (int j = 0; j < amountColumn; j++) {
                matrix[i][j] = Integer.parseInt(data[i][j]);
            }
        }
        return matrix;
    }
}