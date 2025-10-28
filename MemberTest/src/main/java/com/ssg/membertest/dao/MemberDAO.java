package com.ssg.membertest.dao;

import com.ssg.membertest.vo.MemberVO;

import java.util.List;

public interface MemberDAO {

    public void insertMember(MemberVO member) throws Exception;

    public List<MemberVO> selectMember() throws Exception;


}
