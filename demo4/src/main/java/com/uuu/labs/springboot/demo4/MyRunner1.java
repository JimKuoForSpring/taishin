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
public class MyRunner1 implements CommandLineRunner {
    NamedParameterJdbcTemplate template;
    private static final String SQL1 = "SELECT 888";

    public MyRunner1(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("got a jdbc template:{}", template.getJdbcTemplate().getDataSource().toString());
        SqlParameterSource source = new MapSqlParameterSource();
        Integer result = template.queryForObject(SQL1, source, Integer.class);
        log.info("SQL ==>{}, return ==>{}", SQL1, result);
    }
}
