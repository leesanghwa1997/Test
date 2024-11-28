package com.busanit501.helloworld.jdbcex;

import com.busanit501.helloworld.jdbcex.dto.T_MemberDTO;
import com.busanit501.helloworld.jdbcex.service.T_MemberService;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Log4j2
public class T_MemberServiceTest {
    private T_MemberService t_memberService;

    @BeforeEach
    public void ready() {
        t_memberService = T_MemberService.INSTANCE;
    }

    // 등록
    @Test
    public void loginTest() throws SQLException {
        T_MemberDTO memberDTO = t_memberService.login("lsy", "1234");
        log.info("MemberService loginTest : " + memberDTO.toString());
    }


}
