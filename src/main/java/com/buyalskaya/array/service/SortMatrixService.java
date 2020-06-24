package com.buyalskaya.array.service;

import com.buyalskaya.array.entity.SortDirection;
import com.buyalskaya.array.entity.SortType;
import com.buyalskaya.array.comparator.NumberComparable;
import com.buyalskaya.array.exception.ProjectException;
import com.buyalskaya.array.typesort.*;

import java.util.function.Function;

public class SortMatrixService {

    public void bubbleSort(int[][] matrix, SortType sortType,
                           SortDirection sortDirection) throws ProjectException {
        if (matrix == null || sortType == null || sortDirection == null) {
            throw new ProjectException("Incorrect input data");
        }
        SortDirectionService sortDirectionService = new SortDirectionService();
        NumberComparable numberComparable = sortDirectionService.defineDirectionComparator(sortDirection);
        switch (sortType) {
            case SUM:
                bubbleSort(matrix, new SumRowElement(), numberComparable);
                break;
            case MAX:
                bubbleSort(matrix, new MaxRowElement(), numberComparable);
                break;
            case MIN:
                bubbleSort(matrix, new MinRowElement(), numberComparable);
                break;
        }
    }

    private void bubbleSort(int[][] matrix, Function<int[][], int[]> sortType,
                            NumberComparable numberComparable) {
        if (matrix != null) {
            int[] attribute = sortType.apply(matrix);
            int size = attribute.length;
            for (int i = 0; i < size; i++) {
                for (int j = 1; j < size - i; j++) {
                    if (numberComparable.compareTo(attribute[j], attribute[j - 1])) {
                        swapRow(matrix, j, j - 1);
                        swapElement(attribute, j, j - 1);
                    }
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