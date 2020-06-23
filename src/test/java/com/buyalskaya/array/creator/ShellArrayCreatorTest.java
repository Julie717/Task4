package com.buyalskaya.array.creator;

import com.buyalskaya.array.entity.ShellArray;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ShellArrayCreatorTest {
    ShellArrayCreator shellArrayCreator;

    @BeforeClass
    public void setUp() {
        shellArrayCreator = new ShellArrayCreator();
    }

    @Test
    public void createShellArrayTestPositive() {
        String[] numbers = {"1", "4", "7"};
        ShellArray actual=shellArrayCreator.createShellArray(numbers);
        ShellArray expected = new ShellArray(new int[]{1, 4, 7});
        assertEquals(actual,expected);
    }

    @Test
    public void createShellArrayTestNull() {
        String[] numbers = null;
        ShellArray actual=shellArrayCreator.createShellArray(numbers);
        ShellArray expected = new ShellArray();
        assertEquals(actual,expected);
    }

    @Test
    public void createShellArrayTestEmpty() {
        String[] numbers ={""};
        ShellArray actual=shellArrayCreator.createShellArray(numbers);
        ShellArray expected = new ShellArray();
        assertEquals(actual,expected);
    }
}
