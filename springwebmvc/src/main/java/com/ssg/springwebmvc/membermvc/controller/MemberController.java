package com.ssg.springwebmvc.membermvc.controller;

import com.ssg.springwebmvc.membermvc.dto.MemberDTO;
import org.springframework.ui.Model;

public interface MemberController {
    public void register(MemberDTO memberDTO)  throws Exception ;
    public void selctAll(MemberDTO memberDTO, Model model)  throws Exception ;
}
