package com.uuu.labs.springboot.demo4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyRunner2 implements CommandLineRunner {
    @Autowired
    NamedParameterJdbcTemplate template;
    private static final String SQL1 = "SELECT :a + :b - :c * :d";

    @Override
    public void run(String... args) throws Exception {
        SqlParameterSource source = new MapSqlParameterSource()
                .addValue("a", 100)
                .addValue("b", 200)
                .addValue("c", 300)
                .addValue("d", 4);
        Integer result = template.queryForObject(SQL1, source, Integer.class);
        log.info("calculate from SQL:{}, result:{}", SQL1, result);
    }
}
