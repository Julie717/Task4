package com.buyalskaya.array.service;

import com.buyalskaya.array.exception.ProjectException;
import com.buyalskaya.array.entity.SortDirection;
import com.buyalskaya.array.entity.SortType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SortMatrixServiceTest {
    SortMatrixService sortMatrixService;
    int[][] matrix;

    @BeforeClass
    public void setUp() {
        sortMatrixService = new SortMatrixService();
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
            sortMatrixService.bubbleSort(matrix, SortType.SUM_ROW_ELEMENT, SortDirection.DECREASE);
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
            sortMatrixService.bubbleSort(matrix, SortType.SUM_ROW_ELEMENT, SortDirection.INCREASE);
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
            sortMatrixService.bubbleSort(matrix, SortType.MAX_ROW_ELEMENT, SortDirection.DECREASE);
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
            sortMatrixService.bubbleSort(matrix, SortType.MAX_ROW_ELEMENT, SortDirection.INCREASE);
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
            sortMatrixService.bubbleSort(matrix, SortType.MIN_ROW_ELEMENT, SortDirection.DECREASE);
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
            sortMatrixService.bubbleSort(matrix, SortType.MIN_ROW_ELEMENT, SortDirection.INCREASE);
            assertEquals(matrix, expected);
        } catch (ProjectException ex) {
            fail("Incorrect input data");
        }
    }

    @Test
    public void bubbleSortMatrixTestTypeSortingNull() {
        assertThrows(ProjectException.class,
                () -> sortMatrixService.bubbleSort(matrix, null, SortDirection.DECREASE));
    }

    @Test
    public void bubbleSortMatrixTestOrderComparableNull() {
        assertThrows(ProjectException.class,
                () -> sortMatrixService.bubbleSort(matrix, SortType.SUM_ROW_ELEMENT, null));
    }

    @Test
    public void bubbleSortMatrixTestMatrixNull() {
        int[][] matrix = null;
        assertThrows(ProjectException.class,
                () -> sortMatrixService.bubbleSort(matrix, SortType.SUM_ROW_ELEMENT, SortDirection.DECREASE));
    }

    @Test
    public void bubbleSortMatrixTestMatrixEmptyRowMin() {
        matrix[2] = new int[]{};
        int[][] expected = new int[][]{{},
                {-8, 4, 10},
                {0},
                {1, 2},
                {2, 4, 7}};
        try {
            sortMatrixService.bubbleSort(matrix, SortType.MIN_ROW_ELEMENT, SortDirection.INCREASE);
            assertEquals(matrix, expected);
        } catch (ProjectException ex) {
            fail("Incorrect input data");
        }
    }

    @Test
    public void bubbleSortMatrixTestMatrixEmptyRowMax() {
        matrix[2] = new int[]{};
        int[][] expected = new int[][]{{-8, 4, 10},
                {2, 4, 7},
                {1, 2},
                {0},
                {}};
        try {
            sortMatrixService.bubbleSort(matrix, SortType.MAX_ROW_ELEMENT, SortDirection.DECREASE);
            assertEquals(matrix, expected);
        } catch (ProjectException ex) {
            fail("Incorrect input data");
        }
    }

    @Test
    public void bubbleSortMatrixTestMatrixEmptyRowSum() {
        matrix[2] = new int[]{};
        int[][] expected = new int[][]{{2, 4, 7},
                {-8, 4, 10},
                {1, 2},
                {0},
                {}};
        try {
            sortMatrixService.bubbleSort(matrix, SortType.SUM_ROW_ELEMENT, SortDirection.DECREASE);
            assertEquals(matrix, expected);
        } catch (ProjectException ex) {
            fail("Incorrect input data");
        }
    }

    @Test
    public void bubbleSortMatrixTestMatrixEmpty() {
        matrix = new int[][]{};
        int[][] expected = new int[][]{};
        try {
            sortMatrixService.bubbleSort(matrix, SortType.SUM_ROW_ELEMENT, SortDirection.DECREASE);
            assertEquals(matrix, expected);
        } catch (ProjectException ex) {
            fail("Incorrect input data");
        }
    }
}