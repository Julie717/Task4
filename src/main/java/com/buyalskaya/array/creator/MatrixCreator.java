package com.buyalskaya.array.creator;

public class MatrixCreator {
    public int[][] createMatrix(String[][] data) {
        int amountRow = data.length;
        int[][] matrix = new int[amountRow][];
        int amountColumn;
        for (int i = 0; i < amountRow; i++) {
            amountColumn=data[i].length;
            matrix[i]=new int[amountColumn];
            for (int j = 0; j < amountColumn; j++) {
                matrix[i][j] = Integer.parseInt(data[i][j]);
            }
        }
        return matrix;
    }
}
