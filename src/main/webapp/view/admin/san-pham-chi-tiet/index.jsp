<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<%--<%@ taglib prefix="f" uri="jakarta.tags.functions" %>--%>

<html>
<head>
    <title>Chi Tiết Sản Phẩm</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

<div class="container-fluid">
    <h2>Chi Tiết Sản Phẩm</h2>
    <div class="row">
        <div class="col-sm-9">
            <table class="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Màu Sắc</th>
                    <th>Kích Thước</th>
                    <th>Mã Sản Phẩm Chi Tiết</th>
                    <th>Số Lượng</th>
                    <th>Đơn Giá</th>
                    <th>Trạng Thái</th>
                    <th colspan="2">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${sanPhamChiTietPageData.content}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.mauSac.ma} - ${item.mauSac.ten}</td>
                        <td>${item.kichThuoc.ma} - ${item.kichThuoc.ten}</td>
                        <td>${item.maSPCT}</td>
                        <td>${item.soLuong}</td>
                        <td>${item.donGia}</td>
                        <td>
                            <c:if test="${not empty item.trangThai and item.trangThai != 0}">
                                ACTIVE
                            </c:if>
                            <c:if test="${empty item.trangThai or item.trangThai == 0}">
                                INACTIVE
                            </c:if>
                        </td>
                        <td>
                            <a href="/san-pham-chi-tiet/delete/${item.id}" class="btn btn-danger">Delete</a>
                        </td>
                        <td>
                            <a href="/san-pham-chi-tiet/edit/${item.id}?sanPhamId=${sanPham.id}" class="btn btn-warning">Update</a>
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
                                <c:when test="${sanPhamChiTietPageData.number > 0}">
                                    <a class="page-link" href="/san-pham-chi-tiet/index?sanPhamId=${sanPham.id}&page=${sanPhamChiTietPageData.number - 1}">Previous</a>
                                </c:when>
                                <c:otherwise>
                                    <a class="page-link disabled" href="#">Previous</a>
                                </c:otherwise>
                            </c:choose>
                        </li>
                        <li class="page-item">
                            <a class="page-link disabled" href="#">${sanPhamChiTietPageData.number + 1 } of ${sanPhamChiTietPageData.totalPages}</a>
                        </li>
                        <li class="page-item">
                            <c:choose>
                                <c:when test="${sanPhamChiTietPageData.number < (sanPhamChiTietPageData.totalPages - 1)}">
                                    <a class="page-link" href="/san-pham-chi-tiet/index?sanPhamId=${sanPham.id}&page=${sanPhamChiTietPageData.number + 1}">Next</a>
                                </c:when>
                                <c:otherwise>
                                    <a class="page-link disabled" href="#">Next</a>
                                </c:otherwise>
                            </c:choose>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <div class="col-sm-3">
            <h3>Sản Phẩm</h3>
            <p><strong>ID: </strong>${sanPham.id}</p>
            <p><strong>Mã: </strong>${sanPham.ma}</p>
            <p><strong>Tên: </strong>${sanPham.ten}</p>
            <p>
                <strong>Trạng Thái: </strong>
                <c:if test="${not empty sanPham.trangThai and sanPham.trangThai != 0}">
                    ACTIVE
                </c:if>
                <c:if test="${empty sanPham.trangThai or sanPham.trangThai == 0}">
                    INACTIVE
                </c:if>
            </p>
        </div>
    </div>
    <button><a href="/san-pham-chi-tiet/create?sanPhamId=${sanPham.id}">Add</a></button>
</div>

<!-- Sử dụng Bootstrap JS và Popper.js (cần thiết cho Bootstrap) -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</body>
</html>
