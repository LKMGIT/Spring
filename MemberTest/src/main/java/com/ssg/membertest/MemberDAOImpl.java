package com.ssg.membertest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class MemberDAOImpl implements MemberDAO {

    @Autowired
    DataSource dataSource;

    @Autowired
    MemberVO memberVO;

    @Override
    public void insertMember(MemberVO member) throws Exception {
        String sql = "insert into tmember values(?,?,?)";

        Connection conn = dataSource.getConnection();

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, memberVO.getMid());
        ps.setString(2, memberVO.getMpw());
        ps.setString(3, memberVO.getMname());

        ps.executeUpdate();

    }

    @Override
    public List<MemberVO> selectMember() throws Exception{
        List<MemberVO> memberList = new ArrayList<>();

        String sql = "select * from tmember";

        Connection conn = dataSource.getConnection();

        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            MemberVO vo = new MemberVO();
            vo.setMid(rs.getString(1));
            vo.setMpw(rs.getString(2));
            vo.setMname(rs.getString(3));
            memberList.add(vo);
        }

        return memberList;
    }
}
