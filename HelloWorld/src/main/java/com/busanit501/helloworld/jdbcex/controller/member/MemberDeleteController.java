package com.busanit501.helloworld.jdbcex.controller.member;

import com.busanit501.helloworld.jdbcex.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Log4j2
@WebServlet(name="MemberDeleteController",urlPatterns = "/member/delete")
public class MemberDeleteController extends HttpServlet {

    private MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            memberService.delete(Integer.parseInt(req.getParameter("member_num")));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("/member/list");
    }
}
