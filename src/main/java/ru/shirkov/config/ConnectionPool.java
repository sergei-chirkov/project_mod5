package ru.shirkov.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component

public class ConnectionPool {
//    private final HikariDataSource datasource;
//
//    public ConnectionPool(
//            @Value("${spring.datasource.url}")
//            String dbUrl,
//            @Value("${spring.datasource.user}")
//            String dbUser,
//            @Value("${spring.datasource.password}")
//            String dbPassword
//    ) {
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl(dbUrl);
//        config.setUsername(dbUser);
//        config.setPassword(dbPassword);
//
//        datasource =new HikariDataSource(config);
//    }
//    public Connection getConnection() throws SQLException {
//        return datasource.getConnection();
//    }

}
