package com.busanit501.helloworld.jdbcex;

import com.busanit501.helloworld.jdbcex.dao.FoodDAO;
import com.busanit501.helloworld.jdbcex.vo.FoodVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class FoodDAOTest {
    private FoodDAO foodDAO;

    @BeforeEach
    public void setup() {
        foodDAO = new FoodDAO();
    }

    @Test
    public void insertFood() throws SQLException {
        FoodVO foodVO = FoodVO.builder()
                .foodName("음식테스트1")
                .foodDescription("음식설명(테스트)")
                .foodPrice(123456)
                .build();
        foodDAO.insertFood(foodVO);
        System.out.println("Food inserted successfully.");
    }

    @Test
    public void updateFood() throws SQLException {

    }
}
