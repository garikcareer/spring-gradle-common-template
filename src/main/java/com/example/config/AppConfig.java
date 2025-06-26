package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Main application configuration class that serves as the primary configuration source for the
 * Spring application context.
 *
 * @author Garik Arutyunyan
 * @version 1.0
 * @since 1.0
 * @see JdbcConfig
 */
@Configuration
@ComponentScan(basePackages = "com.example")
@Import(JdbcConfig.class)
public class AppConfig {
  /**
   * Default constructor for AppConfig. Creates a new instance of the application configuration.
   * This constructor is automatically called by Spring when initializing the application context.
   */
  AppConfig() {}
}
