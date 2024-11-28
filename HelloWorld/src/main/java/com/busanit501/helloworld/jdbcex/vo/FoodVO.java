package com.busanit501.helloworld.jdbcex.vo;

import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodVO {
    private int foodId;
    private String foodName;
    private String foodDescription;
    private int foodPrice;
}
