package com.busanit501.helloworld.jdbcex.controller;


import com.busanit501.helloworld.jdbcex.service.FoodService;
import com.busanit501.helloworld.jdbcex.dto.FoodDTO_jdbcex;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "FoodRead2Controller",urlPatterns = "/food/read2")
public class FoodRead2Controller extends HttpServlet {
    private FoodService foodService = FoodService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int foodId = Integer.parseInt(req.getParameter("foodId"));
        FoodDTO_jdbcex foodDTO_jdbcex = null;
        try {
            foodDTO_jdbcex = foodService.selectOneFood(foodId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("dto", foodDTO_jdbcex);
        req.getRequestDispatcher("/WEB-INF/food/foodRead2.jsp").forward(req, resp);
    }
}
