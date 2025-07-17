package com.example.data.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JDBC Configuration class that provides database connectivity beans and related configurations.
 * This class is responsible for setting up the database connection and related JDBC components for
 * the application.
 *
 * @author Garik Arutyunyan
 * @version 1.0
 * @since 1.0
 */
@PropertySource("classpath:db-${env:local}.properties")
@Configuration
public class JdbcConfig {
  /** Default constructor for JdbcConfig. Initializes a new instance of the JDBC configuration. */
  JdbcConfig() {}

  /**
   * The name of the database driver class to be used for establishing a database connection.
   * Populated from the external property "db.driver" defined in the application properties file.
   * This property is mandatory for setting up the JDBC DataSource.
   */
  @Value("${db.driver}")
  private String driver;

  /**
   * The URL of the database to be used for establishing a connection. Retrieved from the external
   * property "db.url" defined in the application properties file. This property is essential for
   * configuring the DataSource to identify the database location.
   */
  @Value("${db.url}")
  private String url;

  /**
   * The username used to authenticate the connection to the database. This value is injected from
   * the external property "db.username" defined in the application properties file. It is a
   * required property for establishing database connections.
   */
  @Value("${db.username}")
  private String username;

  /**
   * The password used to authenticate the connection to the database. This value is injected from
   * the external property "db.password" defined in the application properties file. It is a
   * required property for establishing database connections.
   */
  @Value("${db.password}")
  private String password;

  /**
   * Configures and provides a DataSource bean for database connectivity. This method uses the
   * DriverManagerDataSource implementation and sets the driver class name, database URL, username,
   * and password from external properties such as db.driver, db.url, db.username, and db.password.
   *
   * @return a configured DataSource instance for database connectivity
   */
  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName(driver);
    ds.setUrl(url);
    ds.setUsername(username);
    ds.setPassword(password);
    return ds;
  }

  /**
   * Creates and provides a JdbcTemplate bean configured with the provided DataSource. JdbcTemplate
   * is used to simplify JDBC interactions by abstracting common boilerplate code such as connection
   * management and SQL operations.
   *
   * @param ds the DataSource to be used for database connectivity
   * @return a configured instance of JdbcTemplate
   */
  @Bean
  public JdbcTemplate jdbcTemplate(DataSource ds) {
    return new JdbcTemplate(ds);
  }

  /**
   * Configures and provides a DataSourceTransactionManager bean to enable declarative transaction
   * management in the application. The transaction manager is responsible for coordinating
   * transactions with the underlying database through the provided DataSource.
   *
   * @param ds the DataSource to be managed for transactional support
   * @return a configured instance of DataSourceTransactionManager
   */
  @Bean
  public DataSourceTransactionManager transactionManager(DataSource ds) {
    return new DataSourceTransactionManager(ds);
  }
}
