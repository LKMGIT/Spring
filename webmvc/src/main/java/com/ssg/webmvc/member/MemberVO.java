package com.ssg.webmvc.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.Data;

@Data
public class MemberVO {
    private String user_id;
    private String user_pwd;
    private String gender;
    private String[] hobby;
}
