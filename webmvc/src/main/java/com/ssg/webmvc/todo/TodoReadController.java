package com.ssg.webmvc.todo;

import com.ssg.webmvc.todo.dto.TodoDTO;
import com.ssg.webmvc.todo.service.TodoService;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="todoReadController", urlPatterns="/todo/read")
@Log4j2
public class TodoReadController extends HttpServlet {

    private final TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tnoStr = req.getParameter("tno");
        if (tnoStr == null) {
            resp.sendRedirect(req.getContextPath() + "/todo/list");
            return;
        }

        try {
            Long tno = Long.valueOf(tnoStr);
            TodoDTO dto = todoService.get(tno);
            if (dto == null) {
                resp.sendRedirect(req.getContextPath() + "/todo/list");
                return;
            }
            req.setAttribute("dto", dto);
            req.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error("읽기 실패", e);
            resp.sendRedirect(req.getContextPath() + "/todo/list");
        }
    }
}

