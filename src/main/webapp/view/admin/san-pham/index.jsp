<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<%--<%@ taglib prefix="f" uri="jakarta.tags.functions" %>--%>

<html>
<head>
    <title>Sản Phẩm</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h2>Danh Sách sản phẩm</h2>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Ma</th>
            <th>Tên</th>
            <th>Trạng Thái</th>
            <th colspan="3"> Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${sanPhamPageData.content}" varStatus="sanPham">
            <tr>
                <td>${item.id}</td>
                <td>${item.ma}</td>
                <td>${item.ten}</td>
                <td>
                    <c:if test="${not empty item.trangThai and item.trangThai != 0}">
                        ACTIVE
                    </c:if>
                    <c:if test="${empty item.trangThai or item.trangThai == 0}">
                        INACTIVE
                    </c:if>
                </td>
                <td>
                    <a href="/san-pham/delete/${item.id}" class="btn btn-danger">Delete</a>
                </td>
                <td>
                    <a href="/san-pham/edit/${item.id}" class="btn btn-warning">Update</a>
                </td>
                <td>
                    <a href="/san-pham-chi-tiet/index?sanPhamId=${item.id}" class="btn btn-warning">Detail</a>
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
                        <c:when test="${sanPhamPageData.number > 0}">
                            <a class="page-link" href="/san-pham/index?page=${sanPhamPageData.number - 1}">Previous</a>
                        </c:when>
                        <c:otherwise>
                            <a class="page-link disabled" href="#">Previous</a>
                        </c:otherwise>
                    </c:choose>
                </li>
                <li class="page-item">
                    <a class="page-link disabled" href="#">${sanPhamPageData.number + 1 } of ${sanPhamPageData.totalPages}</a>
                </li>
                <li class="page-item">
                    <c:choose>
                        <c:when test="${sanPhamPageData.number < (sanPhamPageData.totalPages - 1)}">
                            <a class="page-link" href="/san-pham/index?page=${sanPhamPageData.number + 1}">Next</a>
                        </c:when>
                        <c:otherwise>
                            <a class="page-link disabled" href="#">Next</a>
                        </c:otherwise>
                    </c:choose>
                </li>
            </ul>
        </nav>
    </div>
    <button><a href="/san-pham/create">Add</a></button>
</div>

<!-- Sử dụng Bootstrap JS và Popper.js (cần thiết cho Bootstrap) -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</body>
</html>

</html>