package com.example.site;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Application class serves as the entry point of the application. It initializes the application and
 * logs its start-up process.
 */
public class Application {
  Logger logger = LoggerFactory.getLogger(Application.class);

  /**
   * Constructs a new instance of the App class. This constructor initializes the application and
   * prepares it for execution.
   */
  public Application() {}

  /**
   * The main method serves as the entry point of the application. It initializes the application
   * and logs the start-up process.
   *
   * @param args an array of command-line arguments passed to the application
   */
  public static void main(String[] args) {
    Logger logger = LoggerFactory.getLogger(Application.class);
    new Application();
    logger.info("App started");
  }
}
