package com.example.demo2.demo2.configuration;

import com.example.demo2.demo2.Calculator;
import com.example.demo2.demo2.bean.AddCalculator;
import com.example.demo2.demo2.bean.MulCalculator;
import com.example.demo2.demo2.bean.SubCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name="add")
    Calculator bean1() {
        return new AddCalculator();
    }
    @Bean(name="sub")
    Calculator bean2() {
        return new SubCalculator();
    }
    @Bean(name="mul")
    Calculator bean3() {
        return new MulCalculator();
    }
}
