package com.buyalskaya.array.service;

import com.buyalskaya.array.entity.ShellArray;
import com.buyalskaya.array.comparator.NumberComparable;
import com.buyalskaya.array.entity.SortDirection;

public class SortArrayService {

    public void bubbleSort(ShellArray shellArray, SortDirection sortDirection) {
        if (shellArray != null && sortDirection != null) {
            SortDirectionService sortDirectionService = new SortDirectionService();
            NumberComparable numberComparable = sortDirectionService.defineDirectionComparator(sortDirection);
            bubbleSort(shellArray, numberComparable);
        }
    }

    public void straightInsertionSort(ShellArray shellArray, SortDirection sortDirection) {
        if (shellArray != null && sortDirection != null) {
            SortDirectionService sortDirectionService = new SortDirectionService();
            NumberComparable numberComparable = sortDirectionService.defineDirectionComparator(sortDirection);
            straightInsertionSort(shellArray, numberComparable);
        }
    }

    public void straightSelectionSort(ShellArray shellArray, SortDirection sortDirection) {
        if (shellArray != null && sortDirection != null) {
            SortDirectionService sortDirectionService = new SortDirectionService();
            NumberComparable numberComparable = sortDirectionService.defineDirectionComparator(sortDirection);
            straightSelectionSort(shellArray, numberComparable);
        }
    }

    private void bubbleSort(ShellArray shellArray, NumberComparable numberComparable) {
        int length = shellArray.length();
        int oneElement;
        int nextElement;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length - i; j++) {
                oneElement = shellArray.getElement(j).getAsInt();
                nextElement = shellArray.getElement(j - 1).getAsInt();
                if (numberComparable.compareTo(oneElement, nextElement)) {
                    swap(shellArray, j, j - 1);
                }
            }
        }
    }

    private void straightInsertionSort(ShellArray shellArray, NumberComparable numberComparable) {
        int length = shellArray.length();
        int temp;
        int j;
        for (int i = 1; i < length; i++) {
            temp = shellArray.getElement(i).getAsInt();
            j = i - 1;
            while (j >= 0 && numberComparable.compareTo(temp, shellArray.getElement(j).getAsInt())) {
                shellArray.setElement(j + 1, shellArray.getElement(j).getAsInt());
                j--;
            }
            shellArray.setElement(j + 1, temp);
        }
    }

    private void straightSelectionSort(ShellArray shellArray, NumberComparable numberComparable) {
        int length = shellArray.length();
        int index;
        ArrayService arrayService = new ArrayService();
        for (int i = 0; i < length; i++) {
            index = arrayService.searchIndexMinOrMax(shellArray, i, numberComparable).getAsInt();
            swap(shellArray, i, index);
        }
    }

    private void swap(ShellArray shellArray, int index1, int index2) {
        int temp = shellArray.getElement(index1).getAsInt();
        shellArray.setElement(index1, shellArray.getElement(index2).getAsInt());
        shellArray.setElement(index2, temp);
    }
}