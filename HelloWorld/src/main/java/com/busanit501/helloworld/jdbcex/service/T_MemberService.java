package com.busanit501.helloworld.jdbcex.service;

import com.busanit501.helloworld.jdbcex.dao.T_MemberDAO;
import com.busanit501.helloworld.jdbcex.dto.T_MemberDTO;
import com.busanit501.helloworld.jdbcex.util.MapperUtil;
import com.busanit501.helloworld.jdbcex.vo.T_MemberVO;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;

@Log4j2
public enum T_MemberService {
    INSTANCE;

    private T_MemberDAO t_memberDAO;
    private ModelMapper modelMapper;

    // 생성자 이용해서, 초기화하기.
    T_MemberService() {
        t_memberDAO = new T_MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public T_MemberDTO login(String mid, String mpw) throws SQLException {
        T_MemberVO t_memberVO = t_memberDAO.getMemberWithMpw(mid,mpw);
        T_MemberDTO t_memberDTO = modelMapper.map(t_memberVO, T_MemberDTO.class);
        return t_memberDTO;
    }
}
