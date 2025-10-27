package com.ssg.membertest;

import java.lang.reflect.Member;
import java.sql.SQLException;
import java.util.List;

public interface MemberDAO {

    public void insertMember(MemberVO member) throws Exception;

    public List<MemberVO> selectMember() throws Exception;


}
