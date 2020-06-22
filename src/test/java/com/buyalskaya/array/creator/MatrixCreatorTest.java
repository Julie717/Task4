package com.buyalskaya.array.creator;

import com.buyalskaya.array.entity.ShellArray;
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
    public void createShellArrayTest() {
        String[][] dataMatrix = {{"1", "4", "7"},
                {"-5", "0"},
                {"14", "3", "6", "7"},
                {"1"}};
        int[][] expected = {{1, 4, 7},
                {-5, 0},
                {14, 3, 6, 7},
                {1}};
        int[][]actual = matrixCreator.createMatrix(dataMatrix);
        assertEquals(actual, expected);
    }
}
