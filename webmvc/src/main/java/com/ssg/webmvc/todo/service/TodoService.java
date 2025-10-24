package com.ssg.webmvc.todo.service;
//객체의 개수를 결정할때 사용한다.
// 현재 INSTANCE가 한 개이므로 서비스객체 1개만 사용  TodoService.INSTENCE 접근
//객체를 하나만 생성해서 사용 (singleton pattern)
//여러 컨트롤러들이 TodoService 객체를 통해서 원하는 데이터를 주고받는 구조로 구성
// 장점 : 정해진 수만큼 객체를 생성할 수 있다.

import com.ssg.webmvc.todo.dao.TodoDAO;
import com.ssg.webmvc.todo.domain.TodoVO;
import com.ssg.webmvc.todo.dto.TodoDTO;
import com.ssg.webmvc.todo.util.MapperUtil;
import org.modelmapper.ModelMapper;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TodoService {
    INSTANCE;

    private TodoDAO dao; //DI
    private ModelMapper modelMapper;

    TodoService() {
        this.dao = new TodoDAO();
        this.modelMapper = MapperUtil.INSTANCE.get();
    }

    public void register(TodoDTO todoDTO) throws Exception {
        TodoVO todoVo = modelMapper.map(todoDTO, TodoVO.class); //map을 이용하여 DTO 객체를 VO 객채로 변환
        System.out.println("todoVo" + todoVo);

        dao.insert(todoVo);

    }


    public List<TodoDTO> ListAll() throws Exception {
        List<TodoVO> todoVOS = new ArrayList<>();
        todoVOS = dao.selectAll();

        List<TodoDTO> todoList = todoVOS.stream().map(
                vo -> modelMapper.map(vo, TodoDTO.class)).collect(Collectors.toList());

        return todoList;

    }

    public TodoDTO get(Long tno) throws Exception {
        TodoVO todoVO = dao.selectOne(tno);

        return modelMapper.map(todoVO, TodoDTO.class);
    }

    public void delete(Long tno) throws Exception {
        dao.deleteOne(tno);
    }

    public void updateOne(TodoDTO todoDTO) throws Exception {
        dao.updateOne(todoDTO);
    }


}


