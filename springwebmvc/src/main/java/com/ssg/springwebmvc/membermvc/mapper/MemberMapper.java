package com.ssg.springwebmvc.membermvc.mapper;

import com.ssg.springwebmvc.membermvc.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    int insert(MemberDTO member);
    List<MemberDTO> findAll();
}
