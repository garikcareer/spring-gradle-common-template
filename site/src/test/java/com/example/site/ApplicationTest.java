package com.example.site;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationTest {
  @Test
  void springContextStarts() {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.scan("com.example");
    context.refresh();
    context.close();
  }
}
