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

@WebServlet(name="FoodReg2Controller", urlPatterns = "/food/register2")
public class FoodReg2Controller extends HttpServlet {
    private FoodService foodService = FoodService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //화면 전달.
        request.getRequestDispatcher("/WEB-INF/food/foodReg2.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String foodName = request.getParameter("food_name");
        String foodDescription = request.getParameter("food_description");
        String foodPriceStr = request.getParameter("food_price");

        int foodPrice = 0;
        try {
            foodPrice = Integer.parseInt(foodPriceStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        FoodDTO_jdbcex foodDTO_jdbcex = FoodDTO_jdbcex.builder()
                .foodName(foodName)
                .foodDescription(foodDescription)
                .foodPrice(foodPrice)
                .build();

        try {
            foodService.register(foodDTO_jdbcex);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("doPost : 글쓰기 처리하는 로직, 디비 연결 전, 리스트로 이동함");
        response.sendRedirect("/food/list2");
    }

}
