package com.buyalskaya.array.typesort;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SumRowElementTest {
    SumRowElement sumRowElement;

    @BeforeClass
    public void setUp() {
        sumRowElement = new SumRowElement();
    }

    @DataProvider(name = "dataForSumRowElement")
    public Object[][] dataForMaxSumElement() {
        return new Object[][]{
                {new int[][]{{10, -8, 0, 1, 2, 5, 9},
                        {1, 4},
                        {9, 8, 0},
                        {2},
                        {-1, -1, 2}},
                        new int[]{19, 5, 17, 2, 0}},
                {new int[][]{{},
                        {1, 2},
                        {9, 8, 0},
                        {2},
                        {-1, 0, 2}},
                        new int[]{Integer.MIN_VALUE, 3, 17, 2, 1}},
                {new int[][]{},new int[]{}},
                {null, null}
               };
    }

    @Test(dataProvider = "dataForSumRowElement")
    public void sumRowElementTestParams(int[][] matrix, int[] expected) {
        int[] actual = sumRowElement.apply(matrix);
        assertEquals(actual, expected);
    }
}