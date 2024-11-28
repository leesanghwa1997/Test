package com.busanit501.helloworld.calc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//서블릿 = 컨트롤러 역할.
//웹브라우저로 들어온 요청에대해서, 화면을 제공,데이터를 전달하는 중간 역할
@WebServlet(name="calcinputController",urlPatterns = "/calc/input")

public class calcinputController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet호출!");
        //요청을 받고, 화면으로 전달해주는 역할
        RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/calc/calc_input.jsp");
        dispatcher.forward(request,response);
    }
}
