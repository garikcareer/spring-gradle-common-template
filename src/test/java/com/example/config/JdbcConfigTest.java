package com.example.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@TestPropertySource("classpath:db-local.properties")
@ContextConfiguration(classes = JdbcConfig.class)
public class JdbcConfigTest {
  Logger logger = LoggerFactory.getLogger(JdbcConfigTest.class);

  @Autowired private JdbcTemplate jdbcTemplate;

  @Autowired private DataSource dataSource;

  @Test
  void jdbcTemplateIsAutowired() {
    assertNotNull(jdbcTemplate);
    logger.info("jdbcTemplate: {}", jdbcTemplate);
  }

  @Test
  void dataSourceIsAutowired() {
    assertNotNull(jdbcTemplate);
    logger.info("dataSource: {}", dataSource);
  }

  @Test
  void dataSourceConnects() {
    logger.info("dataSource connecting");
    try (var conn = dataSource.getConnection()) {
      logger.info("dataSource connected: {}", conn);
      assertNotNull(conn);
    } catch (Exception e) {
      logger.error("{}", e.getMessage());
    }
  }
}
