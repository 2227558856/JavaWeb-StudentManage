package com.servlet;

import com.common.module.Student;
import com.service.StudentServiceA;
import com.service.StudentServiceB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * 查询响应
 * @author Administrator
 */
public class FindServlet extends HttpServlet {
    StudentServiceA service=new StudentServiceA();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String choose = (String) req.getSession().getAttribute("Choose");
        //把choose放到session中,便于传给FindSuccess.jsp
        req.getSession().setAttribute("choose", choose);
        StudentServiceA serviceA=new StudentServiceA();
        StudentServiceB serviceB=new StudentServiceB();
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String name=req.getParameter("name");
        Student student;
        if(Objects.equals(choose, "A")){
            student=serviceA.find(name);
        }
        else{
            student=serviceB.find(name);
        }
        if(student!=null){
            //查询成功,存在该学生数据,把值传给FindSuccess界面,用于输出查询到的数据
            resp.getWriter().write("查询成功!");
            req.getRequestDispatcher("FindSuccess.jsp").forward(req, resp);
        }
        else{
            resp.getWriter().write("查询失败!");
            resp.sendRedirect("Error.html");
        }
    }
}
