package com.busanit501.helloworld.jdbcex.controller.member;

import com.busanit501.helloworld.jdbcex.dto.MemberDTO;
import com.busanit501.helloworld.jdbcex.dto.TodoDTO;
import com.busanit501.helloworld.jdbcex.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Log4j2
@WebServlet(name="MemberUpdateController",urlPatterns = "/member/update")
public class MemberUpdateController extends HttpServlet {
    private MemberService memberService = MemberService.INSTANCE;
    private final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        try {
            int member_num = Integer.parseInt(req.getParameter("member_num"));
            MemberDTO memberDTO = memberService.selectOne(member_num);
            req.setAttribute("dto", memberDTO);
            req.getRequestDispatcher("/WEB-INF/member/memberUpdate.jsp")
                    .forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberDTO memberDTO = MemberDTO.builder()
                .member_num(Integer.parseInt(req.getParameter("member_num")))
                .member_name(req.getParameter("member_name"))
                .member_id(req.getParameter("member_id"))
                .member_password(req.getParameter("member_password"))
                .build();
        log.info("memberDTO 수정된 내용: " + memberDTO);
        try {
            memberService.update(memberDTO);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("/member/list");
    }
}
