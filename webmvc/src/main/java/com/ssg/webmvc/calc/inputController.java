package com.ssg.webmvc.calc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// input.jsp를 ㄹ보여주기 위한 처리 부분
@WebServlet(name = "inputController", urlPatterns = "/calc/input")
public class inputController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("inputController 요청된 doGet 메서드입니다.");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/calc/input.jsp");
        dispatcher.forward(req, resp);

        // 서블릿에서 전달된 요청을 다른 쪽으로 전달 또는 배포하는 역할 객체

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
