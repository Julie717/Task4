package com.buyalskaya.array.typesort;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MinRowElementTest {
    MinRowElement minRowElement;

    @BeforeClass
    public void setUp() {
        minRowElement = new MinRowElement();
    }

    @DataProvider(name = "dataForMinRowElement")
    public Object[][] dataForMinRowElement() {
        return new Object[][]{
                {new int[][]{{10, -8, 0, 1, 2, 5, 9},
                        {1, 4},
                        {9, 8, 0},
                        {2},
                        {-1, -1, 2}},
                        new int[]{-8, 1, 0, 2, -1}},
                {new int[][]{{},
                        {1, 2},
                        {9, 8, 0},
                        {2},
                        {-1, 0, 2}},
                        new int[]{Integer.MIN_VALUE, 1, 0, 2, -1}},
                {new int[][]{}, new int[]{}},
                {null, new int[]{}}
        };
    }

    @Test(dataProvider = "dataForMinRowElement")
    public void minRowElementTestParams(int[][] matrix, int[] expected) {
        int[] actual = minRowElement.apply(matrix);
        assertEquals(actual, expected);
    }
}