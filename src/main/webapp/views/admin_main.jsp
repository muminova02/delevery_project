<%--
  Created by IntelliJ IDEA.
  User: Usmon
  Date: 8/8/2024
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Admin Home</title>
</head>
<body>
<h1>Welcome Admin</h1>
<p><c:out value="${user}"/></p>
1)Your profile
2)add Category, edit Category
3)add Product, edit Product / disable active
4)add SlaydBar, optional
5)show Users
6)show Orders
</body>
</html>
