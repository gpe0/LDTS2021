package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer {
    GenericListFilter filter;
    public ListFilterer(GenericListFilter filter) {
        this.filter = filter;
    }

    public List<Integer> filter(List<Integer> list) {
        List<Integer> filtered = new ArrayList<>();
        for (int element: list) {
            if (filter.accept(element)) {
                filtered.add(element);
            }
        }
        return filtered;
    }
}
