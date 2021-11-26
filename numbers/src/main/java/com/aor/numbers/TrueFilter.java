package com.aor.numbers;

public class TrueFilter implements GenericListFilter {
    @Override
    public boolean accept(Integer number) {
        return true;
    }
}
