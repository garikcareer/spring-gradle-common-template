package com.example.site;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ApplicationTest {
  @Test
  void applicationStarts() {
    Application application = new Application();
    assertNotNull(application, " application should not be null");
  }
}
