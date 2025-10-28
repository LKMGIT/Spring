package com.ssg.springwebmvc.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller // 해당 클래스가 Spring MVC 에서 컨트롤러 역할을 하고 Bean으로 등록
//RequestMapping 을 많이 사용한다. 특정한 경로를 사용했을 때 지정해준다
@Log4j2
public class SampleController {


    @GetMapping("/hello")
    public void hello() {
        log.info("hello");
    }

    @GetMapping("/ex01")
    public void ex01(String name, int age){
        log.info("ex01에서 수집한 파라미터");
        log.info("name: " + name + ", age: " + age);
    }

    @GetMapping("/ex02")
    public void ex02(@RequestParam(name="name", defaultValue = "lalala") String name,
                     @RequestParam(name="age", defaultValue = "20") Integer age){
        log.info("ex02에서 수집한 파라미터");
        log.info("name: " + name + ", age: " + age);
    }

    @GetMapping("/ex03")
    public void ex03(LocalDate duDate){
        log.info("ex03에서 수집한 파라미터");
        log.info("duDate: " + duDate);
    }

}
