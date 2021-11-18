<%@ page import="com.service.StudentServiceA" %>
<%@ page import="com.service.StudentServiceB" %>
<%@ page import="com.common.module.Student" %>
<%@ page import="java.util.Objects" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/18
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%--普通成员界面(无增删改查操作)--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生管理界面</title>
</head>
<body>
<table border="1">
    <tr>
        <th>序号</th>
        <th>创建时间</th>
        <th>更新时间</th>
        <th>姓名</th>
        <th>密码</th>
        <th>手机号</th>
    </tr>
    <%
        String choose = (String)request.getSession().getAttribute("choose");
        StudentServiceA serviceA=new StudentServiceA();
        StudentServiceB serviceB=new StudentServiceB();
        List<Student> list;
        if(Objects.equals(choose, "A")){
            list=serviceA.all();
        }
        else {
            list=serviceB.all();
        }
        for(Student s:list) {%>
    <tr>
        <td><%=s.getId() %></td>
        <td><%=s.getCreatedTime() %>></td>
        <td><%=s.getUpdatedTime() %></td>
        <td><%=s.getName() %></td>
        <td><%=s.getPassword()%></td>
        <td><%=s.getPhone()%></td>
    </tr>
    <%}
    %>
</table>
</body>
</html>
