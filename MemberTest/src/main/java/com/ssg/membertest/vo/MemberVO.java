package com.ssg.membertest.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberVO {

    private String mid;
    private String mpw;
    private String mname;
    private LocalDate mdate;

}
