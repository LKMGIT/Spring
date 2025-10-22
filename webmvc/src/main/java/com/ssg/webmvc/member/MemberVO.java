package com.ssg.webmvc.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {

    private String user_id;
    private String user_pw;
    private String gender;
    private String hobbies;
}
