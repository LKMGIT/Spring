package com.ssg.springex;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc")
public class CalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp);
    }


    private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String p1 = req.getParameter("num1");
        String p2 = req.getParameter("num2");
        String pr = req.getParameter("result");

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!doctype html><html><body>");
            out.printf("<p>num1 = %s</p>%n", p1);
            out.printf("<p>num2 = %s</p>%n", p2);
            out.printf("<p>result = %s</p>%n", pr);
            out.println("</body></html>");
        }

    }
}
