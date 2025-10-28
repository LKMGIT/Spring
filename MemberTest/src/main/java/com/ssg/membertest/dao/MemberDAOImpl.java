package com.ssg.membertest.dao;

import com.ssg.membertest.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class MemberDAOImpl implements MemberDAO {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<MemberVO> rowMapper = new RowMapper<MemberVO>() {

        @Override
        public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            MemberVO memberVO = new MemberVO();
            memberVO.setMid(rs.getString("mid"));
            memberVO.setMpw(rs.getString("mpw"));
            memberVO.setMname(rs.getString("mname"));

            return memberVO;
        }
    };

    @Override
    public void insertMember(MemberVO member) throws Exception {

        String sql = "insert into tmember(mid, mpw, mname) values(?,?,?)";

        jdbcTemplate.update(sql,
                member.getMid(),
                member.getMpw(),
                member.getMname());

    }

    @Override
    public List<MemberVO> selectMember() throws Exception{

        String sql = "select * from tmember";
        return jdbcTemplate.query(sql, rowMapper);


    }
}
