package com.uuu.demo1;

import org.junit.jupiter.api.*;

public class Test6 {
    @BeforeAll
    public static void seutpEnvironment() {
        System.out.println("start up once");
    }

    @AfterAll
    public static void finalCleanup() {
        System.out.println("one term cleanup");
    }

    @BeforeEach
    public void prepareTestCase() {
        System.out.println("should prepare env here");
    }

    @AfterEach
    public void storeTestREsult() {
        System.out.println("should store test result");
    }

    @Test
    public void test1() {
        System.out.println("test1 begin...");
    }

    @Test
    public void test2() {
        System.out.println("test2 begin");
    }
}
