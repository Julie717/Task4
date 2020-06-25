package com.buyalskaya.array.entity;

import com.buyalskaya.array.function.MaxRowElement;
import com.buyalskaya.array.function.MinRowElement;
import com.buyalskaya.array.function.SumRowElement;

import java.util.function.Function;

public enum SortType implements Function<int[][], int[]> {
    SUM_ROW_ELEMENT(new SumRowElement()),
    MAX_ROW_ELEMENT(new MaxRowElement()),
    MIN_ROW_ELEMENT(new MinRowElement());

    private Function<int[][], int[]> calculationRowCharacteristics;

    SortType(Function<int[][], int[]> calculationRowCharacteristics) {
        this.calculationRowCharacteristics = calculationRowCharacteristics;
    }

    @Override
    public int[] apply(int[][] matrix) {
        return calculationRowCharacteristics.apply(matrix);
    }
}