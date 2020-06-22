package com.buyalskaya.array.service;

import com.buyalskaya.array.entity.*;
import com.buyalskaya.array.exception.ProjectException;

import java.util.function.Function;

public class SortingService {

    public void bubbleSort(ShellArray shellArray) {
        if (shellArray != null) {
            int[] array = shellArray.getArray();
            int size = array.length;
            for (int i = 0; i < size; i++) {
                for (int j = 1; j < size - i; j++) {
                    if (array[j] < array[j - 1]) {
                        swap(array, j, j - 1);
                    }
                }
            }
        }
    }

    public void straightInsertionSort(ShellArray shellArray) {
        if (shellArray != null) {
            int[] array = shellArray.getArray();
            int temp;
            int j;
            for (int i = 1; i < array.length; i++) {
                temp = array[i];
                j = i - 1;
                while (j >= 0 && temp < array[j]) {
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = temp;
            }
        }
    }

    public void straightSelectionSort(ShellArray shellArray) {
        if (shellArray != null) {
            int[] array = shellArray.getArray();
            int minIndex;
            for (int i = 0; i < array.length; i++) {
                minIndex = findIndexMin(array, i);
                swap(array, i, minIndex);
            }
        }
    }

    public void bubbleSort(int[][] matrix, TypeSorting typeSorting,
                           OrderSortable orderSortable) throws ProjectException {
        if (typeSorting == null || orderSortable == null) {
            throw new ProjectException("Incorrect input data");
        }
        switch (typeSorting) {
            case SUM:
                bubbleSort(matrix, new SumRowElement(), orderSortable);
                break;
            case MAX:
                bubbleSort(matrix, new MaxRowElement(), orderSortable);
                break;
            case MIN:
                bubbleSort(matrix, new MinRowElement(), orderSortable);
                break;
        }
    }

    private void bubbleSort(int[][] matrix, Function<int[][], int[]> sortingAttribute,
                            OrderSortable orderSortable) {
        if (matrix != null) {
            int[] attribute = sortingAttribute.apply(matrix);
            int size = attribute.length;
            for (int i = 0; i < size; i++) {
                for (int j = 1; j < size - i; j++) {
                    if (orderSortable.comparison(attribute[j - 1], attribute[j])) {
                        swapRow(matrix, j, j - 1);
                        swap(attribute, j, j - 1);
                    }
                }
            }
        }
    }

    private int findIndexMin(int[] array, int startIndex) {
        int minIndex = startIndex;
        for (int i = startIndex + 1; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    private void swap(int[] array, int index1, int index2) {
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