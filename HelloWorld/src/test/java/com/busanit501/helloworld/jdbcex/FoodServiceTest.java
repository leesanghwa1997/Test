package com.busanit501.helloworld.jdbcex;

import com.busanit501.helloworld.jdbcex.dto.FoodDTO_jdbcex;
import com.busanit501.helloworld.jdbcex.dto.TodoDTO;
import com.busanit501.helloworld.jdbcex.service.FoodService;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Log4j2
public class FoodServiceTest {
    private FoodService foodService;

    @BeforeEach
    public void ready() {
        foodService = FoodService.INSTANCE;
    }

    @Test
    public void testInsert() throws SQLException {
        // 더미 데이터, 화면에서 전달 받은 TodoDTO
         FoodDTO_jdbcex foodDTO_jdbcex = FoodDTO_jdbcex.builder()
                .foodName("테스트3")
                .foodDescription("테스트3 설명")
                 .foodPrice(3)
                .build();
        foodService.register(foodDTO_jdbcex);
    }

    @Test
    public void testSelectAllFood() throws SQLException {
        List<FoodDTO_jdbcex> foodDTO_jdbcexList = foodService.selectAllFood();
        for (FoodDTO_jdbcex foodDTO_jdbcex : foodDTO_jdbcexList) {
            log.info(foodDTO_jdbcex);
        }
    }

    @Test
    public void testSelectOneFood() throws SQLException {
        val foodinfo = foodService.selectOneFood(1);
        log.info("하나 조회. todoDTO " + foodinfo);
    }

    // 하나수정,
    @Test
    public void testUpdateOneFood() throws SQLException {
        FoodDTO_jdbcex foodDTO_jdbcex = FoodDTO_jdbcex.builder()
                .foodId(1)
                .foodName("수정된 음식이름")
                .foodDescription("수정된 음식설명")
                .foodPrice(99999)
                .build();

        foodService.updateFood(foodDTO_jdbcex);
    }

    // 하나삭제,
    @Test
    public void testDelteOneFood() throws SQLException {
        foodService.deleteFood(1);
    }
}
