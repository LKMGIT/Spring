package com.ssg.servletex.servlet_dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {


    //DAO 에서 값을 받아서 본문에 뿌리는 Get
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberDAO memberDAO = new MemberDAO();
        List<MemberVO> memberList = memberDAO.listMembers();

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.println("<table border='1'><tr align='center' bgcolor='lightgreen'>");
        out.println("<th>ID</th><th>Name</th><th>Email</th><th>Join Date</th></tr>");

        for(MemberVO member: memberList) {
            String id = member.getUser_Id();
            String name = member.getUserName();
            String email = member.getUserEmail();
            Date joinDate = member.getJoinDate();

            out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>"
                    + email + "</td><td>" + joinDate+"</td></tr>");
        }
        out.println("</table></body></html>");

    }


    //사용자가 입력한 정보를 받아서 DAO에 전송하는 POST
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


}
