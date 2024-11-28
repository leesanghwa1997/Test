package com.busanit501.helloworld.jdbcex;

import com.busanit501.helloworld.jdbcex.dao.T_MemberDAO;
import com.busanit501.helloworld.jdbcex.vo.T_MemberVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class T_MemberDAOTest {
    private T_MemberDAO t_memberDAO;

    // 아래에 각 단위 테스트가 실행되기전에, 먼저 실행을 함.
    @BeforeEach
    public void ready() {
        t_memberDAO = new T_MemberDAO();
    }

    @Test
    public void getMemberWithMpwTest() throws SQLException {
        String mid = "lsy";
        String mpw = "1234";
        T_MemberVO t_memberVO = t_memberDAO.getMemberWithMpw(mid,mpw);
    }

}
