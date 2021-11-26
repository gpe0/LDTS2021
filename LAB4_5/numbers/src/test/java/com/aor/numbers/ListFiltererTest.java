package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {
    @Test
    public void filterTrue() {
        TrueFilter trueFilter = new TrueFilter();
        ListFilterer listFilterer = new ListFilterer(trueFilter);

        List<Integer> list = Arrays.asList(-5, 2, -1, 2, 0, 0, 9, 4);

        List<Integer> filtered = listFilterer.filter(list);

        List<Integer> expected = Arrays.asList(-5, 2, -1, 2, 0, 0, 9, 4);

        Assertions.assertEquals(expected, filtered);

    }

    @Test
    public void filterFalse() {
        FalseFilter falseFilter = new FalseFilter();
        ListFilterer listFilterer = new ListFilterer(falseFilter);

        List<Integer> list = Arrays.asList(-5, 2, -1, 2, 0, 0, 9, 4);

        List<Integer> filtered = listFilterer.filter(list);


        Assertions.assertTrue(filtered.isEmpty());

    }
}
