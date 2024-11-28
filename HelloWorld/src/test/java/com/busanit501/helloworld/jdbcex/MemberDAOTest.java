package com.busanit501.helloworld.jdbcex;

import com.busanit501.helloworld.jdbcex.dao.MemberDAO;
import com.busanit501.helloworld.jdbcex.dao.TodoDAO;
import com.busanit501.helloworld.jdbcex.vo.MemberVO;
import com.busanit501.helloworld.jdbcex.vo.TodoVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class MemberDAOTest {
    private MemberDAO memberDAO;

    // 아래에 각 단위 테스트가 실행되기전에, 먼저 실행을 함.
    @BeforeEach
    public void ready() {
        memberDAO = new MemberDAO();
    }

    @Test
    public void getTime() {
        System.out.println("sql 전달 후, 시간 조회 확인용: " + memberDAO.getTime());
    }

    @Test
    public void getTime2() throws SQLException {
        System.out.println("sql 전달 후, " +
                "시간 조회 확인용: 자동 반납 @Cleanup 확인 " + memberDAO.getTime2());
    }

    @Test
    public void testselectAll() throws SQLException {
        List<MemberVO> list = memberDAO.selectAllMember();
        list.forEach(vo -> System.out.println(vo));
    }

    @Test
    public void testselectOne() throws SQLException {
        int member_num = 1;
        MemberVO memberVO = memberDAO.selectOneMember(member_num);
        System.out.println(memberVO);
    }

    @Test
    public void insetTest() throws Exception {
        MemberVO memberVO1 = MemberVO.builder()
                .member_name("이상화123")
                .member_id("lsh1234")
                .member_password("123")
                .build();

        memberDAO.insertMember(memberVO1);
    }

    @Test
    public void updateTestMember() throws SQLException {
        MemberVO memberVO = MemberVO.builder()
                .member_num(2)
                .member_name("수정")
                .member_id("수정")
                .member_password("수정")
                .created_at(LocalDate.of(2024, 11, 25))
                .build();

        memberDAO.updateMember(memberVO);

    }

    @Test
    public void deleteTestMember() throws SQLException {
        int member_num = 2;
        memberDAO.deleteMember(member_num);
    }
}
