package ru.shirkov.repositore;

import org.springframework.beans.factory.annotation.Value;

public class ConnectionPool {
    public ConnectionPool(
            @Value("jdbc:mysql://localhost:3306")
            String dbUrl,
            @Value("root")
            String dbUser,
            @Value("123456789")
            String dbPassword
    ) {

    }

}
