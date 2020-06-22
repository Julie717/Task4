package com.buyalskaya.array.parser;

import com.buyalskaya.array.exception.ProjectException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DataParserTest {
    DataParser dataParser;

    @BeforeClass
    public void setUp() {
        dataParser = new DataParser();
    }

    @Test
    public void parseDataToArrayTestPositive() {
        String data = "1 4   5   6 9\n 20";
        try {
            String[] actual = dataParser.parseDataToArray(data);
            String[] expected = {"1", "4", "5", "6", "9", "20"};
            assertEquals(actual, expected);
        } catch (ProjectException ex) {
            fail("Data format is incorrect");
        }
    }

    @Test
    public void parseDataToArrayTestNegative() {
        String data = "1 4   5   6 9 and 20";
        assertThrows(ProjectException.class, () -> dataParser.parseDataToArray(data));
    }

    @Test
    public void parseDataToArrayTestEmpty() {
        String data = "";
        assertThrows(ProjectException.class, () -> dataParser.parseDataToArray(data));
    }

    @Test
    public void parseDataToArrayTestValueGreaterMax() {
        String data = "1 4   5   6 9000 20";
        assertThrows(ProjectException.class, () -> dataParser.parseDataToArray(data));
    }

    @Test
    public void parseDataToArrayTestNull() {
        String data = null;
        assertThrows(ProjectException.class, () -> dataParser.parseDataToArray(data));
    }

    @Test
    public void parseDataToMatrixTestPositive() {
        String[] data = {"1 4   5   6 9\n 20", "1 2 3", "9", "10   -5"};
        try {
            String[][] actual = dataParser.parseDataToMatrix(data);
            String[][] expected = {{"1", "4", "5", "6", "9", "20"},
                    {"1", "2", "3"},
                    {"9"},
                    {"10", "-5"}};
            assertEquals(actual, expected);
        } catch (ProjectException ex) {
            fail("Data format is incorrect");
        }
    }

    @Test
    public void parseDataToMatrixTestNegative() {
        String[] data = {"1 4   5   6 9\n 20", "1 2.1 3", "9", "10   -5"};
        assertThrows(ProjectException.class, () -> dataParser.parseDataToMatrix(data));
    }

    @Test
    public void parseDataToMatrixTestValueLessMin() {
        String[] data = {"1 4   5   6 9\n 20", "1 2.1 3", "9", "10   -5 -1005"};
        assertThrows(ProjectException.class, () -> dataParser.parseDataToMatrix(data));
    }

    @Test
    public void parseDataToMatrixTestEmpty() {
        String[] data = {""};
        assertThrows(ProjectException.class, () -> dataParser.parseDataToMatrix(data));
    }

    @Test
    public void parseDataToMatrixTestNull() {
        String[] data = null;
        assertThrows(ProjectException.class, () -> dataParser.parseDataToMatrix(data));
    }
}