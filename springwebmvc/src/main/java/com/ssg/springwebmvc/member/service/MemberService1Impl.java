package com.ssg.springwebmvc.member.service;


import com.ssg.springwebmvc.member.dto.Member;
import com.ssg.springwebmvc.member.repository.MemberDAO1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService1Impl implements MemberService1 {

    private final MemberDAO1 memberDAO1;



    @Override
    @Transactional
    public void joinMember(Member member) {
         memberDAO1.insert(member);

    }

    @Override
    @Transactional
    public List<Member> memberList() {
        return memberDAO1.findAll();
    }
}
