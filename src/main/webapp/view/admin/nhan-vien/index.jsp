<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<%--<%@ taglib prefix="f" uri="jakarta.tags.functions" %>--%>

<html>
<head>
    <title>Nhân Viên</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h2>Danh Sách Nhân Viên</h2>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Ma NV</th>
            <th>Tên NV</th>
            <th>Tên đăng nhập</th>
            <th>Mật khẩu</th>
            <th>Trạng Thái</th>
            <th colspan="2"> Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${nhanVienPageData.content}" varStatus="nhanVien">
            <tr>
                <td>${item.id}</td>
                <td>${item.ma}</td>
                <td>${item.ten}</td>
                <td>${item.tenDangNhap}</td>
                <td>${item.matKhau}</td>
                <td>
                    <c:if test="${not empty item.trangThai and item.trangThai != 0}">
                        ACTIVE
                    </c:if>
                    <c:if test="${empty item.trangThai or item.trangThai == 0}">
                        INACTIVE
                    </c:if>
                </td>
                <td>
                    <a href="/nhan-vien/delete/${item.id}" class="btn btn-danger">Delete</a>
                </td>
                <td>
                    <a href="/nhan-vien/edit/${item.id}" class="btn btn-warning">Update</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <li class="page-item">
                    <c:choose>
                        <c:when test="${nhanVienPageData.number > 0}">
                            <a class="page-link" href="/nhan-vien/index?page=${nhanVienPageData.number - 1}">Previous</a>
                        </c:when>
                        <c:otherwise>
                            <a class="page-link disabled" href="#">Previous</a>
                        </c:otherwise>
                    </c:choose>
                </li>
                <li class="page-item">
                    <a class="page-link disabled" href="#">${nhanVienPageData.number + 1 } of ${nhanVienPageData.totalPages}</a>
                </li>
                <li class="page-item">
                    <c:choose>
                        <c:when test="${nhanVienPageData.number < (nhanVienPageData.totalPages - 1)}">
                            <a class="page-link" href="/nhan-vien/index?page=${nhanVienPageData.number + 1}">Next</a>
                        </c:when>
                        <c:otherwise>
                            <a class="page-link disabled" href="#">Next</a>
                        </c:otherwise>
                    </c:choose>
                </li>
            </ul>
        </nav>
    </div>
    <button><a href="/nhan-vien/create">Add</a></button>
</div>

<!-- Sử dụng Bootstrap JS và Popper.js (cần thiết cho Bootstrap) -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</body>
</html>

</html>