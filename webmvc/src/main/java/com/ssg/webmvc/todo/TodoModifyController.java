package com.ssg.webmvc.todo;

import com.ssg.webmvc.todo.domain.TodoVO;
import com.ssg.webmvc.todo.dto.TodoDTO;
import com.ssg.webmvc.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;


@WebServlet(name="todoModifyController", urlPatterns = "/todo/modify")
@Log4j2
public class TodoModifyController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String tnoStr = req.getParameter("tno");
        if (tnoStr == null) {
            resp.sendRedirect(req.getContextPath() + "/todo/list");
            return;
        }

        try {
            Long tno = Long.valueOf(tnoStr);
            TodoDTO dto = todoService.get(tno); // tno로 단건 조회
            if (dto == null) {
                resp.sendRedirect(req.getContextPath() + "/todo/list");
                return;
            }
            req.setAttribute("dto", dto); // ★ JSP에서 사용할 dto 주입
            req.getRequestDispatcher("/WEB-INF/todo/modify.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error("수정 화면 로드 실패", e);
            resp.sendRedirect(req.getContextPath() + "/todo/list");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String tnoStr = req.getParameter("tno");
        String title = req.getParameter("title");
        String dateStr = req.getParameter("date");
        log.info("date(raw)={}", dateStr);

        TodoDTO todoDTO = new TodoDTO();

        todoDTO.setTno(Long.valueOf(tnoStr));
        todoDTO.setTitle(title);
        todoDTO.setDueDate(LocalDate.parse(dateStr));

        try {
            todoService.updateOne(todoDTO);
            resp.sendRedirect(req.getContextPath() + "/todo/list");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

}
