package com.buyalskaya.array.service;

import com.buyalskaya.array.comparator.AscendantComparator;
import com.buyalskaya.array.comparator.DescendantComparator;
import com.buyalskaya.array.comparator.NumberComparable;
import com.buyalskaya.array.entity.SortDirection;

public class SortDirectionService {

    public NumberComparable defineDirectionComparator(SortDirection sortDirection) {
        NumberComparable numberComparable;
        if (sortDirection == SortDirection.DECREASE) {
            numberComparable = new AscendantComparator();
        } else {
            numberComparable = new DescendantComparator();
        }
        return numberComparable;
    }
}