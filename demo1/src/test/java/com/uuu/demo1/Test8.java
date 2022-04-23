package com.uuu.demo1;

import com.uuu.demo1.beans.User1;
import com.uuu.demo1.beans.User2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class Test8 {
    private static Validator validator;
    //private static final Logger LOGGER = LoggerFactory.getLogger(Test8.class.getSimpleName());

    @BeforeAll
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void test1() {
        User2 u1 = new User2("John");
        Set<ConstraintViolation<User2>> violations = validator.validate(u1);
        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void test2() {
        User2 u1 = new User2("");
        Set<ConstraintViolation<User2>> violations = validator.validate(u1);
        for (ConstraintViolation<User2> violation : violations) {
            log.info("user={},violation message={}", u1, violation.getMessage());
        }
        assertThat(violations.size()).isEqualTo(1);

    }

    @Test
    public void test3() {
        User2 u1 = new User2(null);
        Set<ConstraintViolation<User2>> violations = validator.validate(u1);
        for (ConstraintViolation<User2> violation : violations) {
            //System.out.println(violation.getMessage());
            log.info(violation.getMessage());
        }
        assertThat(violations.size()).isEqualTo(1);

    }

}
