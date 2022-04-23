package com.uuu.demo1;

import com.uuu.demo1.beans.User1;
import com.uuu.demo1.beans.User2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class Test7 {
    private static Validator validator;
    private static final Logger LOGGER = LoggerFactory.getLogger(Test7.class.getSimpleName());

    @BeforeAll
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void test1() {
        User1 u1 = new User1("John");
        Set<ConstraintViolation<User1>> violations = validator.validate(u1);
        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void test2() {
        User1 u1 = new User1("");
        Set<ConstraintViolation<User1>> violations = validator.validate(u1);
        assertThat(violations.size()).isEqualTo(0);

    }

    @Test
    public void test3() {
        User1 u1 = new User1(null);
        Set<ConstraintViolation<User1>> violations = validator.validate(u1);
        for (ConstraintViolation<User1> violation : violations) {
            //System.out.println(violation.getMessage());
            LOGGER.info(violation.getMessage());
        }
        assertThat(violations.size()).isEqualTo(1);

    }

}