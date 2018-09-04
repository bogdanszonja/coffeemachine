package com.codecool.coffee.sql;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class SQLConnectionTest {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost/" + System.getenv("db_test_name");
    private static final String USER = System.getenv("db_user");
    private static final String PASS = System.getenv("db_password");

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void close() {

    }

    @Test
    void addNewOrder() {
    }

    @Test
    void getAllOrders() {
    }

    @Test
    void markOrderAsCompleted() {
    }

    @Test
    void markOrderAsCompleted1() {
    }

    @Test
    void getPriorityOrder() {
    }
}