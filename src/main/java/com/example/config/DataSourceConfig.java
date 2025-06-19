package com.example.config;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DataSourceConfig {

    public static javax.sql.DataSource createInMemoryH2DataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }
}