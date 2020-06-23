package com.buyalskaya.array.entity;

public class SignGreater implements OrderComparable {

    @Override
    public boolean comparison(int a, int b) {
        return a > b;
    }
}