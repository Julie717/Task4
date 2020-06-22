package com.buyalskaya.array.service;

import com.buyalskaya.array.entity.Decrease;
import com.buyalskaya.array.entity.Increase;
import com.buyalskaya.array.entity.ShellArray;
import com.buyalskaya.array.entity.TypeSorting;
import com.buyalskaya.array.exception.ProjectException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SortingServiceTest {
    SortingService sortingService;
    int[][] matrix;

    @BeforeClass
    public void setUp() {
        sortingService = new SortingService();
    }

    @DataProvider(name = "dataForArraySorting")
    public Object[][] dataForArraySorting() {
        return new Object[][]{
                {new ShellArray(new int[]{10, -8, 0, 1, 2, 5, 9}), new ShellArray(new int[]{-8, 0, 1, 2, 5, 9, 10})},
                {new ShellArray(new int[]{-8, 0, 1, 2, 5, 9, 10}), new ShellArray(new int[]{-8, 0, 1, 2, 5, 9, 10})},
                {new ShellArray(new int[]{10, 9, 5, 2, 1, 0, -8}), new ShellArray(new int[]{-8, 0, 1, 2, 5, 9, 10})},
                {new ShellArray(), new ShellArray()},
                {null, null}
        };
    }

    @Test(dataProvider = "dataForArraySorting")
    public void bubbleSortArrayTestParams(ShellArray shellArray, ShellArray expected) {
        sortingService.bubbleSort(shellArray);
        assertEquals(shellArray, expected);
    }

    @Test(dataProvider = "dataForArraySorting")
    public void straightInsertionSortTestParams(ShellArray shellArray, ShellArray expected) {
        sortingService.straightInsertionSort(shellArray);
        assertEquals(shellArray, expected);
    }

    @Test(dataProvider = "dataForArraySorting")
    public void straightSelectionSortTestParams(ShellArray shellArray, ShellArray expected) {
        sortingService.straightInsertionSort(shellArray);
        assertEquals(shellArray, expected);
    }

    @BeforeMethod
    public void receivingMatrix() {
        matrix = new int[][]{{1, 2},
                {-8, 4, 10},
                {6, -2, 3},
                {0},
                {2, 4, 7}};

    }

    @Test
    public void bubbleSortMatrixTestPositiveSumDecrease() {
        int[][] expected = new int[][]{{2, 4, 7},
                {6, -2, 3},
                {-8, 4, 10},
                {1, 2},
                {0}};
        try {
            sortingService.bubbleSort(matrix, TypeSorting.SUM, new Decrease());

            assertEquals(matrix, expected);
        } catch (ProjectException ex) {
            fail("Incorrect input data");
        }
    }

    @Test
    public void bubbleSortMatrixTestPositiveSumIncrease() {
        int[][] expected = new int[][]{{0},
                {1, 2},
                {-8, 4, 10},
                {6, -2, 3},
                {2, 4, 7}};
        try {
            sortingService.bubbleSort(matrix, TypeSorting.SUM, new Increase());

            assertEquals(matrix, expected);
        } catch (ProjectException ex) {
            fail("Incorrect input data");
        }
    }

    @Test
    public void bubbleSortMatrixTestPositiveMaxDecrease() {
        int[][] expected = new int[][]{{-8, 4, 10},
                {2, 4, 7},
                {6, -2, 3},
                {1, 2},
                {0}};
        try {
            sortingService.bubbleSort(matrix, TypeSorting.MAX, new Decrease());

            assertEquals(matrix, expected);
        } catch (ProjectException ex) {
            fail("Incorrect input data");
        }
    }

    @Test
    public void bubbleSortMatrixTestPositiveMaxIncrease() {
        int[][] expected = new int[][]{{0},
                {1, 2},
                {6, -2, 3},
                {2, 4, 7},
                {-8, 4, 10}};
        try {
            sortingService.bubbleSort(matrix, TypeSorting.MAX, new Increase());

            assertEquals(matrix, expected);
        } catch (ProjectException ex) {
            fail("Incorrect input data");
        }
    }

    @Test
    public void bubbleSortMatrixTestPositiveMinDecrease() {
        int[][] expected = new int[][]{{2, 4, 7},
                {1, 2},
                {0},
                {6, -2, 3},
                {-8, 4, 10}};
        try {
            sortingService.bubbleSort(matrix, TypeSorting.MIN, new Decrease());

            assertEquals(matrix, expected);
        } catch (ProjectException ex) {
            fail("Incorrect input data");
        }
    }

    @Test
    public void bubbleSortMatrixTestPositiveMinIncrease() {
        int[][] expected = new int[][]{{-8, 4, 10},
                {6, -2, 3},
                {0},
                {1, 2},
                {2, 4, 7}};
        try {
            sortingService.bubbleSort(matrix, TypeSorting.MIN, new Increase());
            assertEquals(matrix, expected);
        } catch (ProjectException ex) {
            fail("Incorrect input data");
        }
    }

    @Test
    public void bubbleSortMatrixTestTypeSortingNull() {
        assertThrows(ProjectException.class,
                () -> sortingService.bubbleSort(matrix, null, new Increase()));
    }

    @Test
    public void bubbleSortMatrixTestOrderSortableNull() {
        assertThrows(ProjectException.class,
                () -> sortingService.bubbleSort(matrix, TypeSorting.SUM, null));
    }
}