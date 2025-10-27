package com.ssg.membertest;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Repository
public class MemberVO {

    private String mid;
    private String mpw;
    private String mname;

}
