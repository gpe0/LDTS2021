package com.aor.numbers;

public class FalseFilter implements GenericListFilter{
    @Override
    public boolean accept(Integer number) {
        return false;
    }
}

