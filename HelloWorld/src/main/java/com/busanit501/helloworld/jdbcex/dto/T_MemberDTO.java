package com.busanit501.helloworld.jdbcex.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class T_MemberDTO {
    private String mid;
    private String mpw;
    private String mname;
}
