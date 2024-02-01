package ru.shirkov.repositore;

import com.zaxxer.hikari.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
@Component

public class ConnectionPool {
    private HikariConfig config = new HikariConfig();
    private HikariDataSource dataSource;

    public ConnectionPool(
            @Value("jdbc:mysql://localhost:3306")
            String dbUrl,
            @Value("root")
            String dbUser,
            @Value("123456789")
            String dbPassword
    ) {

        config.setJdbcUrl(dbUrl);
        config.setUsername(dbUser);
        config.setPassword(dbPassword);

        dataSource = new HikariDataSource(config);

    }


    public Connection getConnection() {
        try (Connection connection = dataSource.getConnection()) {
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
