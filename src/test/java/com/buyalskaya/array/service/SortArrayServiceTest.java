package com.buyalskaya.array.service;

import com.buyalskaya.array.entity.ShellArray;
import com.buyalskaya.array.entity.SortDirection;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SortArrayServiceTest {
    SortArrayService sortArrayService;

    @BeforeClass
    public void setUp() {
        sortArrayService = new SortArrayService();
    }

    @DataProvider(name = "dataForArraySortingIncrease")
    public Object[][] dataForArraySortingIncrease() {
        return new Object[][]{
                {new ShellArray(new int[]{10, -8, 0, 1, 2, 5, 9}), new ShellArray(new int[]{-8, 0, 1, 2, 5, 9, 10})},
                {new ShellArray(new int[]{-8, 0, 1, 2, 5, 9, 10}), new ShellArray(new int[]{-8, 0, 1, 2, 5, 9, 10})},
                {new ShellArray(new int[]{10, 9, 5, 2, 1, 0, -8}), new ShellArray(new int[]{-8, 0, 1, 2, 5, 9, 10})},
                {new ShellArray(), new ShellArray()},
                {null, null}
        };
    }

    @DataProvider(name = "dataForArraySortingDecrease")
    public Object[][] dataForArraySortingDecrease() {
        return new Object[][]{
                {new ShellArray(new int[]{10, -8, 0, 1, 2, 5, 9}), new ShellArray(new int[]{10, 9, 5, 2, 1, 0, -8})},
                {new ShellArray(new int[]{-8, 0, 1, 2, 5, 9, 10}), new ShellArray(new int[]{10, 9, 5, 2, 1, 0, -8})},
                {new ShellArray(new int[]{10, 9, 5, 2, 1, 0, -8}), new ShellArray(new int[]{10, 9, 5, 2, 1, 0, -8})},
                {new ShellArray(), new ShellArray()},
                {null, null}
        };
    }

    @Test(dataProvider = "dataForArraySortingIncrease")
    public void bubbleSortArrayTestParamsIncrease(ShellArray shellArray, ShellArray expected) {
        sortArrayService.bubbleSort(shellArray, SortDirection.INCREASE);
        assertEquals(shellArray, expected);
    }

    @Test(dataProvider = "dataForArraySortingDecrease")
    public void bubbleSortArrayTestParamsDecrease(ShellArray shellArray, ShellArray expected) {
        sortArrayService.bubbleSort(shellArray, SortDirection.DECREASE);
        assertEquals(shellArray, expected);
    }

    @Test(dataProvider = "dataForArraySortingIncrease")
    public void straightInsertionSortTestParamsIncrease(ShellArray shellArray, ShellArray expected) {
        sortArrayService.straightInsertionSort(shellArray, SortDirection.INCREASE);
        assertEquals(shellArray, expected);
    }

    @Test(dataProvider = "dataForArraySortingDecrease")
    public void straightInsertionSortTestParamsDecrease(ShellArray shellArray, ShellArray expected) {
        sortArrayService.straightInsertionSort(shellArray, SortDirection.DECREASE);
        assertEquals(shellArray, expected);
    }

    @Test(dataProvider = "dataForArraySortingIncrease")
    public void straightSelectionSortTestParamsIncrease(ShellArray shellArray, ShellArray expected) {
        sortArrayService.straightSelectionSort(shellArray, SortDirection.INCREASE);
        assertEquals(shellArray, expected);
    }

    @Test(dataProvider = "dataForArraySortingDecrease")
    public void straightSelectionSortTestParamsDecrease(ShellArray shellArray, ShellArray expected) {
        sortArrayService.straightSelectionSort(shellArray, SortDirection.DECREASE);
        assertEquals(shellArray, expected);
    }
}