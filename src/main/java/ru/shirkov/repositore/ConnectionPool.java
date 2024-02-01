package ru.shirkov.repositore;

import com.zaxxer.hikari.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
@Component

public class ConnectionPool {

    private HikariDataSource dataSource;
//    public ConnectionPool(){
//        HikariConfig config = new HikariConfig();
//
//        config.setJdbcUrl("jdbc:mysql://localhost:3306/todo");
//        config.setUsername("root");
//        config.setPassword("123456789");
//
//        dataSource = new HikariDataSource(config);
//    }

    public ConnectionPool(
            @Value("${spring.datasource.url}")
            String dbUrl,
            @Value("${spring.datasource.user}")
            String dbUser,
            @Value("${spring.datasource.password}")
            String dbPassword
    ) {
        HikariConfig config = new HikariConfig();
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
