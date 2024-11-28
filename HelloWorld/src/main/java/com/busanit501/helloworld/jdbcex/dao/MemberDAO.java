package com.busanit501.helloworld.jdbcex.dao;

import com.busanit501.helloworld.jdbcex.vo.MemberVO;
import com.busanit501.helloworld.jdbcex.vo.TodoVO;
import lombok.Cleanup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    public String getTime() {
        String now = null;
        try (Connection connection = ConnectionUtil.INSTANCE.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("select now()");
             ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            resultSet.next();
            now = resultSet.getString(1);

        } catch (Exception e) {
            e.printStackTrace();
        } //catch
        return now;
    } //getTime

    public String getTime2() throws SQLException {
        String now = null;
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("select now()");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        now = resultSet.getString(1);
        return now;
    }

    public List<MemberVO> selectAllMember() throws SQLException {
        String sql = "select * from member";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        List<MemberVO> list = new ArrayList<>();
        while (resultSet.next()) {
            MemberVO memberVO = MemberVO.builder()
                    .member_num(resultSet.getInt("member_num"))
                    .member_name(resultSet.getString("member_name"))
                    .member_id(resultSet.getString("member_id"))
                    .member_password(resultSet.getString("member_password"))
                    .created_at(resultSet.getDate("created_at").toLocalDate())
                    .build();
            list.add(memberVO);
        }
        return list;
    }

    public MemberVO selectOneMember(int member_num) throws SQLException {
        String sql = "select * from member where member_num = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, member_num); // Set the member_num parameter
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        MemberVO memberVO = MemberVO.builder()
                .member_num(resultSet.getInt("member_num"))
                .member_name(resultSet.getString("member_name"))
                .member_id(resultSet.getString("member_id"))
                .member_password(resultSet.getString("member_password"))
                .created_at(resultSet.getDate("created_at").toLocalDate())
                .build();
        return memberVO;
    }

    public void insertMember(MemberVO memberVO) throws SQLException {
        String sql = "insert into member (member_name, member_id, member_password,created_at) " +
                "values (?, ?, ?,?)";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, memberVO.getMember_name());
        preparedStatement.setString(2, memberVO.getMember_id());
        preparedStatement.setString(3, memberVO.getMember_password());
        preparedStatement.setDate(4, Date.valueOf(memberVO.getCreated_at()));
        preparedStatement.executeUpdate();
    }

    public void updateMember(MemberVO memberVO) throws SQLException {
        String sql = " update member set member_name=?, member_id=?, member_password=?" +
                " where member_num=?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, memberVO.getMember_name());
        preparedStatement.setString(2, memberVO.getMember_id());
        preparedStatement.setString(3, memberVO.getMember_password());
        preparedStatement.setInt(4, memberVO.getMember_num());
        preparedStatement.executeUpdate();
    }

    public void deleteMember(int member_num) throws SQLException {
        String sql = "delete from member where member_num =?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, member_num);
        preparedStatement.executeUpdate();
    }
}
