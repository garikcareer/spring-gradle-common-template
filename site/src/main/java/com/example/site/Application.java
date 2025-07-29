package com.example.site;

import com.example.site.config.ApplicationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

/**
 * The Application class serves as the entry point of the application. It initializes the application and
 * logs its start-up process.
 */
public class Application {
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
    int port = 8080;

    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
    context.register(ApplicationConfig.class);
    context.refresh();
    logger.info("Spring context refreshed");

//    Tomcat tomcat = new Tomcat();
//    tomcat.setPort(port);
//
//    // Create base directory
//    File base = new File(System.getProperty("java.io.tmpdir"));
//    tomcat.setBaseDir(base.getAbsolutePath());
//
//    var ctx = tomcat.addContext("", base.getAbsolutePath());
//
//    Tomcat.addServlet(ctx, "dispatcher", new DispatcherServlet(context));
//    ctx.addServletMappingDecoded("/", "dispatcher");
//
//    tomcat.start();
//    logger.info("Tomcat started at http://localhost:{}", port);
//    tomcat.getServer().await();
  }
}
