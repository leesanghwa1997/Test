package com.busanit501.helloworld.jdbcex.service;

import com.busanit501.helloworld.jdbcex.dao.MemberDAO;
import com.busanit501.helloworld.jdbcex.dto.MemberDTO;
import com.busanit501.helloworld.jdbcex.util.MapperUtil;
import com.busanit501.helloworld.jdbcex.vo.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum MemberService {
    INSTANCE;

    private MemberDAO memberDAO;
    private ModelMapper modelMapper;

    MemberService() {
        memberDAO = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public void register(MemberDTO memberDTO) throws SQLException {
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        log.info("memberVO : " + memberVO);
        memberDAO.insertMember(memberVO);
    } // register

    public List<MemberDTO> selectAll() throws SQLException {
        List<MemberVO> voList = memberDAO.selectAllMember();
        log.info("voList : " + voList);
        List<MemberDTO> dtoList = voList.stream().map(vo -> modelMapper.map(vo, MemberDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }

    public MemberDTO selectOne(int member_num) throws SQLException {
        log.info("tno : " + member_num);
        MemberVO memberVO = memberDAO.selectOneMember(member_num);
        MemberDTO memberDTO = modelMapper.map(memberVO,MemberDTO.class);
        return memberDTO;

    }

    public void update(MemberDTO memberDTO) throws SQLException {
        log.info("memberDTO : " + memberDTO);
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        memberDAO.updateMember(memberVO);

    }

    public void delete(int member_num) throws SQLException {
        memberDAO.deleteMember(member_num);
    }

    public MemberDTO login(String member_id, String member_password) throws SQLException {
        MemberVO memberVO = memberDAO.getMemberInfo(member_id,member_password);
        MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);
        return memberDTO;
    }
}
