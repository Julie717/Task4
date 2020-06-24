package com.buyalskaya.array.service;

import com.buyalskaya.array.comparator.AscendantComparator;
import com.buyalskaya.array.comparator.DescendantComparator;
import com.buyalskaya.array.comparator.NumberComparable;
import com.buyalskaya.array.entity.ShellArray;
import com.buyalskaya.array.exception.ProjectException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.OptionalInt;

import static org.testng.Assert.*;

public class ArrayServiceTest {
    ArrayService arrayService;
    ShellArray shellArray;

    @BeforeClass
    public void setUp() {
        arrayService = new ArrayService();
    }

    @DataProvider(name = "dataForSearchIndexMinOrMax")
    public Object[][] dataForSearchIndexMinOrMax() {
        return new Object[][]{
                {new ShellArray(new int[]{1, 2, 5, 9}), 0, new DescendantComparator(), OptionalInt.of(0)},
                {new ShellArray(new int[]{1, 18, 10, 9}), 0, new AscendantComparator(), OptionalInt.of(1)},
                {new ShellArray(new int[]{0, -2, -5, 9}), 0, new AscendantComparator(), OptionalInt.of(3)},
                {new ShellArray(new int[]{0, -2, -5, 9, 7, -1, 2, 4}), 3, new DescendantComparator(), OptionalInt.of(5)},
                {new ShellArray(new int[]{0, -2, -5, 9, 7, -1, 2, 4}), 3, new AscendantComparator(), OptionalInt.of(3)},
                {new ShellArray(new int[]{10, -8, 0, 1, 2, 5, 9}), 6, new AscendantComparator(), OptionalInt.of(6)},
                {new ShellArray(new int[]{1, 18, 10, 9}), -1, new AscendantComparator(), OptionalInt.empty()},
                {new ShellArray(new int[]{1, 18, 10, 9}), 4, new AscendantComparator(), OptionalInt.empty()},
                {new ShellArray(), 3, new AscendantComparator(), OptionalInt.empty()},
                {null, 3, new AscendantComparator(), OptionalInt.empty()}
        };
    }

    @Test(dataProvider = "dataForSearchIndexMinOrMax")
    public void searchIndexMinOrMaxTestParams(ShellArray shellArray, int startIndex,
                                              NumberComparable orderSortable, OptionalInt expected) {
        OptionalInt actual = arrayService.searchIndexMinOrMax(shellArray, startIndex, orderSortable);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForSearchMinElement")
    public Object[][] dataForSearchMinElement() {
        return new Object[][]{
                {new ShellArray(new int[]{1, 2, 5, 9}), OptionalInt.of(1)},
                {new ShellArray(new int[]{0, -2, -5, 9, 7, -1, 2, 4}), OptionalInt.of(-5)},
                {new ShellArray(new int[]{47, 18, 10, 9}), OptionalInt.of(9)},
                {new ShellArray(), OptionalInt.empty()},
                {null, OptionalInt.empty()}
        };
    }

    @Test(dataProvider = "dataForSearchMinElement")
    public void searchMinElementTestParams(ShellArray shellArray, OptionalInt expected) {
        OptionalInt actual = arrayService.searchMinElement(shellArray);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForSearchMaxElement")
    public Object[][] dataForSearchMaxElement() {
        return new Object[][]{
                {new ShellArray(new int[]{1, 2, 5, 9}), OptionalInt.of(9)},
                {new ShellArray(new int[]{0, -2, -5, 15, 7, -1, 2, 4}), OptionalInt.of(15)},
                {new ShellArray(new int[]{47, 18, 10, 9}), OptionalInt.of(47)},
                {new ShellArray(), OptionalInt.empty()},
                {null, OptionalInt.empty()}
        };
    }

    @Test(dataProvider = "dataForSearchMaxElement")
    public void searchMaxElementTestParams(ShellArray shellArray, OptionalInt expected) {
        OptionalInt actual = arrayService.searchMaxElement(shellArray);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForBinarySearchIndexElement")
    public Object[][] dataForBinarySearchIndexElement() {
        return new Object[][]{
                {-5, OptionalInt.of(0)},
                {0, OptionalInt.of(2)},
                {7, OptionalInt.of(4)},
                {9, OptionalInt.of(6)},
                {-6, OptionalInt.empty()},
                {15, OptionalInt.empty()},
                {3, OptionalInt.empty()}
        };
    }

    @Test(dataProvider = "dataForBinarySearchIndexElement")
    public void binarySearchIndexElementTestParams(int number, OptionalInt expected) {
        shellArray = new ShellArray(new int[]{-5, -1, 0, 4, 7, 8, 9});
        try {
            OptionalInt actual = arrayService.binarySearchIndexElement(shellArray, number);
            assertEquals(actual, expected);
        } catch (ProjectException ex) {
            fail("Array must have ascending order");
        }
    }

    @Test
    public void binarySearchIndexElementTestNull() {
        shellArray = null;
        int number = 9;
        OptionalInt expected = OptionalInt.empty();
        try {
            OptionalInt actual = arrayService.binarySearchIndexElement(shellArray, number);
            assertEquals(actual, expected);
        } catch (ProjectException ex) {
            fail("Array must have ascending order");
        }
    }

    @Test
    public void binarySearchIndexElementTestNegative() {
        shellArray = new ShellArray(new int[]{4, 3, -5, 0, -1, 7, 8, 9});
        int number = 9;
        assertThrows(ProjectException.class, () -> arrayService.binarySearchIndexElement(shellArray, number));
    }

    @DataProvider(name = "dataForSearchPrimeNumber")
    public Object[][] dataForSearchPrimeNumber() {
        return new Object[][]{
                {new ShellArray(new int[]{1, 2, 5, 9}), new ShellArray(new int[]{2, 5})},
                {new ShellArray(new int[]{1, 18, 10, 9}), new ShellArray()},
                {new ShellArray(new int[]{0, -2, -5, 9}), new ShellArray()},
                {new ShellArray(), new ShellArray()},
                {null, new ShellArray()}
        };
    }

    @Test(dataProvider = "dataForSearchPrimeNumber")
    public void searchPrimeNumberTestParams(ShellArray shellArray, ShellArray expected) {
        ShellArray actual = arrayService.searchPrimeNumber(shellArray);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForSearchFibonacciNumber")
    public Object[][] dataForSearchFibonacciNumber() {
        return new Object[][]{
                {new ShellArray(new int[]{1, 2, 5, 89}), new ShellArray(new int[]{1, 2, 5, 89})},
                {new ShellArray(new int[]{4, 18, 10, 6}), new ShellArray()},
                {new ShellArray(new int[]{0, -2, -5, 9}), new ShellArray()},
                {new ShellArray(), new ShellArray()},
                {null, new ShellArray()}
        };
    }

    @Test(dataProvider = "dataForSearchFibonacciNumber")
    public void  searchFibonacciNumberTestParams(ShellArray shellArray, ShellArray expected) {
        ShellArray actual = arrayService.searchFibonacciNumber(shellArray);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForSearchNumberWithDifferentDigits")
    public Object[][] dataForSearchNumberWithDifferentDigits() {
        return new Object[][]{
                {new ShellArray(new int[]{1, 200, 514, 897,597}), new ShellArray(new int[]{514, 897,597})},
                {new ShellArray(new int[]{-156, 18, -10, 699}), new ShellArray(new int[]{-156})},
                {new ShellArray(new int[]{0, -2, -5, 9}), new ShellArray()},
                {new ShellArray(new int[]{122, 121, 885, 979}), new ShellArray()},
                {new ShellArray(), new ShellArray()},
                {null, new ShellArray()}
        };
    }

    @Test(dataProvider = "dataForSearchNumberWithDifferentDigits")
    public void searchNumberWithDifferentDigitsTestParams(ShellArray shellArray, ShellArray expected) {
        try {
            ShellArray actual = arrayService.searchNumberWithDifferentDigits(shellArray, 3);
            assertEquals(actual, expected);
        } catch (ProjectException ex) {
            fail("Incorrect number of digits");
        }
    }

    @Test
    public void searchNumberWithDifferentDigitsNegative() {
        shellArray = new ShellArray(new int[]{400, 315, -514, 0});
        int numberDigit = 0;
        assertThrows(ProjectException.class,
                () -> arrayService.searchNumberWithDifferentDigits(shellArray, numberDigit));
    }
}