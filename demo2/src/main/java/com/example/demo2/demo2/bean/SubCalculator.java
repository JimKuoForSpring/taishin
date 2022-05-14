package com.example.demo2.demo2.bean;

import com.example.demo2.demo2.Calculator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("sub")
public class SubCalculator implements Calculator {
    @Override
    public int calc(int a, int b) {
        return a - b;
    }
}
