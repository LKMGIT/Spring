package com.ssg.membertest;

import java.lang.reflect.Member;
import java.util.List;

public interface MemberSerivce {

    public void insertMember(MemberVO member) throws Exception;
    public List<MemberVO> selectMember() throws Exception;

}
