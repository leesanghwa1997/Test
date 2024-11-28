package com.busanit501.helloworld.jdbcex.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
    private int member_num;
    private String member_name;
    private String member_id;
    private String member_password;
    private LocalDate created_at;
}
