package com.ssg.springwebmvc.membermvc.controller;


import com.ssg.springwebmvc.dto.TodoDTO;
import com.ssg.springwebmvc.membermvc.dto.MemberDTO;
import com.ssg.springwebmvc.membermvc.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor
public class MemberControllerImpl implements MemberController {

    private final MemberService memberService;

    @GetMapping("/register")
    public void register(){
        log.info("register GET controller");
    }

    @Override
    @PostMapping("/register")
    public void register(MemberDTO memberDTO) throws Exception {
        memberService.insert(memberDTO);
    }

    @Override
    @GetMapping("/memberlist")
    public void selctAll(MemberDTO memberDTO, Model model) throws Exception {
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberDTOList", memberDTOList);
    }

}
