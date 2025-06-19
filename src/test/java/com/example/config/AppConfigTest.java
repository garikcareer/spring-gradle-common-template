package com.example.config;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AppConfigTest {

    @Test
    void contextLoads() {
        try (var context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            assertNotNull(context);
        }
    }
}