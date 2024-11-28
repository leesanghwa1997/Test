package com.busanit501.helloworld.jdbcex.controller;

import com.busanit501.helloworld.jdbcex.dto.FoodDTO_jdbcex;
import com.busanit501.helloworld.jdbcex.dto.TodoDTO;
import com.busanit501.helloworld.jdbcex.service.FoodService;
import com.busanit501.helloworld.jdbcex.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "FoodUpdateController",urlPatterns = "/food/update")
public class FoodUpdateController extends HttpServlet {
    private FoodService foodService = FoodService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int foodId = Integer.parseInt(req.getParameter("foodId"));
            FoodDTO_jdbcex foodDTO_jdbcex = foodService.selectOneFood(foodId);
            req.setAttribute("dto", foodDTO_jdbcex);
            req.getRequestDispatcher("/WEB-INF/food/foodUpd.jsp")
                    .forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int foodId = Integer.parseInt(req.getParameter("foodId")); // foodId 가져오기
        FoodDTO_jdbcex foodDTO_jdbcex = FoodDTO_jdbcex.builder()
                .foodId(foodId) // foodId 설정
                .foodName(req.getParameter("foodName"))
                .foodDescription(req.getParameter("foodDescription"))
                .foodPrice(Integer.parseInt(req.getParameter("foodPrice")))
                .build();
        try {
            foodService.updateFood(foodDTO_jdbcex);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("/food/list2");
    }

}