package com.busanit501.helloworld.jdbcex.controller;

import com.busanit501.helloworld.jdbcex.dto.FoodDTO_jdbcex;
import com.busanit501.helloworld.jdbcex.service.FoodService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Log4j2
@WebServlet(name="FoodList2Controller",urlPatterns = "/food/list2")
public class FoodList2Controller extends HttpServlet {
    private FoodService foodService = FoodService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //DB의 음식데이터를 들고온다.
            List<FoodDTO_jdbcex> foodDTOJdbcexList = foodService.selectAllFood();
            //가져온 데이터를 list에 저장한다
            req.setAttribute("list", foodDTOJdbcexList);
            //jsp에 전달
            req.getRequestDispatcher("/WEB-INF/food/foodList2.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
    }
}
}
