package com.buyalskaya.array.service;

import com.buyalskaya.array.entity.SortDirection;
import com.buyalskaya.array.entity.SortType;
import com.buyalskaya.array.exception.ProjectException;

public class SortMatrixService {

    public void bubbleSort(int[][] matrix, SortType sortType,
                           SortDirection sortDirection) throws ProjectException {
        if (matrix == null || sortType == null || sortDirection == null) {
            throw new ProjectException("Incorrect input data");
        }
        int[] attribute = sortType.apply(matrix);
        int size = attribute.length;
        for (int i = 0; i < size; i++) {
            for (int j = 1; j < size - i; j++) {
                if (sortDirection.test(attribute[j], attribute[j - 1])) {
                    swapRow(matrix, j, j - 1);
                    swapElement(attribute, j, j - 1);
                }
            }
        }
    }

    private void swapElement(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private void swapRow(int[][] matrix, int index1, int index2) {
        int[] temp = matrix[index1];
        matrix[index1] = matrix[index2];
        matrix[index2] = temp;
    }
}