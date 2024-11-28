package com.busanit501.helloworld.todo.controller;

import com.busanit501.helloworld.jdbcex.dto.TodoDTO;
import com.busanit501.helloworld.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="TodoReadController",urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet TodoReadController 하나 조회 예제");

        // 클릭한 게시글 번호를 가지고 와야함.
        Long tno = Long.parseLong(req.getParameter("tno"));

        // 서비스에서, 하나의 todo 더미 데이터를 조회 후,
        TodoDTO todoDTO  = TodoService.INSTANCE.getOne(tno);

        // 화면에 전달하기.
        req.setAttribute("dto",todoDTO);
        req.getRequestDispatcher("/WEB-INF/todo/todoRead.jsp").forward(req, resp);
    }
}
