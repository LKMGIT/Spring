package com.ssg.webmvc.member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MemberRegisterController", urlPatterns = "/register")
public class MemberRegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String user_id = req.getParameter("user_id");
        String user_pw = req.getParameter("user_pw");
        String gender = req.getParameter("gender");
        String[] hobbyArr = req.getParameterValues("hobby");
        String hobbies = null;
        for (int i = 0; i < hobbyArr.length; i++) {
            hobbies = hobbyArr[i];
        }

        MemberVO memberVO = new MemberVO(user_id, user_pw, gender, hobbies);

        MemberDAO memberDAO = new MemberDAO();

        int rows = 0;
        try {
            rows = memberDAO.saveMember(memberVO); // 1=성공, 0=실패 가정
        } catch (Exception e) {
            rows = 0;
        }

        // ★성공이면 user_id를 넣고, 실패면 안 넣음 → JSP에서 존재 여부로 분기
        if (rows == 1) {
            req.setAttribute("user_id", user_id);
        }
        req.getRequestDispatcher("/WEB-INF/result.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/memberRegister.html");
    }
}
