package com.example.site;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ComponentScan("com.example")
class ApplicationTest {
  @Test
  void springContextStarts() {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.scan("com.example");
    context.refresh();
    context.close();
  }
}
