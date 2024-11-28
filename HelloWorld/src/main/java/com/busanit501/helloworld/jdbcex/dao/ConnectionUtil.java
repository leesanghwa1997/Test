package com.busanit501.helloworld.jdbcex.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public enum ConnectionUtil {
    INSTANCE;
    private HikariDataSource ds;
    private ConnectionUtil() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("org.mariadb.jdbc.Driver");
        hikariConfig.setJdbcUrl("jdbc:mariadb://localhost:3306/webdb");
        hikariConfig.setUsername("webuser");
        hikariConfig.setPassword("webuser");

        // 캐시 기능을 이용하여 메모리에 임시 저장 후 꺼내 사용
        // prepStmtCacheSize: 준비된 문장을 캐싱할 최대 개수 (250)
        // prepStmtCacheSqlLimit: 캐싱 가능한 SQL 문장의 최대 길이 (2048)
        hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        ds = new HikariDataSource(hikariConfig);
    }

    public Connection getConnection() throws SQLException {
        return  ds.getConnection();
    }
}
