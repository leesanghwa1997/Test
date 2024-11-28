package com.busanit501.helloworld.jdbcex.service;

import com.busanit501.helloworld.food.dto.FoodDTO;
import com.busanit501.helloworld.jdbcex.dao.FoodDAO;
import com.busanit501.helloworld.jdbcex.dto.FoodDTO_jdbcex;
import com.busanit501.helloworld.jdbcex.dto.TodoDTO;
import com.busanit501.helloworld.jdbcex.vo.FoodVO;
import com.busanit501.helloworld.jdbcex.vo.TodoVO;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum FoodService {
    INSTANCE;
    private FoodDAO foodDAO;
    private ModelMapper modelMapper;

    FoodService() {
        foodDAO = new FoodDAO();
        modelMapper = new ModelMapper();
    }

    public void register(FoodDTO_jdbcex foodDTO_jdbcex) throws SQLException {
        FoodVO foodVO = modelMapper.map(foodDTO_jdbcex, FoodVO.class);
        foodDAO.insertFood(foodVO);
    }

    public List<FoodDTO_jdbcex> selectAllFood() throws SQLException {
        //DAO에 데이터를 들고오는 메서드 호출
        List<FoodVO> foodVOList = FoodDAO.selectAllFood();
        //VO객체 리스트를 DTO형식으로 변환
        List<FoodDTO_jdbcex> foodDTO_jdbcexList = foodVOList.stream().map(vo -> modelMapper.map(vo, FoodDTO_jdbcex.class)).collect(Collectors.toList());
        //변환한 값을 반환
        return foodDTO_jdbcexList;
    }

    // 하나 조회, 상세보기.
    public FoodDTO_jdbcex selectOneFood(int foodId) throws SQLException {
        log.info("foodId : " + foodId);
        FoodVO foodVO = foodDAO.selectOneFood(foodId);
        FoodDTO_jdbcex foodDTO_jdbcex = modelMapper.map(foodVO,FoodDTO_jdbcex.class);
        return foodDTO_jdbcex;

    }

    public void updateFood(FoodDTO_jdbcex foodDTO_jdbcex) throws SQLException {
        log.info("Updating food: " + foodDTO_jdbcex);

        // ModelMapper를 사용해 VO로 변환
        FoodVO foodVO = modelMapper.map(foodDTO_jdbcex, FoodVO.class);
        log.info("Mapped FoodVO: " + foodVO);

        // DAO 호출
        foodDAO.updateOneFood(foodVO);
    }

    public void deleteFood(int foodId) throws SQLException {
        foodDAO.deleteFood(foodId);
    }
}
