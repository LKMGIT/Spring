package com.ssg.servletex.servlet_dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    private Statement stmt;
    private Connection conn;

    private void ConnectDB() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("드라이버 로딩 성공");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb?serverTimezone=Asia/Seoul&charEncoding=UTF-8"
                    , "root", "mysql1234");
            System.out.println("연결 성공");
            stmt = conn.createStatement();
            System.out.println("생성 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("드랄이버 존재 X");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<MemberVO> listMembers() {
        List<MemberVO> memberList = new ArrayList<>();
        try {
            ConnectDB();

            String sql = "select * from member";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("userID");
                String pwd = rs.getString("userPwd");
                String name = rs.getString("userName");
                String email = rs.getString("userEmail");
                Date joinDate = rs.getDate("joinDate");

                MemberVO member = new MemberVO(id, pwd, name, email, joinDate);

                memberList.add(member);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return memberList;

    }
}
