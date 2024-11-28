package com.busanit501.helloworld.jdbcex.filter;

import com.busanit501.helloworld.jdbcex.dto.MemberDTO;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/member/*"})
@Log4j2
public class MemberLoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("doFilter ,/member/* 하위로 들어오는 모든 url 에 대해서 로그인 체크함");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        // 세션 정보를 호출 및 가져오기.
        HttpSession session = req.getSession();

        // 만약에, 서버에서 최초로 접근했다면,
        // 서버에서, JSESSIONID 발급을 해준다.
        if(session.isNew()) {
            log.info("최초로 서버에 요청을함.");
            // 로그인 컨트롤러가 아직 없음, 곧 만들 예정.
            resp.sendRedirect("/memberLogin");
            return;
        }
        // 2번째 이후의 방문, 하지만, 세션이라는 저장공간,
        // 여기에 키 : loginInfo , 값: 로그인한 유저의 아이디를 기록.
        if(session.getAttribute("loginInfo") == null) {
            log.info("2번째 이후로 서버에 요청을했고, 하지만, 로그인 정보는 없는 경우.");
            resp.sendRedirect("/memberLogin");
            return;
        }
        //임시로, 최초도 아니고, 로그인 처리가 되었다면, 그러면,
        // 정상적으로 접근하는 페이지로 이동 시켜 줄게.
        if(session.getAttribute("loginInfo") != null) {
            // 앞에서 임시로 테스트 할 때, mid+mpw 붙여서 확인.
//            String result  = (String) session.getAttribute("loginInfo");
            MemberDTO memberDTO  = (MemberDTO) session.getAttribute("loginInfo");
            log.info("session.getAttribute(\"loginInfo\") memberDTO : " + memberDTO);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
