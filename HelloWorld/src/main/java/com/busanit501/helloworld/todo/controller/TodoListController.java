package com.busanit501.helloworld.todo.controller;

import com.busanit501.helloworld.jdbcex.dto.TodoDTO;
import com.busanit501.helloworld.todo.service.TodoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="TodoListController",urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet: TodoListController");
        List<TodoDTO> todoList = TodoService.INSTANCE.getList();
        // 화면에 전달하는 방법,
        req.setAttribute("list", todoList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/todo/todoList.jsp");
        dispatcher.forward(req,resp);
    }
}
