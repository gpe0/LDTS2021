package com.aor.numbers;

import jdk.internal.net.http.common.SSLTube;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {

    List<Integer> list;

    @BeforeEach
    public void helper() {
        list = Arrays.asList(1, 2, 4, 2, 5);
    }
    @Test
    public void sum() {

        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {

        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {

        class StubListDeduplicator implements GenericListDeduplicator{

            @Override
            public List<Integer> deduplicate(List<Integer> list, GenericListSorter listSorter) {
                return Arrays.asList(1, 2, 3, 4, 5);
            }
        }

        ListAggregator aggregator = new ListAggregator();
        StubListDeduplicator deduplicator = new StubListDeduplicator();
        int distinct = aggregator.distinct(list, deduplicator);

        Assertions.assertEquals(5, distinct);
    }


    @Test
    public void max_bug_7263() {
        list = Arrays.asList(-1, -4, -5);
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(-1, max);
    }

    @Test
    public void distinct_bug_8726() {

        //class StubListDeduplicator implements GenericListDeduplicator{

          //  @Override
          //  public List<Integer> deduplicate(List<Integer> list, GenericListSorter listSorter) {
           //     return Arrays.asList(1, 2, 4);
          //  }
        //}

        //StubListDeduplicator deduplicator = new StubListDeduplicator();

        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(Mockito.anyList(), Mockito.any())).thenReturn(Arrays.asList(1, 2, 4));

        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.distinct(Arrays.asList(1, 2, 4, 2), deduplicator);

        Assertions.assertEquals(3, distinct);

    }

    @Test
    public void max2() {
        list = Arrays.asList(2, 2);
        ListAggregator listAggregator = new ListAggregator();
        int max = listAggregator.max(list);

        Assertions.assertEquals(2, max);

    }

    @Test
    public void min2() {
        list = Arrays.asList(2, 2);
        ListAggregator listAggregator = new ListAggregator();
        int min = listAggregator.min(list);

        Assertions.assertEquals(2, min);

    }
}
