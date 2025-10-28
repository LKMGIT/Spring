package com.ssg.springwebmvc.membermvc.dao;

import com.ssg.springwebmvc.member.dto.Member;
import com.ssg.springwebmvc.membermvc.dto.MemberDTO;

import java.util.List;

public interface MemberDAO {

    int insert(MemberDTO member);
    List<MemberDTO> findAll();

}
