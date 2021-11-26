package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositiveFilterTest {
    @Test
    public void acceptNotPositive() {
        PositiveFilter positiveFilter = new PositiveFilter();

        boolean res = positiveFilter.accept(0);

        boolean expected = false;

        Assertions.assertEquals(expected, res);
    }

    @Test
    public void acceptPositive() {
        PositiveFilter positiveFilter = new PositiveFilter();

        boolean res = positiveFilter.accept(4);

        boolean expected = true;

        Assertions.assertEquals(expected, res);
    }
}
