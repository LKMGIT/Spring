package com.ssg.springwebmvc.membermvc.service;

import com.ssg.springwebmvc.member.dto.Member;
import com.ssg.springwebmvc.membermvc.dao.MemberDAO;
import com.ssg.springwebmvc.membermvc.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {


    private final MemberDAO memberDAO;

    @Override
    public int insert(MemberDTO memberDTO) {
        return memberDAO.insert(memberDTO);
    }

    @Override
    public List<MemberDTO> findAll() {
        return memberDAO.findAll();
    }
}
