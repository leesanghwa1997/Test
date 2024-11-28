package com.busanit501.helloworld.jdbcex.controller.member;

import com.busanit501.helloworld.jdbcex.dto.MemberDTO;
import com.busanit501.helloworld.jdbcex.service.MemberService;
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
@WebServlet(name = "MemberLoginController", urlPatterns = "/memberLogin")
public class MemberLoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("LoginController doGet ");
        req.getRequestDispatcher("/WEB-INF/member/memberLogin.jsp")
                .forward(req, resp);
    }

    // 로직 처리,
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("LoginController doPost ");
        String member_id = req.getParameter("member_id");
        String member_password = req.getParameter("member_password");

        // 디비에가서, 해당 유저가 있으면, 임시로 세션에 저장,
        // 예외처리도 없음.
        // 조금있다 할 예정.
        // 임의로 세션 동작 여부만 확인중.

        try {
            MemberDTO memberDTO = MemberService.INSTANCE.login(member_id, member_password);
            // 세션에, 위의 로그인 정보를 저장,
            HttpSession session = req.getSession();
            session.setAttribute("loginInfo", memberDTO);
            resp.sendRedirect("/member/list");
        } catch (SQLException e) {
            resp.sendRedirect("/memberLogin?result=error");
        }
    }
}
