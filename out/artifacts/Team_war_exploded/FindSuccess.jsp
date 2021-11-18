<%@ page import="com.service.StudentServiceA" %>
<%@ page import="com.common.module.Student" %>
<%@ page import="com.service.StudentServiceB" %>
<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/17
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查找成功</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    String choose = (String)request.getSession().getAttribute("choose");
    StudentServiceA serviceA=new StudentServiceA();
    StudentServiceB serviceB=new StudentServiceB();
    /*获得表单提交的name*/
    Student student;
    if(Objects.equals(choose, "A")){
        student=serviceA.find(name);
    }
    else{
        student=serviceB.find(name);
    }
    if(student!=null) {%>
<table border="1">
    <tr>
        <td><%=student.getId() %></td>
        <td><%=student.getCreatedTime() %>></td>
        <td><%=student.getUpdatedTime() %></td>
        <td><%=student.getName() %></td>
        <td><%=student.getPassword()%></td>
        <td><%=student.getPhone()%></td>
    </tr>
</table>
<%}
%>
</body>
</html>
