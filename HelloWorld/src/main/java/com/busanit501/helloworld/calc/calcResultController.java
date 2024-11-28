package com.busanit501.helloworld.calc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="calcResultController" ,urlPatterns = "/calc/result")
public class calcResultController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");

        System.out.println("num1: "+ num1 + " num2: " + num2);
        
//        결과 화면을다른 뷰로 전달하기
        response.setContentType("/calc/input");
    }
}
