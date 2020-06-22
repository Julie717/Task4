package com.buyalskaya.array.entity;

public class Increase implements OrderSortable {

    @Override
    public boolean comparison(int a, int b) {
        return a > b;
    }
}