package com.example.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class AppConfigTest {
  Logger logger = org.slf4j.LoggerFactory.getLogger(AppConfigTest.class);

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
