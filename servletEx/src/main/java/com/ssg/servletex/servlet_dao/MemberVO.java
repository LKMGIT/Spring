package com.ssg.servletex.servlet_dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {

    private String user_Id;
    private String user_Pwd;
    private String userName;
    private String userEmail;
    private Date joinDate;

}
