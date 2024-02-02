package ru.shirkov.config;

import com.zaxxer.hikari.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
@Component
public class ConnectionPool {

    private HikariDataSource dataSource;


    public ConnectionPool(
            @Value("${spring.datasource.driver}")
            String dbDriver,
            @Value("${spring.datasource.url}")
            String dbUrl,
            @Value("${spring.datasource.user}")
            String dbUser,
            @Value("${spring.datasource.password}")
            String dbPassword
    ) {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(dbDriver);
        config.setJdbcUrl(dbUrl);
        config.setUsername(dbUser);
        config.setPassword(dbPassword);

        dataSource = new HikariDataSource(config);

    }


    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
