package com.busanit501.helloworld.jdbcex.dao;

import com.busanit501.helloworld.jdbcex.vo.FoodVO;
import com.busanit501.helloworld.jdbcex.vo.TodoVO;
import lombok.Cleanup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodDAO {
    //저장
    public void insertFood(FoodVO foodVO) throws SQLException {
        String sql = "INSERT INTO food(food_name, food_description, food_price) VALUES (?, ?, ?)";
        @Cleanup Connection con = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = con.prepareStatement(sql);

        // FoodVO 객체의 값을 PreparedStatement에 설정
        ps.setString(1, foodVO.getFoodName());
        ps.setString(2, foodVO.getFoodDescription());
        ps.setInt(3, foodVO.getFoodPrice());

        ps.executeUpdate(); // SQL 실행
    }
    //전체조회
    public static List<FoodVO> selectAllFood() throws SQLException {
        String sql = "select * from food";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        List<FoodVO> list = new ArrayList<>();
        while (resultSet.next()) {
            FoodVO foodVO = FoodVO.builder()
                    .foodId(resultSet.getInt("food_id"))
                    .foodName(resultSet.getString("food_name"))
                    .foodDescription(resultSet.getString("food_description"))
                    .foodPrice(resultSet.getInt("food_price"))
                    .build();
            list.add(foodVO);
        }
        return list;
    }

    public FoodVO selectOneFood(int foodId) throws SQLException {
        String sql = "select * from food where food_id=?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, foodId);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        FoodVO foodVO = FoodVO.builder()
                .foodId(resultSet.getInt("food_id"))
                .foodName(resultSet.getString("food_name"))
                .foodDescription(resultSet.getString("food_description"))
                .foodPrice(resultSet.getInt("food_price"))
                .build();
        return foodVO;
    }

    public void updateOneFood(FoodVO foodVO) throws SQLException {
        String sql = " update food set food_name=?, food_description=?, food_price=?" +
                " where food_id=?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, foodVO.getFoodName());
        preparedStatement.setString(2, foodVO.getFoodDescription());
        preparedStatement.setInt(3, foodVO.getFoodPrice());
        preparedStatement.setInt(4, foodVO.getFoodId());
        preparedStatement.executeUpdate();
    }

    public void deleteFood(int foodId) throws SQLException {
        String sql = "delete from food where food_id =?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, foodId);
        preparedStatement.executeUpdate();
    }
}
