package com.aor.numbers

import spock.lang.Specification

class FirstSpecification extends Specification {
    def "one plus one should equal two"() {
        expect:
        1 + 1 == 2
    }

    def "two plus two should equal four"() {
        given:
        int left = 2
        int right = 2
        when:
        int result = left + right
        then:
        result == 4
    }

    def "removing element from list with right index"() {
        given:
        def list = [1, 2, 3, 4]
        when:
        list.remove(0)
        then:
        list == [2, 3, 4]
    }

    def "removing element from list with wrong index"() {
        setup:
        def list = [1, 2, 3, 4]
        when:
        list.remove(20)
        then:
        list.size() == 4
        thrown(IndexOutOfBoundsException)
    }

    def "numbers to the power of two"(int a, int b, int c) {
        expect:
        Math.pow(a, b) == c

        where:
        a | b | c
        1 | 2 | 1
        2 | 2 | 4
        4 | 2 | 16
        6 | 2 | 36

    }
    def "distinct bug #8726"() {
        given:
        def listSorter = Mock(GenericListSorter)
        def deduplicator = Mock(GenericListDeduplicator)
        deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2), listSorter) >> Arrays.asList(1, 2, 4)

        when:
        def result = deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2), listSorter)
        then:
        result == Arrays.asList(1, 2, 4)

    }
}
