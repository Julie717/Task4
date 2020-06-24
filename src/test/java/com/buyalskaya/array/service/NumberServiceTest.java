package com.buyalskaya.array.service;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NumberServiceTest {
    NumberService numberService;

    @BeforeClass
    public void setUp() {
        numberService = new NumberService();
    }

    @DataProvider(name = "dataForIsPrime")
    public Object[][] dataForIsPrime() {
        return new Object[][]{
                {13, true},
                {17, true},
                {31, true},
                {1, false},
                {-5, false},
                {0, false}
        };
    }

    @Test(dataProvider = "dataForIsPrime")
    public void isPrimeTestParams(int number, boolean expected) {
        boolean actual = numberService.isPrime(number);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForIsFibonacci")
    public Object[][] dataForIsFibonacci() {
        return new Object[][]{
                {1, true},
                {5, true},
                {55, true},
                {377, true},
                {0, false},
                {-15, false}
        };
    }

    @Test(dataProvider = "dataForIsFibonacci")
    public void isFibonacciTestParams(int number, boolean expected) {
        boolean actual = numberService.isFibonacci(number);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForCalculateNumberDigit")
    public Object[][] dataForCalculateNumberDigit() {
        return new Object[][]{
                {1, 1},
                {57, 2},
                {595, 3},
                {-7, 1},
                {-87, 2},
                {-115, 3}
        };
    }

    @Test(dataProvider = "dataForCalculateNumberDigit")
    public void calculateNumberDigitTestParams(int number, int expected) {
        int actual = numberService.calculateNumberDigit(number);
        assertEquals(actual, expected);
    }


    @DataProvider(name = "dataForIsDifferentDigits")
    public Object[][] dataForIsDifferentDigits() {
        return new Object[][]{
                {1, true},
                {57, true},
                {597, true},
                {-7, true},
                {-95, true},
                {-195, true},
                {11, false},
                {-22, false},
                {191, false},
                {-577, false}
        };
    }

    @Test(dataProvider = "dataForIsDifferentDigits")
    public void isDifferentDigitsTestParams(int number, boolean expected) {
        boolean actual = numberService.isDifferentDigits(number);
        assertEquals(actual, expected);
    }
}