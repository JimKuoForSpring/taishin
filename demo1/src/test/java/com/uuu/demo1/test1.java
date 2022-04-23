package com.uuu.demo1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Test1 {
    @BeforeEach
    public void prepareData() {
        System.out.println("prepare some data..");
    }
    @AfterEach
    public void recordData() {
        System.out.println("record test result data..");
    }
    @Test
    public void doTestA() {
        System.out.println("do testA");
    }

    @Test
    public void doTestB() {
        System.out.println("do testB");
    }
}
