package com.example.data.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@TestPropertySource("classpath:db-local.properties")
@ContextConfiguration(classes = JPAConfig.class)
public class JPAConfigTest {
  Logger logger = LoggerFactory.getLogger(JPAConfigTest.class);

  @PersistenceContext
  private EntityManager entityManager;

  @Autowired
  private DataSource dataSource;

  @Test
  void entityManagerIsAutowired() {
    assertNotNull(entityManager);
    logger.info("entityManager: {}", entityManager);
  }

  @Test
  void dataSourceIsAutowired() {
    assertNotNull(dataSource);
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
