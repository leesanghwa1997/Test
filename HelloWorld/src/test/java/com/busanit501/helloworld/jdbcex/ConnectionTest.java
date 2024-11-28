package com.busanit501.helloworld.jdbcex;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class ConnectionTest {

    @Test
    public void testConnection() throws Exception {
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

        HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
        Connection connection = hikariDataSource.getConnection();

        System.out.println(connection); // 연결 확인 출력
        connection.close();
    }
}
