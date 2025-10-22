package com.ssg.springex;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/member_register")
public class MemberRegister extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp);
    }

    private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String user_id = req.getParameter("user_id");
        String user_pw = req.getParameter("user_pw");
        String gender = req.getParameter("gender");
        String hobby = req.getParameter("hobby");


        PrintWriter out = resp.getWriter();
        out.println("<!doctype html><html><body>");
        out.printf("<p>user_id = %s</p>%n", user_id);
        out.printf("<p>user_pw = %s</p>%n", user_pw);
        out.printf("<p>gender = %s</p>%n", gender);
        out.printf("<p>hobby = %s</p>%n", hobby);
        out.println("</body></html>");

    }
}
