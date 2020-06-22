package com.buyalskaya.array.service;

import com.buyalskaya.array.entity.ShellArray;
import com.buyalskaya.array.exception.ProjectException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.*;

public class ArrayServiceTest {
    ArrayService arrayService;
    ShellArray shellArray;

    @BeforeClass
    public void setUp() {
        arrayService = new ArrayService();
    }

    @DataProvider(name = "dataForFindIndexElement")
    public Object[][] dataForFindIndexElement() {
        return new Object[][]{
                {-5, Optional.of(0)},
                {0, Optional.of(2)},
                {7, Optional.of(4)},
                {9, Optional.of(6)},
                {-6, Optional.empty()},
                {15, Optional.empty()},
                {3, Optional.empty()}
        };
    }

    @Test(dataProvider = "dataForFindIndexElement")
    public void findIndexElementTestParams(int number, Optional<Integer> expected) {
        shellArray = new ShellArray(new int[]{-5, -1, 0, 4, 7, 8, 9});
        try {
            Optional<Integer> actual = arrayService.findIndexElement(shellArray, number);
            assertEquals(actual, expected);
        } catch (ProjectException ex) {
            fail("Array must have ascending order");
        }
    }

    @Test
    public void findIndexElementTestNull() {
        shellArray = null;
        int number = 9;
        Optional<Integer> expected = Optional.empty();
        try {
            Optional<Integer> actual = arrayService.findIndexElement(shellArray, number);
            assertEquals(actual, expected);
        } catch (ProjectException ex) {
            fail("Array must have ascending order");
        }
    }

    @Test
    public void findIndexElementTestNegative() {
        shellArray = new ShellArray(new int[]{4, 3, -5, 0, -1, 7, 8, 9});
        int number = 9;
        assertThrows(ProjectException.class, () -> arrayService.findIndexElement(shellArray, number));
    }

    @DataProvider(name = "dataForFindPrimeNumber")
    public Object[][] dataForFindPrimeNumber() {
        return new Object[][]{
                {new ShellArray(new int[]{1, 2, 5, 9}), new ShellArray(new int[]{2, 5})},
                {new ShellArray(new int[]{1, 18, 10, 9}), new ShellArray()},
                {new ShellArray(new int[]{0, -2, -5, 9}), new ShellArray()},
                {null, new ShellArray()}
        };
    }

    @Test(dataProvider = "dataForFindPrimeNumber")
    public void findPrimeNumberTestParams(ShellArray shellArray, ShellArray expected) {
        ShellArray actual = arrayService.findPrimeNumber(shellArray);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForFindFibonacciNumber")
    public Object[][] dataForFindFibonacciNumber() {
        return new Object[][]{
                {new ShellArray(new int[]{1, 2, 5, 89}), new ShellArray(new int[]{1, 2, 5, 89})},
                {new ShellArray(new int[]{4, 18, 10, 6}), new ShellArray()},
                {new ShellArray(new int[]{0, -2, -5, 9}), new ShellArray()},
                {null, new ShellArray()}
        };
    }

    @Test(dataProvider = "dataForFindFibonacciNumber")
    public void findFibonacciNumberTestParams(ShellArray shellArray, ShellArray expected) {
        ShellArray actual = arrayService.findFibonacciNumber(shellArray);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForFindNumberWithoutIdenticalDigits")
    public Object[][] dataForFindNumberWithoutIdenticalDigits() {
        return new Object[][]{
                {new ShellArray(new int[]{1, 200, 514, 897}), new ShellArray(new int[]{514, 897})},
                {new ShellArray(new int[]{-156, 18, -10, 699}), new ShellArray(new int[]{-156})},
                {new ShellArray(new int[]{0, -2, -5, 9}), new ShellArray()},
                {new ShellArray(new int[]{122, 121, 885, 979}), new ShellArray()},
                {null, new ShellArray()}
        };
    }

    @Test(dataProvider = "dataForFindNumberWithoutIdenticalDigits")
    public void findNumberWithoutIdenticalDigitsTestParams(ShellArray shellArray, ShellArray expected) {
        try {
            ShellArray actual = arrayService.findNumberWithoutIdenticalDigits(shellArray, 3);
            assertEquals(actual, expected);
        } catch (ProjectException ex) {
            fail("Incorrect number of digits");
        }
    }

    @Test
    public void findNumberWithoutIdenticalDigitsNegative() {
        shellArray = new ShellArray(new int[]{400, 315, -514, 0});
        int numberDigit = 0;
        assertThrows(ProjectException.class,
                () -> arrayService.findNumberWithoutIdenticalDigits(shellArray, numberDigit));
    }
}