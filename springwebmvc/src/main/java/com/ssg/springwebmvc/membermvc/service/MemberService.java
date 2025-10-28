package com.ssg.springwebmvc.membermvc.service;

import com.ssg.springwebmvc.membermvc.dto.MemberDTO;

import java.util.List;

public interface MemberService {
    public int insert(MemberDTO memberDTO);

    public List<MemberDTO> findAll();

}
