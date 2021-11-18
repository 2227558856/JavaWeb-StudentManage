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
 * 登录响应
 * @author Administrator
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String choose = (String) req.getSession().getAttribute("Choose");
        //把choose放到session中,便于传给Manage.jsp
        req.getSession().setAttribute("choose", choose);
        StudentServiceA serviceA=new StudentServiceA();
        StudentServiceB serviceB=new StudentServiceB();
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //登录输入姓名和密码
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        boolean flag;
        if(Objects.equals(choose, "A")){
            flag=serviceA.login(name,password);
        }
        else{
            flag=serviceB.login(name,password);
        }
        if(flag){
            resp.getWriter().write("登录成功!");
            //页面跳转到学生管理页面
            //设置001为管理员,管理员进入管理界面,普通成员进入查看界面
            if(Objects.equals(name, "001")){
                req.getRequestDispatcher("Manage.jsp").forward(req, resp);
            }
            else{
                req.getRequestDispatcher("CommonManage.jsp").forward(req, resp);
            }
        }
        else{
            resp.getWriter().write("登录失败!");
            //登录失败跳转到失败页面
            resp.sendRedirect("Error.html");
        }
    }
}
