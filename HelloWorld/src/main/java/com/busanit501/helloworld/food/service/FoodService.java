package com.busanit501.helloworld.food.service;

import com.busanit501.helloworld.food.dto.FoodDTO;
import com.busanit501.helloworld.todo.dto.TodoDTO;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import java.time.LocalDate;

public enum FoodService {
    INSTANCE;
    public FoodDTO getOne(int foodId) {
        // 실제로, 디비에서 데이터 받아 와야 하지만,
        // 더미 데이터 이용하기.
        FoodDTO foodDTO = new FoodDTO();
        foodDTO.setFoodId(5);
        foodDTO.setFoodName("음식5");
        foodDTO.setFoodPrice(5500);
        foodDTO.setFoodDescription("음식에 대한 설명");
        return foodDTO;
    }
}
