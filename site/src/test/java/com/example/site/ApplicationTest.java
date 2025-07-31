package com.example.site;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ComponentScan("com.example")
class ApplicationTest {
  Logger logger = LoggerFactory.getLogger(ApplicationTest.class);

//  @Test
//  void springContextStarts() {
//    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//    context.scan("com.example");
//    context.refresh();
//    context.close();
//    logger.info("Spring context started");
//  }
}
