<%@ page import="com.service.StudentServiceA" %>
<%@ page import="com.common.module.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.service.StudentServiceB" %>
<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/17
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%--管理员界面--%>
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
<%--超链接按钮--%>
<a href="Add.html">
  <input type="button" value="添加">
</a>
<a href="Delete.html">
  <input type="button" value="删除">
</a>
<a href="Update.html">
  <input type="button" value="修改">
</a>
<a href="Find.html">
  <input type="button" value="查找">
</a>


</body>
</html>
