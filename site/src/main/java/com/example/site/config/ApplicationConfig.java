package com.example.site.config;

import com.example.data.config.JPAConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

/**
 * AppConfig is a configuration class for a Spring-based web application.
 *
 * <p>It is annotated with: - {@code @Configuration}: Indicates that the class contains
 * configuration information. - {@code @EnableWebMvc}: Enables Spring MVC features in the
 * application. - {@code @ComponentScan}: Specifies the base package(s) to scan for annotated
 * components. - {@code @Import}: Imports additional configuration classes, such as {@code
 * JdbcConfig}.
 *
 * <p>This class implements {@code WebMvcConfigurer} to provide additional configuration for the
 * Spring MVC setup.
 *
 * <p>The class defines several Spring beans: - {@code templateResolver}: Configures the template
 * resolver for Thymeleaf to handle HTML files. - {@code templateEngine}: Configures the template
 * engine for processing Thymeleaf templates. - {@code viewResolver}: Configures the view resolver
 * to render views using Thymeleaf.
 *
 * <p>Logging is enabled to track the creation of the beans for debugging purposes.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example")
@Import(JPAConfig.class)
public class ApplicationConfig implements WebMvcConfigurer {

  private static final Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);

  @Bean
  public SpringResourceTemplateResolver templateResolver() {
    SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".html");
    resolver.setCharacterEncoding("UTF-8");
    logger.info("templateResolver created");
    return resolver;
  }

  @Bean
  public SpringTemplateEngine templateEngine(SpringResourceTemplateResolver templateResolver) {
    SpringTemplateEngine engine = new SpringTemplateEngine();
    engine.setTemplateResolver(templateResolver);
    logger.info("templateEngine created");
    return engine;
  }

  @Bean
  public ThymeleafViewResolver viewResolver(SpringTemplateEngine templateEngine) {
    ThymeleafViewResolver resolver = new ThymeleafViewResolver();
    resolver.setTemplateEngine(templateEngine);
    resolver.setCharacterEncoding("UTF-8");
    logger.info("viewResolver created");
    return resolver;
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
            .addResourceHandler("/resources/**")
            .addResourceLocations("/resources/");
    logger.info("Resource handler configured");
  }
}
