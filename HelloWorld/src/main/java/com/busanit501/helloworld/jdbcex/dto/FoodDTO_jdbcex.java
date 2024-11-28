package com.busanit501.helloworld.jdbcex.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodDTO_jdbcex {
    private int foodId;
    private String foodName;
    private String foodDescription;
    private int foodPrice;
}
