package com.ssg.webmvc.todo.controller;

import com.ssg.webmvc.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="TodoRemoveController", urlPatterns = "/todo/remove")
public class TodoRemoveController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String tnoStr = req.getParameter("tno");

        try {
            todoService.delete(Long.valueOf(tnoStr));
            resp.sendRedirect(req.getContextPath() + "/todo/list");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
