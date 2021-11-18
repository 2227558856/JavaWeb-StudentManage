package com.servlet;

import com.service.StudentServiceA;
import com.service.StudentServiceB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * 注册响应
 * @author Administrator
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String choose = (String) req.getSession().getAttribute("Choose");
        StudentServiceA serviceA=new StudentServiceA();
        StudentServiceB serviceB=new StudentServiceB();
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        String phone=req.getParameter("phone");
        boolean flag;
        if(Objects.equals(choose, "A")){
            flag=serviceA.register(name,password,phone);
        }
        else{
            flag=serviceB.register(name,password,phone);
        }
        if(flag){
            //注册成功,跳转到登录页面
            resp.getWriter().write("注册成功!");
            resp.sendRedirect("Login.html");
        }
        else{
            resp.getWriter().write("注册失败!");
            resp.sendRedirect("Error.html");
        }
    }
}
