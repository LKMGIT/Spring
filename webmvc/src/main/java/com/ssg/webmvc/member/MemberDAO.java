package com.ssg.webmvc.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDAO {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL =
            "jdbc:mysql://localhost:3306/sqld"
                    + "?useUnicode=true&characterEncoding=UTF-8"
                    + "&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASS = "mysql1234";

    static {
        try {
            Class.forName(DRIVER);
            System.out.println("드라이버 로딩 성공");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL 드라이버를 찾을 수 없습니다.", e);
        }
    }

    public int saveMember(MemberVO memberVO) {
        // 테이블명이 소문자라면 member 로 통일하세요.
        final String sql =
                "INSERT INTO member (user_id, user_pw, gender, hobbies) "
                        + "VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, memberVO.getUser_id());
            ps.setString(2, memberVO.getUser_pw());
            ps.setString(3, memberVO.getGender());
            ps.setString(4, memberVO.getHobbies());

            int rows = ps.executeUpdate();
            System.out.println("INSERT rows = " + rows);
            return rows;

        } catch (SQLException e) {
            // 중복 PK/UK 등 상세 원인 로그
            e.printStackTrace();
            throw new RuntimeException("회원 저장 중 DB 오류", e);
        }
    }
}
