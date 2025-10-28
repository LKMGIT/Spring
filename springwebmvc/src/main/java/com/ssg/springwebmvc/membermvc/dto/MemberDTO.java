package com.ssg.springwebmvc.membermvc.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDTO {
    private String mid;
    private String mpw;
    private String mname;
    private String mDate;
}
