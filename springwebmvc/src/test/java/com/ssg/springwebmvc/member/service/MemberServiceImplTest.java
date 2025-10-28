package com.ssg.springwebmvc.member.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations =
        {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

class MemberServiceImplTest {

    @Autowired
    MemberService1 memberService;


//    @Test
//    @Transactional
//    @Rollback(false)
//    void joinMember() {
//        Member m = new Member();
//        m.setUserId("yumi05");
//        m.setUserPwd("pw1234");
//        m.setUserName("유미서");
//        m.setUserEmail("yumi01@example.com");
//        m.setJoinDate(LocalDate.now());
//
//        memberService.joinMember(m);
//    }

//    @Test
//    void memberList() {
//        memberService.memberList().forEach(System.out::println);
//    }
}