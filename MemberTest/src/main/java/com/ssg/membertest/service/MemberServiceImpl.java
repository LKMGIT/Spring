package com.ssg.membertest.service;

import com.ssg.membertest.dao.MemberDAO;
import com.ssg.membertest.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberSerivce{

    private final MemberDAO memberDAO;

    @Override
    public void insertMember(MemberVO member) throws Exception {
        memberDAO.insertMember(member);
    }

    @Override
    public List<MemberVO> selectMember() throws Exception {
        return memberDAO.selectMember();
    }
}
