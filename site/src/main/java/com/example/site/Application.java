package com.example.site;

import com.example.site.config.ApplicationConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class Application implements WebMvcConfigurer {
  private static final Logger logger = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) throws LifecycleException {
    String webappDir = "src/main/webapp/";

    Tomcat tomcat = new Tomcat();
    tomcat.setPort(8080);
    tomcat.getHost().setAppBase(".");
    tomcat.addWebapp("", new File(webappDir).getAbsolutePath());

    tomcat.getConnector();
    tomcat.start();
    logger.info("Server started on port 8080");
    tomcat.getServer().await();
  }

  @Bean
  public InternalResourceViewResolver viewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/WEB-INF/views/");
    viewResolver.setSuffix(".html");
    return viewResolver;
  }
}
