package com.buyalskaya.array.entity;

public class Decrease implements OrderSortable {

    @Override
    public boolean comparison(int a, int b) {
        return a < b;
    }
}