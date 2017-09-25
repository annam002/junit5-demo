package com.anna.junit5.inheritance;

import org.junit.jupiter.api.BeforeEach;

class ChildClass extends BaseClass {

    @BeforeEach
    void beforeEachChild() {
        System.out.println("@BeforeEach in child class");
    }

    @Override
    public int getANumberSmallerZero() {
        return -1;
    }

    @Override
    int getANumberBiggerZero() {
        return 1;
    }
}
