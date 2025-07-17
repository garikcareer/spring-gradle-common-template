package com.example.site;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppTest {
  @Test
  void appStarts() {
    App app = new App();
    assertNotNull(app, "app should not be null");
  }
}
