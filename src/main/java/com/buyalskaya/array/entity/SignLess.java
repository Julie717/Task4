package com.buyalskaya.array.entity;

public class SignLess implements OrderComparable {

    @Override
    public boolean comparison(int a, int b) {
        return a < b;
    }
}