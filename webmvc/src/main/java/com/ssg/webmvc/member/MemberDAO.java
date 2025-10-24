package com.ssg.webmvc.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDAO {

    private Connection conn;
    private PreparedStatement pstmt;

    private void ConnDB() {
        final String DRIVER = "com.mysql.cj.jdbc.Driver";
        final String URL =
                "jdbc:mysql://localhost:3306/sqld"
                        + "?useUnicode=true&characterEncoding=UTF-8"
                        + "&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true";
        final String USER = "root";
        final String PASS = "mysql1234";

        {
            try {
                Class.forName(DRIVER);
                System.out.println("드라이버 로딩 성공");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("MySQL 드라이버를 찾을 수 없습니다.", e);
            }
        }
    }

    public int addMember(MemberVO member) {
        int result = 0;
        try {
            ConnDB();

            String user_id = member.getUser_id();
            String user_pwd = member.getUser_pwd();
            String gender = member.getGender();
            String hobby = String.join(",", member.getHobby());

            String sql = "INSERT INTO memberInfo (user_id, user_pwd, gender, hobby) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, user_id);
            pstmt.setString(2, user_pwd);
            pstmt.setString(3, gender);
            pstmt.setString(4, hobby);

            result = pstmt.executeUpdate();

            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
