package com.buyalskaya.array.comparator;

public class AscendantComparator implements NumberComparable {
    @Override
    public boolean compareTo(int a, int b) {
        return a > b;
    }
}