package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter{
    int integer;

    public DivisibleByFilter(int integer) {
        this.integer = integer;
    }
    @Override
    public boolean accept(Integer number) {
        if (number % integer == 0) {
            return true;
        }
        return false;
    }
}
