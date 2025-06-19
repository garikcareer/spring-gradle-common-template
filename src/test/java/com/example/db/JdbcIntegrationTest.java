package com.example.db;

import com.example.config.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class JdbcIntegrationTest {

    @Autowired
    private JdbcTemplate jdbc;

    @BeforeEach
    void setup() {
        jdbc.execute("DROP TABLE IF EXISTS users");
        jdbc.execute("""
            CREATE TABLE users (
                id INT PRIMARY KEY,
                name VARCHAR(50)
            )
        """);
    }

    @Test
    void insertAndQueryUser() {
        jdbc.update("INSERT INTO users (id, name) VALUES (?, ?)", 1, "Alice");
        String name = jdbc.query("SELECT name FROM users WHERE id = 1",
                (resultSet, rowNum) -> resultSet.getString("name")).getFirst();
        assertEquals("Alice", name);
    }

    @Test
    void insertMultipleAndListAll() {
        jdbc.update("INSERT INTO users (id, name) VALUES (?, ?)", 1, "Alice");
        jdbc.update("INSERT INTO users (id, name) VALUES (?, ?)", 2, "Bob");

        List<String> names = jdbc.query("SELECT name FROM users",
                (rs, rowNum) -> rs.getString("name"));

        assertEquals(2, names.size());
        assertTrue(names.contains("Alice"));
        assertTrue(names.contains("Bob"));
    }

    @Test
    void deleteUserAndVerify() {
        jdbc.update("INSERT INTO users (id, name) VALUES (?, ?)", 1, "Alice");
        int deleted = jdbc.update("DELETE FROM users WHERE id = ?", 1);

        assertEquals(1, deleted);

        Integer count = jdbc.queryForObject("SELECT COUNT(*) FROM users", Integer.class);
        assertEquals(0, count);
    }

    @Test
    void tableShouldBeEmptyInitially() {
        Integer count = jdbc.queryForObject("SELECT COUNT(*) FROM users", Integer.class);
        assertEquals(0, count);
    }
}