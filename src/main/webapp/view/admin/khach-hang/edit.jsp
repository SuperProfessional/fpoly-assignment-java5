<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<%--<%@ taglib prefix="f" uri="jakarta.tags.functions" %>--%>

<html>
<head>
    <title>Thêm mới khách hàng</title>
    <!-- Đưa các thư viện CSS và JavaScript Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <h1>Thêm mới khách hàng</h1>

    <f:form method="post" modelAttribute="khachHang">
        <div class="form-group">
            <label for="id">ID:</label>
            <f:input path="id" id="id" class="form-control" required="true" readonly="true"/>
            <f:errors path="id" cssClass="error" />
        </div>
        <div class="form-group">
            <label for="ma">Mã khách hàng:</label>
            <f:input path="ma" id="ma" class="form-control" required="true" />
            <f:errors path="ma" cssClass="error" />
        </div>

        <div class="form-group">
            <label for="ten">Tên:</label>
            <f:input path="ten" id="ten" class="form-control" required="true" />
            <f:errors path="ten" cssClass="error" />
        </div>

        <div class="form-group">
            <label for="sdt">Số điện thoại:</label>
            <f:input path="sdt" id="sdt" class="form-control" />
            <f:errors path="sdt" cssClass="error" />
        </div>

        <div class="form-group">
            <label for="trangThai">Trạng thái:</label>
            <f:select path="trangThai" id="trangThai" class="form-control">
                <f:option value="1">ACTIVE</f:option>
                <f:option value="0">INACTIVE</f:option>
            </f:select>
            <f:errors path="trangThai" cssClass="error" />
        </div>

        <button formaction="/khach-hang/update/${khachHang.id}" type="submit" class="btn btn-primary">Submit</button>
    </f:form>
</div>

</body>
</html>
