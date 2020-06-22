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
    public void createShellArrayTest() {
        String[] numbers = {"1", "4", "7"};
        ShellArray actual=shellArrayCreator.createShellArray(numbers);
        ShellArray expected = new ShellArray(new int[]{1, 4, 7});
        assertEquals(actual,expected);
    }
}
