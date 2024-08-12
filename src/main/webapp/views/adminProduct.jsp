<%@ page import="uz.doublem.delevery_for_exam.service.CategoryService" %>
<%@ page import="uz.doublem.delevery_for_exam.repository.CategoryRepository" %>
<%@ page import="uz.doublem.delevery_for_exam.entity.Category" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Usmon
  Date: 8/9/2024
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<html>
<head>
    <title>Product</title>
    <style>
        /* Existing Styles */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .navbar {
            background-color: #333;
            overflow: hidden;
            padding: 1rem;
        }
        .navbar a {
            float: left;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }
        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }
        .profile {
            float: right;
            margin-right: 15px;
        }
        .profile img {
            border-radius: 50%;
            width: 40px;
            height: 40px;
        }
        .content {
            padding: 20px;
        }
        h1 {
            color: #333;
        }
        .profile:hover {
            cursor: pointer;
        }
        .container {
            max-width: 800px;
            margin: auto;
            background: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            font-size: 16px;
            color: #fff;
            background-color: #5cb85c;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
        }
        .btn.edit {
            background-color: #0275d8;
        }
        .btn.delete {
            background-color: #d9534f;
        }
        .btn:hover {
            opacity: 0.8;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        .form-group input {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        .form-group input:focus {
            border-color: #0275d8;
            outline: none;
        }
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            padding-top: 60px;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.5);
        }
        .modal-content {
            background-color: #fff;
            margin: auto;
            padding: 20px;
            border: 1px solid #888;
            border-radius: 8px;
            width: 50%;
            box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.3);
        }
        .button-confirmed {
            background-color: #28a745;
            color: white;
            padding: 5px 10px;
            border-radius: 5px;
            border: none;
        }
        .button-unconfirmed {
            background-color: #fa2020;
            color: white;
            padding: 5px 10px;
            border-radius: 5px;
            border: none;
        }
        button {
            cursor: pointer;
            margin-bottom: 10px;
        }
        /* Dropdown Styling */
        .select-wrapper {
            position: relative;
            display: inline-block;
            width: 100%;
        }

        .select-wrapper select {
            width: 100%;
            padding: 10px;
            border-radius: 4px;
            background-color: #f2f2f2;
            border: 1px solid #ddd;
            -webkit-appearance: none;
            -moz-appearance: none;
            appearance: none;
            cursor: pointer;
        }

        .select-wrapper::after {
            content: '\25BC'; /* Down arrow */
            position: absolute;
            top: 50%;
            right: 10px;
            transform: translateY(-50%);
            pointer-events: none;
            font-size: 14px;
            color: #333;
        }

        .select-wrapper select:focus {
            border-color: #0275d8;
            outline: none;
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
        }

        .select-wrapper select:hover {
            background-color: #e9ecef;
        }
        .card-image {
            flex: 1;
            display: flex;
            align-items: center;
            justify-content: center;
            overflow: hidden;
            /*padding: 10px;*/
        }
        .card-image img {
            max-width: 100%;
            max-height: 400px;
            object-fit: cover;
        }

    </style>

</head>
<body>
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
    <h1>Product Management</h1>
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>description</th>
            <th>price</th>
            <th>category</th>
            <th>created At</th>
            <th>isActive</th>
            <th>doBlock</th>
            <th>Action</th>
            <th>Image</th>
        </tr>
        <c:forEach items="${product}" var="pr">
            <tr>
                <td><c:out value="${pr.getId()}"/></td>
                <td><c:out value="${pr.getName()}"/></td>
                <td><c:out value="${pr.getDescription()}"/></td>
                <td><c:out value="${pr.getPrice()}"/></td>
                <td><c:out value="${pr.getCategory().getName()}"/></td>
                <td><c:out value="${pr.getCreatedAt()}"/></td>
                <td><c:out value="${pr.isActive()}"/></td>
                <td>
                    <button
                            class="<c:if test="${pr.isActive()}">button-confirmed</c:if><c:if test="${!pr.isActive()}">button-unconfirmed</c:if>"
                            onclick="toggleConfirmed('${pr.getId()}', '${pr.isActive()}')">
                        <c:if test="${pr.isActive()}">Confirmed</c:if>
                        <c:if test="${!pr.isActive()}">Unconfirmed</c:if>
                    </button>
                </td>
                <td>
                    <button class="btn edit" onclick="editProduct(${pr.getId()}, '${pr.getName()}','${pr.getDescription()}',${pr.getPrice()},${pr.getCategory().getId()},'${pr.getCategory().getName()}')">Edit</button>
                    <button class="btn delete" onclick="deleteProduct(${pr.getId()})">Delete</button>
                </td>
                <td>
                    <div class="card-image">
                        <img src="/download?id=${pr.getProductImages().getId()}" alt="${pr.getName()}">
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
    <button class="btn" onclick="showAddCProductModal()">Add Category</button>
</div>
    <div class="container">
        <h1>Combo</h1>
        <table>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>description</th>
                <th>price</th>
                <th>category</th>
                <th>created At</th>
                <th>isActive</th>
                <th>doBlock</th>
                <th>Action</th>
                <th>Image</th>
            </tr>
            <c:forEach items="${combos}" var="cm">
                <tr>
                    <td><c:out value="${cm.getId()}"/></td>
                    <td><c:out value="${cm.getName()}"/></td>
                    <td><c:out value="${cm.getDescription()}"/></td>
                    <td><c:out value="${cm.getPrice()}"/></td>
                    <td><c:out value="${cm.getCategory().getName()}"/></td>
                    <td><c:out value="${cm.getCreatedAt()}"/></td>
                    <td><c:out value="${cm.isActive()}"/></td>
                    <td>
                        <button
                                class="<c:if test="${cm.isActive()}">button-confirmed</c:if><c:if test="${!cm.isActive()}">button-unconfirmed</c:if>"
                                onclick="toggleConfirmed('${cm.getId()}', '${cm.isActive()}')">
                            <c:if test="${cm.isActive()}">Confirmed</c:if>
                            <c:if test="${!cm.isActive()}">Unconfirmed</c:if>
                        </button>
                    </td>
                    <td>
                        <button class="btn edit" onclick="editProduct(${cm.getId()}, '${cm.getName()}','${cm.getDescription()}',${cm.getPrice()},${cm.getCategory().getId()},'${cm.getCategory().getName()}')">Edit</button>
                        <button class="btn delete" onclick="deleteProduct(${cm.getId()})">Delete</button>
                    </td>
                    <td class="card-image">
                            <img src="/download?id=${cm.getProductImages().getId()}" alt="${cm.getName()}">
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id="categoryModal" class="modal">
        <div class="modal-content">
            <h2 id="modalTitle">Add Product</h2>
            <div class="form-group">
                <label for="productName">Product Name</label>
                <input type="text" id="productName" required>
                <label for="productDescription">Product Description</label>
                <input type="text" id="productDescription" required>
                <label for="productPrice">Product Price</label>
                <input type="text" id="productPrice" required>
                <% CategoryRepository categoryRepository = CategoryRepository.getInstance();
                    List<Category> all = categoryRepository.getAll(); %>
                <div class="form-group">
                    <label for="productCategory">Product Category</label>
                    <div class="select-wrapper">
                        <select id="productCategory" required>
                            <option class="productCategory" value="" selected disabled></option>
                            <% for (Category category : all) {%>
                            <option value="<%= category.getId() %>"><%= category.getName() + " >> id:"+ category.getId() %></option>
                            <% } %>
                        </select>
                    </div>
                </div>

                <input type="hidden" id="productId">
            </div>
            <button class="btn" onclick="saveCategory()">Save</button>
            <button class="btn delete" onclick="closeModal()">Cancel</button>
        </div>
    </div>
</div>



<script>

    function showAddCProductModal() {
        document.getElementById('modalTitle').innerText = 'Add Product';
        document.getElementById('productName').value = '';
        document.getElementById('productDescription').value = '';
        document.getElementById('productPrice').value = '';
        document.getElementById('productCategory').value = '';
        document.getElementsByClassName('productCategory').innerText = 'choose category: ';
        document.getElementById('categoryModal').style.display = 'block';
    }

    function editProduct(id, name,description,price,categoryId,categoryName) {
        document.getElementById('modalTitle').innerText = 'Edit Product';
        document.getElementById('productName').value = name;
        document.getElementById('productDescription').value = description;
        document.getElementById('productPrice').value = price;
        document.getElementById('productCategory').value = categoryId;
        document.getElementsByClassName('productCategory').innerText =categoryName;
        document.getElementById('productId').value = id;
        document.getElementById('categoryModal').style.display = 'block';
    }

    function saveCategory() {
        const productId = document.getElementById('productId').value; // Hidden field for category ID
        const productName = document.getElementById('productName').value;
        const productDescription = document.getElementById('productDescription').value;
        const productPrice = document.getElementById('productPrice').value;
        const productCategory = document.getElementById('productCategory').value;

        if (productName.trim() === '') {
            alert('Product name cannot be empty!');
            return;
        }

        const xhr = new XMLHttpRequest();
        xhr.open('POST', '/admin/saveProduct', true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                alert('Product saved successfully!');
                location.reload(); // Reload the page to update the category list
            }
        };

        xhr.send('id=' + encodeURIComponent(productId) +
            '&name=' + encodeURIComponent(productName) +
            '&description=' +encodeURIComponent(productDescription) +
            '&prise=' +encodeURIComponent(productPrice) +
            '&category=' +encodeURIComponent(productCategory)
        );
        closeModal();
    }

    function closeModal() {
        document.getElementById('categoryModal').style.display = 'none';
    }
    function deleteProduct(productId) {
        if (confirm("Are you sure you want to delete this product?")) {
            const xhr = new XMLHttpRequest();
            xhr.open('POST', '/admin/deleteProduct', true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    alert('Product deleted successfully!');
                    location.reload(); // Reload the page to update the category list
                }
            };

            xhr.send('id=' + encodeURIComponent(productId));
        }
    }
    function toggleConfirmed(productId, currentStatus) {
        const newStatus = currentStatus === 'true' ? 'false' : 'true';
        $.ajax({
            type: 'POST',
            url: '/ToggleConfirmedServlet',
            data: {
                id: productId,
                newStatus: newStatus
            },
            success: function() {
                location.reload(); // Reload the page to reflect changes
            },
            error: function(xhr, status, error) {
                console.error('Error updating confirmation status:', xhr.status, xhr.statusText);
                alert('Failed to update confirmation status.');
            }
        });
    }

    $(document).ready(function() {
        $('#productCategory').select2({
            placeholder: "Choose a category",
            allowClear: true
        });
    });

</script>
</body>
</html>
