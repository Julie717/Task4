package com.buyalskaya.array.service;

import com.buyalskaya.array.entity.*;
import com.buyalskaya.array.exception.ProjectException;

import java.util.function.Function;

public class SortingService {

    public void bubbleSort(ShellArray shellArray, SortingDirection sortingDirection) {
        if (shellArray != null && sortingDirection != null) {
            OrderComparable orderComparable = chooseOrderComparison(sortingDirection);
            bubbleSort(shellArray, orderComparable);
        }
    }

    public void straightInsertionSort(ShellArray shellArray, SortingDirection sortingDirection) {
        if (shellArray != null && sortingDirection != null) {
            OrderComparable orderComparable = chooseOrderComparison(sortingDirection);
            straightInsertionSort(shellArray, orderComparable);
        }
    }

    public void straightSelectionSort(ShellArray shellArray, SortingDirection sortingDirection) {
        if (shellArray != null && sortingDirection != null) {
            OrderComparable orderComparable = chooseOrderComparison(sortingDirection);
            straightSelectionSort(shellArray, orderComparable);
        }
    }

    private OrderComparable chooseOrderComparison(SortingDirection sortingDirection) {
        OrderComparable orderComparable;
        if (sortingDirection == SortingDirection.DECREASE) {
            orderComparable = new SignGreater();
        } else {
            orderComparable = new SignLess();
        }
        return orderComparable;
    }

    private void bubbleSort(ShellArray shellArray, OrderComparable orderComparable) {
        int length = shellArray.length();
        int oneElement;
        int otherElement;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length - i; j++) {
                oneElement = shellArray.getElement(j).getAsInt();
                otherElement = shellArray.getElement(j - 1).getAsInt();
                if (orderComparable.comparison(oneElement, otherElement)) {
                    swap(shellArray, j, j - 1);
                }
            }
        }
    }

    private void straightInsertionSort(ShellArray shellArray, OrderComparable orderComparable) {
        int length = shellArray.length();
        int temp;
        int j;
        for (int i = 1; i < length; i++) {
            temp = shellArray.getElement(i).getAsInt();
            j = i - 1;
            while (j >= 0 && orderComparable.comparison(temp, shellArray.getElement(j).getAsInt())) {
                shellArray.setElement(j + 1, shellArray.getElement(j).getAsInt());
                j--;
            }
            shellArray.setElement(j + 1, temp);
        }
    }

    private void straightSelectionSort(ShellArray shellArray, OrderComparable orderComparable) {
        int length = shellArray.length();
        int index;
        ArrayService arrayService = new ArrayService();
        for (int i = 0; i < length; i++) {
            index = arrayService.searchIndexMinOrMax(shellArray, i, orderComparable).getAsInt();
            swap(shellArray, i, index);
        }
    }

    private void swap(ShellArray shellArray, int index1, int index2) {
        int temp = shellArray.getElement(index1).getAsInt();
        shellArray.setElement(index1, shellArray.getElement(index2).getAsInt());
        shellArray.setElement(index2, temp);
    }

    public void bubbleSort(int[][] matrix, SortingType typeSorting,
                           SortingDirection sortingDirection) throws ProjectException {
        if (typeSorting == null || sortingDirection == null) {
            throw new ProjectException("Incorrect input data");
        }
        OrderComparable orderComparable = chooseOrderComparison(sortingDirection);
        switch (typeSorting) {
            case SUM:
                bubbleSort(matrix, new SumRowElement(), orderComparable);
                break;
            case MAX:
                bubbleSort(matrix, new MaxRowElement(), orderComparable);
                break;
            case MIN:
                bubbleSort(matrix, new MinRowElement(), orderComparable);
                break;
        }
    }

    private void bubbleSort(int[][] matrix, Function<int[][], int[]> sortingAttribute,
                            OrderComparable orderComparable) {
        if (matrix != null) {
            int[] attribute = sortingAttribute.apply(matrix);
            int size = attribute.length;
            for (int i = 0; i < size; i++) {
                for (int j = 1; j < size - i; j++) {
                    if (orderComparable.comparison(attribute[j], attribute[j - 1])) {
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