package com.uuu.labs.springboot.demo4;

import com.uuu.labs.springboot.demo4.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyRunner4 implements CommandLineRunner {
    @Autowired
    NamedParameterJdbcTemplate template;
    private static final String SQL1 = "SELECT id, username, email FROM USERS2 WHERE id = :id";

    @Override
    public void run(String... args) throws Exception {
        SqlParameterSource source = new MapSqlParameterSource().addValue("id", 1);
        User user = template.queryForObject(SQL1, source, (rs, rowNum) -> new User(rs.getString("username"),
                rs.getString("email")));
        log.info("user name={}/email=email={}", user.getUsername(), user.getEmail());
    }
}
