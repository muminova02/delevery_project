<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 10.08.2024
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<html>
<head>
    <title>Users</title>
<body>
<style>
    body {
        font-family: Arial, sans-serif;
        display: flex;
        flex-direction: column;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    form {
        border: 1px solid #ccc;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        margin-bottom: 20px;
    }

    div {
        margin-bottom: 15px;
    }

    label {
        display: block;
        margin-bottom: 5px;
    }

    input {
        width: 100%;
        padding: 8px;
        box-sizing: border-box;
    }

    button {
        width: 100%;
        padding: 10px;
        background-color: #28a745;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    button:hover {
        background-color: #218838;
    }

    table {
        width: 80%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    table, th, td {
        border: 1px solid #ccc;
    }

    th, td {
        padding: 10px;
        text-align: left;
    }

    th {
        background-color: #f2f2f2;
    }

    tr:nth-child(even) {
        background-color: #f9f9f9;
    }
</style>
</head>
</body>

<div class="navbar">
    <a href="/admin/adminMainController?value=category" >Category</a>
    <a href="/admin/adminMainController?value=product">Product</a>
    <a href="/admin/adminMainController?value=slaydBar">Add SlaydBar</a>
    <a href="/admin/adminMainController?value=users">Show Users</a>
    <a href="/admin/adminMainController?value=orders">Show Orders</a>
    <div class="profile">
        <img src="/views/attachments/userImage.png" alt="Profile" onclick="location.href='profile.jsp'"/>
    </div>
</div>

<div class="content">

    <div class="container">
        <h1>Users</h1>
        <table>
            <tr>
                <th>id</th>
                <th>email</th>
                <th>phone-number</th>
                <th>password</th>
                <th>first name</th>
                <th>last name</th>
                <th>date of birth</th>
                <th>created At</th>
                <th>isActive</th>
                <th>role</th>
                <th>is deleted</th>
                <th>has confirmed</th>
                <th>doBlock</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${users}" var="us">
                <tr>
                    <td><c:out value="${us.getId()}"/></td>
                    <td><c:out value="${us.getEmail()}"/></td>
                    <td><c:out value="${us.getPhoneNumber()}"/></td>
                    <td><c:out value="${us.getFirstName()}"/></td>
                    <td><c:out value="${us.getLastName()}"/></td>
                    <td><c:out value="${us.getDateOfBirth()}"/></td>
                    <td><c:out value="${us.getCreatedAt()}"/></td>
                    <td><c:out value="${us.getIsActive()}"/></td>
                    <td><c:out value="${us.getRole()}"/></td>
                    <td><c:out value="${us.getIsDeleted()}"/></td>
                    <td><c:out value="${us.getHasConfirmed}"/></td>
                    <td>
                        <button
                                class="<c:if test="${us.isActive()}">button-confirmed</c:if><c:if test="${!us.isActive()}">button-unconfirmed</c:if>"
                                onclick="toggleConfirmed('${us.getId()}', '${us.isActive()}')">
                            <c:if test="${us.isActive()}">Confirmed</c:if>
                            <c:if test="${!us.isActive()}">Unconfirmed</c:if>
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>-
    </div>
    </div>
</div>
</html>
