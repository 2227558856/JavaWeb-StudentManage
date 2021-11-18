package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * 选择团队响应
 * @author Administrator
 */
public class ChooseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String choose = req.getParameter("choose");
        /*团队选择*/
        req.getSession().setAttribute("Choose", choose);
        resp.sendRedirect("Login.html");
    }
}
