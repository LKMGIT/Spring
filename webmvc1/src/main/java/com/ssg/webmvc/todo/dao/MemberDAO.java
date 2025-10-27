package com.ssg.webmvc.todo.dao;

import com.ssg.webmvc.todo.domain.MemberVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class MemberDAO {

    public MemberVO getWithPassWord(String mid, String mpw) throws Exception {
        String sql = "select * from tmember where mid= ? and mpw= ?";

        MemberVO vo = new MemberVO();

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pre = conn.prepareStatement(sql);

        pre.setString(1, mid);
        pre.setString(2,mpw);

        @Cleanup ResultSet rs = pre.executeQuery();
        rs.next();
        vo = MemberVO.builder().mid(rs.getString("mid")).mpw(rs.getString("mpw")).mname(rs.getString("mname")).build();

        return vo;
    }
}
