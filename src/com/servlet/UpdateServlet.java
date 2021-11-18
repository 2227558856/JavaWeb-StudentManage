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
 * 更新响应
 * @author Administrator
 */
public class UpdateServlet extends HttpServlet {
    StudentServiceA service=new StudentServiceA();

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
            flag=serviceA.update(name,password,phone);
        }
        else{
            flag=serviceB.update(name,password,phone);
        }
        if(flag){
            //更新成功,返回学生管理界面
            resp.getWriter().write("更新成功!");
            resp.sendRedirect("Manage.jsp");
        }
        else{
            resp.getWriter().write("更新失败!");
            resp.sendRedirect("Error.html");
        }
    }
}
