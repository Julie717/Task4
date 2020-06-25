package com.buyalskaya.array.function;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MaxRowElementTest {
    MaxRowElement maxRowElement;

    @BeforeClass
    public void setUp() {
        maxRowElement = new MaxRowElement();
    }

    @DataProvider(name = "dataForMaxRowElement")
    public Object[][] dataForMaxRowElement() {
        return new Object[][]{
                {new int[][]{{10, -8, 0, 1, 2, 5, 9},
                        {1, 4},
                        {9, 8, 0},
                        {2},
                        {-1, -1, 2}},
                        new int[]{10, 4, 9, 2, 2}},
                {new int[][]{{},
                        {1, 2},
                        {9, 8, 0},
                        {2},
                        {-1, 0, 2}},
                        new int[]{Integer.MIN_VALUE, 2, 9, 2, 2}},
                {new int[][]{}, new int[]{}},
                {null, new int[]{}}
        };
    }

    @Test(dataProvider = "dataForMaxRowElement")
    public void maxRowElementTestParams(int[][] matrix, int[] expected) {
        int[] actual = maxRowElement.apply(matrix);
        assertEquals(actual, expected);
    }
}