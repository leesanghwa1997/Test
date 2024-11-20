package com.busanit501.helloworld;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "1", urlPatterns = "/my3")
public class Test1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>" +
                "<head>" +
                "<h1>lunch menu</h1>" +
                "<h2></h2>" +
                "</head>" +
                "<body>");
    }
}

