package com.buyalskaya.array.creator;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MatrixCreatorTest {
    MatrixCreator matrixCreator;

    @BeforeClass
    public void setUp() {
        matrixCreator = new MatrixCreator();
    }

    @Test
    public void createMatrixTestPositive() {
        String[][] dataMatrix = {{"1", "4", "7"},
                {"-5", "0"},
                {"14", "3", "6", "7"},
                {"1"}};
        int[][] expected = {{1, 4, 7},
                {-5, 0},
                {14, 3, 6, 7},
                {1}};
        int[][] actual = matrixCreator.createMatrix(dataMatrix);
        assertEquals(actual, expected);
    }

    @Test
    public void createMatrixTestNegative() {
        String[][] dataMatrix = {{"1", "4", "7"},
                {"-5", "1E-55"},
                {"14", "3", "6", "7"},
                {"1"}};
        int[][] expected = new int[][]{};
        int[][] actual = matrixCreator.createMatrix(dataMatrix);
        assertEquals(actual, expected);
    }

    @Test
    public void createMatrixTestNull() {
        String[][] dataMatrix = null;
        int[][] expected = new int[][]{};
        int[][] actual = matrixCreator.createMatrix(dataMatrix);
        assertEquals(actual, expected);
    }
}