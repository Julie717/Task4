package com.buyalskaya.array.entity;

import java.util.function.BiPredicate;

public enum SortDirection implements BiPredicate<Integer,Integer> {
    INCREASE{
        @Override
        public boolean test(Integer a, Integer b) {
            return a < b;
        }
    },
    DECREASE{
        @Override
        public boolean test(Integer a, Integer b) {
            return a > b;
        }
    }
}
