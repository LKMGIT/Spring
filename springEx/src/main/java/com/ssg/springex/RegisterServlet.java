package com.ssg.springex;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp);
    }

    private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String user_name = req.getParameter("user_name");
        Integer user_age = Integer.valueOf(req.getParameter("user_age"));
        String user_id = req.getParameter("user_id");
        String user_pw = req.getParameter("user_pw");
        String user_addr = req.getParameter("user_addr");

        PrintWriter out = resp.getWriter();

        String data = "<html>";
        data += "<body>";
        data += "<h1>" + "회원가입 성공" + "</h1>";
        data += "<p>" + user_name + "</p>";
        data += "<p>" + user_age + "</p>";
        data += "<p>" + user_id + "</p>";
        data += "<p>" + user_pw + "</p>";
        data += "<p>" + user_addr + "</p>";
        data += "</body>";
        data += "</html>";
        out.println(data);
    }
}
