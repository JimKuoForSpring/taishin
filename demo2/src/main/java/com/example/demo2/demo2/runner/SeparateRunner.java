package com.example.demo2.demo2.runner;

import com.example.demo2.demo2.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SeparateRunner implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(SeparateRunner.class.getName());
    @Autowired
    @Qualifier("add")
    private Calculator cal1;
    @Autowired
    @Qualifier("sub")
    private Calculator cal2;
    @Autowired
    @Qualifier("mul")
    private Calculator cal3;

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("execute somethings...");
        LOGGER.info("execute more things...");
        LOGGER.info("1. result={}", cal1.calc(3, 4));
        LOGGER.info("2. result={}", cal2.calc(3, 4));
        LOGGER.info("3. result={}", cal3.calc(3, 4));

    }
}
