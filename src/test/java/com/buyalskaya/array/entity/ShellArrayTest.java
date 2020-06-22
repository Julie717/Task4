package com.buyalskaya.array.entity;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ShellArrayTest {
    ShellArray shellArray;

    @BeforeClass
    public void setUp() {
        shellArray = new ShellArray(new int[]{7, 8, -5, 1, 2});
    }

    @Test
    public void addTestPositive() {
        int number = 4;
        assertTrue(shellArray.add(number));
    }

    @Test
    public void addTestNegative() {
        int number = -9000;
        assertFalse(shellArray.add(number));
    }

    @Test
    public void removeTestPositive() {
        int number = 2;
        assertTrue(shellArray.remove(number));
    }

    @Test
    public void removeTestNegative() {
        int number = -1;
        assertFalse(shellArray.remove(number));
    }

    @Test
    public void removeTestMoreThanBoundIndex() {
        int number = 15;
        assertFalse(shellArray.remove(number));
    }

    @Test
    public void minElementTest() {
        int actual = shellArray.minElement();
        int expected = -5;
        assertEquals(actual, expected);
    }

    @Test
    public void maxElementTest() {
        int actual = shellArray.maxElement();
        int expected = 8;
        assertEquals(actual, expected);
    }
}