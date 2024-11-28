package com.busanit501.helloworld.jdbcex;

import com.busanit501.helloworld.jdbcex.dto.FoodDTO_jdbcex;
import com.busanit501.helloworld.jdbcex.dto.MemberDTO;
import com.busanit501.helloworld.jdbcex.dto.TodoDTO;
import com.busanit501.helloworld.jdbcex.service.MemberService;
import com.busanit501.helloworld.jdbcex.service.TodoService;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

@Log4j2
public class MemberServiceTest {
    private MemberService memberService;

    @BeforeEach
    public void ready() {
        memberService = MemberService.INSTANCE;
    }

    @Test
    public void testSelectOne() throws SQLException {
        val memberDTO = memberService.selectOne(2);
        log.info("하나 조회. memberDTO " + memberDTO);
    }

    @Test
    public void testSelectAll() throws SQLException {
        List<MemberDTO> dtoList = memberService.selectAll();
        for (MemberDTO memberDTO:dtoList) {
            log.info(memberDTO);
        }
    }

    @Test
    public void testUpdate() throws SQLException {
        MemberDTO memberDTO = MemberDTO.builder()
                .member_num(1)
                .member_name("수정 테스트")
                .member_id("수정 테스트")
                .member_password("수정 테스트")
                .build();

        memberService.update(memberDTO);
    }

}
