package com.ssg.membertest.service;

import com.ssg.membertest.vo.MemberVO;

import java.util.List;

public interface MemberSerivce {

    public void insertMember(MemberVO member) throws Exception;
    public List<MemberVO> selectMember() throws Exception;

}
