package com.ssg.springwebmvc.membermvc.dao;

import com.ssg.springwebmvc.membermvc.dto.MemberDTO;
import com.ssg.springwebmvc.membermvc.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberDAOImpl implements MemberDAO {

    private final MemberMapper memberMapper;

    @Override
    public int insert(MemberDTO member) {
        return memberMapper.insert(member);
    }

    @Override
    public List<MemberDTO> findAll() {
        return memberMapper.findAll();
    }
}
