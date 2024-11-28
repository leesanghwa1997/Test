package com.busanit501.helloworld.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectTest {
    @Test
    public void test() {
        int v1 = 100;
        int v2 = 100;
        Assertions.assertEquals(v1, v2);
    }

    @Test
    public void test2() throws ClassNotFoundException, SQLException {
        //마리아 디비 드라이버, 메모리상에 로드,
        Class.forName("org.mariadb.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/webdb","webuser","webuser");

        Assertions.assertNotNull(con);

        con.close();
    }
}
