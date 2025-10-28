package com.ssg.springwebmvc.member.repository;

import com.ssg.springwebmvc.member.dto.Member;

import java.util.List;

public interface MemberDAO1 {

      int insert(Member member);
      List<Member> findAll();

}
