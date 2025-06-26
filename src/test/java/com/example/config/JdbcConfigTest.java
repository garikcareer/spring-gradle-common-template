package com.example.config;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@TestPropertySource("classpath:db-local.properties")
@ContextConfiguration(classes = JdbcConfig.class)
public class JdbcConfigTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    @Test
    void jdbcTemplateIsAutowired() {
        assertNotNull(jdbcTemplate);
    }

    @Test
    void dataSourceIsAutowired() {
        assertNotNull(jdbcTemplate);
    }

    @Test
    void dataSourceConnects() throws Exception {
        try (var conn = dataSource.getConnection()) {
            assertNotNull(conn);
        }
    }
}