package com.example.config;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DataSourceConfigTest {

    @Test
    void testCreateInMemoryH2DataSource() throws Exception {
        javax.sql.DataSource ds = DataSourceConfig.createInMemoryH2DataSource();
        try (Connection conn = ds.getConnection()) {
            assertNotNull(conn);
        }
    }
}