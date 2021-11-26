package com.aor.numbers;

import com.sun.tools.javac.jvm.Gen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {

    List<Integer> list;

    @BeforeEach
    public void helper() {
        list = Arrays.asList(1, 2, 4, 2, 5);
    }

    @Test
    public void deduplicate() {

        List<Integer> expected = Arrays.asList(1,2,4,5);

        ListDeduplicator deduplicator = new ListDeduplicator();

        ListSorter listSorter = new ListSorter();
        List<Integer> distinct = deduplicator.deduplicate(list, listSorter);

        Assertions.assertEquals(expected, distinct);
    }

    @Test
    public void deduplicator_bug_8726() {
        list = Arrays.asList(1, 2, 4, 2);

        List<Integer> expected = Arrays.asList(1,2,4);

        class StubListSorter implements GenericListSorter {
            public List<Integer> sort(List<Integer> list) {
                return Arrays.asList(1, 2, 2, 4);
            }
        }

        ListDeduplicator deduplicator = new ListDeduplicator();

        StubListSorter listSorter = new StubListSorter();

        List<Integer> distinct = deduplicator.deduplicate(list, listSorter);

        Assertions.assertEquals(expected, distinct);


    }

}
