package com.busanit501.helloworld.jdbcex.controller;

import com.busanit501.helloworld.jdbcex.dto.T_MemberDTO;
import com.busanit501.helloworld.jdbcex.service.T_MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@Log4j2
@WebServlet(name = "LoginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("LoginController doGet ");
        request.getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
    }

    // 로직 처리,
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("LoginController doPost ");
        String mid = request.getParameter("mid");
        String mpw = request.getParameter("mpw");

        // 디비에가서, 해당 유저가 있으면, 임시로 세션에 저장,
        // 예외처리도 없음.
        // 조금있다 할 예정.
        // 임의로 세션 동작 여부만 확인중.

        try {
            T_MemberDTO t_memberDTO = T_MemberService.INSTANCE.login(mid, mpw);
            // 세션에, 위의 로그인 정보를 저장,
            HttpSession session = request.getSession();
            session.setAttribute("loginInfo", t_memberDTO);
            response.sendRedirect("/todo/list2");
        } catch (SQLException e) {
            response.sendRedirect("/login?result=error");
        }
    }
}
