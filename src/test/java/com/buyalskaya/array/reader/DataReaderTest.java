package com.buyalskaya.array.reader;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DataReaderTest {
    DataReader dataReader;

    @BeforeClass
    public void setUp() {
        dataReader = new DataReader();
    }

    @Test
    public void readArrayFromFileTestPositive() {
        String filePath = "resources/array.txt";
        String actual = dataReader.readArrayFromFile(filePath);
        String expected = "4 6 8 100 256 7 -9 9 8 712 45 78 -99 5 8 87 1 3";
        assertEquals(actual, expected);
    }

    @Test
    public void readArrayFromFileTestNegative() {
        String filePath = "resources/input.txt";
        assertThrows(RuntimeException.class, () -> dataReader.readArrayFromFile(filePath));
    }

    @Test
    public void readArrayFromFileTestNull() {
        String filePath = null;
        assertThrows(RuntimeException.class, () -> dataReader.readArrayFromFile(filePath));
    }

    @Test
    public void readArrayFromFileTestEmpty() {
        String filePath = "";
        assertThrows(RuntimeException.class, () -> dataReader.readArrayFromFile(filePath));
    }

    @Test
    public void readMatrixFromFileTestPositive() {
        String filePath = "resources/matrix.txt";
        String[] actual = dataReader.readMatrixFromFile(filePath);
        String[] expected = {"-8 7 9 4 6",
                "1",
                "2 6 4 0 -7 1 8",
                "-4 5",
                "2 10 6 4",
                "1 2 3"};
        assertEquals(actual, expected);
    }

    @Test
    public void readMatrixFromFileTestNegative() {
        String filePath = "resources/input.txt";
        assertThrows(RuntimeException.class, () -> dataReader.readMatrixFromFile(filePath));
    }

    @Test
    public void readMatrixFromFileTestNull() {
        String filePath = null;
        assertThrows(RuntimeException.class, () -> dataReader.readMatrixFromFile(filePath));
    }

    @Test
    public void readMatrixFromFileTestEmpty() {
        String filePath = "";
        assertThrows(RuntimeException.class, () -> dataReader.readMatrixFromFile(filePath));
    }
}