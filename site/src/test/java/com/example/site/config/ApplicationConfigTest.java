package com.example.site.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfig.class)
@WebAppConfiguration
public class ApplicationConfigTest {
  @Autowired WebApplicationContext context;

  Logger logger = LoggerFactory.getLogger(ApplicationConfigTest.class);

  @Test
  void contextIsAutowired() {
    assertNotNull(context);
    logger.info("context: {}", context);
  }
}
