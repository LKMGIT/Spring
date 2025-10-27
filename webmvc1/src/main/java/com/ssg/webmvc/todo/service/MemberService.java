package com.ssg.webmvc.todo.service;

import com.ssg.webmvc.todo.dao.MemberDAO;
import com.ssg.webmvc.todo.domain.MemberVO;
import com.ssg.webmvc.todo.dto.MemberDTO;
import com.ssg.webmvc.todo.util.MapperUtil;
import org.modelmapper.ModelMapper;

public enum MemberService {
    InSTANCE;

    private MemberDAO dao;
    private ModelMapper mapper;

    MemberService() {
        dao = new MemberDAO();
        mapper = MapperUtil.INSTANCE.get();
    }

    public MemberDTO login(String mid, String mpw) throws Exception {
        MemberVO vo = dao.getWithPassWord(mid, mpw);
        MemberDTO dto = mapper.map(vo, MemberDTO.class);
        return dto;
    }


}
