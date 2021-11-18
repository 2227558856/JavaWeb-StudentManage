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
 * 删除响应
 * @author Administrator
 */
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String choose = (String) req.getSession().getAttribute("Choose");
        StudentServiceA serviceA=new StudentServiceA();
        StudentServiceB serviceB=new StudentServiceB();
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String name=req.getParameter("name");
        boolean flag;
        if(Objects.equals(choose, "A")){
            flag=serviceA.delete(name);
        }
        else{
            flag=serviceB.delete(name);
        }
        if(flag){
            //删除成功,返回学生管理界面
            resp.getWriter().write("删除成功!");
            resp.sendRedirect("Manage.jsp");
        }
        else{
            resp.getWriter().write("删除失败!");
            resp.sendRedirect("Error.html");
        }
    }
}
