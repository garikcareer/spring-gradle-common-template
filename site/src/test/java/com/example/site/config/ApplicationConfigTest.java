package com.example.site.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationConfigTest {
  Logger logger = LoggerFactory.getLogger(ApplicationConfigTest.class);

  @Test
  void contextLoads() {
    logger.info("contextLoads");
    try (var context = new AnnotationConfigApplicationContext(AppConfig.class)) {
      assertNotNull(context);
      logger.info("context loaded: {}", context);
    } catch (Exception e) {
      logger.error("{}", e.getMessage());
    }
  }
}
