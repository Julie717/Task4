package com.buyalskaya.array.validator;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DataValidatorTest {
    DataValidator dataValidator;

    @BeforeClass
    public void setUp() {
        dataValidator = new DataValidator();
    }

    @Test
    public void isIntegerArrayTestPositive() {
        String[] numbers = {"1", "4", "7"};
        assertTrue(dataValidator.isIntegerArray(numbers));
    }

    @Test
    public void isIntegerArrayTestNegative() {
        String[] numbers = {"1.5", "2", "3"};
        assertFalse(dataValidator.isIntegerArray(numbers));
    }

    @Test
    public void isIntegerArrayTestEmpty() {
        String[] numbers = {""};
        assertFalse(dataValidator.isIntegerArray(numbers));
    }

    @Test
    public void isIntegerArrayTestNull() {
        String[] numbers = null;
        assertFalse(dataValidator.isIntegerArray(numbers));
    }

    @DataProvider(name = "dataForNumberIsInteger")
    public Object[][] dataForNumberIsInteger() {
        return new Object[][]{
                {"7", true},
                {"0", true},
                {"-4", true},
                {"11.5", false},
                {"one", false},
                {"7.", false},
                {"1E-9", false},
                {null, false}
        };
    }

    @Test(dataProvider = "dataForNumberIsInteger")
    public void isIntegerNumberTestParams(String number, boolean expected) {
        boolean actual = dataValidator.isIntegerNumber(number);
        assertEquals(actual, expected);
    }
}