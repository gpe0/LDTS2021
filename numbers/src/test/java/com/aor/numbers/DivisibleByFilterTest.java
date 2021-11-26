package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DivisibleByFilterTest {
    @Test
    public void accept1() {
        DivisibleByFilter divisibleByFilter = new DivisibleByFilter(5);

        boolean res = divisibleByFilter.accept(25);

        boolean expected = true;

        Assertions.assertEquals(expected, res);
    }

    @Test
    public void accept2() {
        DivisibleByFilter divisibleByFilter = new DivisibleByFilter(5);

        boolean res = divisibleByFilter.accept(24);

        boolean expected = false;

        Assertions.assertEquals(expected, res);
    }
}
