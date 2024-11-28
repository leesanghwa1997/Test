package com.busanit501.helloworld.jdbcex.controller.member;

import com.busanit501.helloworld.jdbcex.dto.MemberDTO;
import com.busanit501.helloworld.jdbcex.service.MemberService;
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
@WebServlet(name="MemberInfoController",urlPatterns = "/member/info")
public class MemberInfoController extends HttpServlet {
    private MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int member_num = Integer.parseInt(req.getParameter("member_num"));
        MemberDTO memberDTO = null;
        try {
            memberDTO = memberService.selectOne(member_num);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("dto", memberDTO);
        req.getRequestDispatcher("/WEB-INF/member/memberInfo.jsp").forward(req, resp);
    }
}
