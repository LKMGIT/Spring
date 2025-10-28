package com.ssg.membertest.service;

import com.ssg.membertest.dao.MemberDAO;
import com.ssg.membertest.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberSerivce{

    private final MemberDAO memberDAO;

    @Override
    @Transactional
    public void insertMember(MemberVO member) throws Exception {
        memberDAO.insertMember(member);
    }

    @Override
    @Transactional // 데이터베이스 처리 단위 오류 발생시 롤백 가능 지점 
    public List<MemberVO> selectMember() throws Exception {
        return memberDAO.selectMember();
    }
}
