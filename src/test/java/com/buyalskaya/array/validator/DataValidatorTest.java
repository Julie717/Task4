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
    public void validateDataTestPositive() {
        String[] numbers = {"1", "4", "7"};
        assertTrue(dataValidator.validateData(numbers));
    }

    @Test
    public void validateDataTestNegative() {
        String[] numbers = {"1.5", "2", "3"};
        assertFalse(dataValidator.validateData(numbers));
    }

    @DataProvider(name = "dataForValidateIsInteger")
    public Object[][] dataForValidateIsInteger() {
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

    @Test(dataProvider = "dataForValidateIsInteger")
    public void validateIsIntegerTestParams(String number, boolean expected) {
        boolean actual = dataValidator.validateIsInteger(number);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForValidateNumber")
    public Object[][] dataForValidateNumber() {
        return new Object[][]{
                {1, true},
                {0, true},
                {-7, true},
                {1000, true},
                {-1000, true},
                {5000, false},
                {-5000, false}
        };
    }

    @Test(dataProvider = "dataForValidateNumber")
    public void validateNumberTestParams(int number, boolean expected) {
        boolean actual = dataValidator.validateNumber(number);
        assertEquals(actual, expected);
    }
}