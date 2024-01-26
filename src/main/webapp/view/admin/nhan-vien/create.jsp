<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<%--<%@ taglib prefix="f" uri="jakarta.tags.functions" %>--%>

<html>
<head>
    <title>Nhân viên</title>
    <!-- Đưa các thư viện CSS và JavaScript Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>

<div class="container">
    <h1>Thêm mới nhân viên</h1>

    <f:form method="post" modelAttribute="nhanVien" action="/nhan-vien/store" >
        <div class="form-group">
            <label for="id">ID:</label>
            <f:input path="id" id="id" name = "id" class="form-control" readonly="true"/>
            <f:errors path="id" cssClass="error" />
        </div>

        <div class="form-group">
            <label for="ma">Mã nhân viên:</label>
            <f:input path="ma" id="ma" class="form-control"  />
            <f:errors path="ma" cssClass="error" />
        </div>

        <div class="form-group">
            <label for="ten">Tên:</label>
            <f:input path="ten" id="ten" class="form-control" required="true" />
            <f:errors path="ten" cssClass="error" />
        </div>

        <div class="form-group">
            <label for="tenDangNhap">Tên đăng nhập :</label>
            <f:input path="tenDangNhap" id="tenDangNhap" class="form-control" required="true" />
            <f:errors path="tenDangNhap" cssClass="error" />
        </div>

        <div class="form-group">
            <label for="matKhau">Mật khẩu :</label>
            <f:password path="matKhau" id="matKhau" class="form-control" required="true" />
            <f:errors path="matKhau" cssClass="error" />
        </div>

        <div class="form-group">
            <label for="trangThai">Trạng thái :</label>
            <f:select path="trangThai" id="trangThai" class="form-control">
                <f:option value="1">ACTIVE</f:option>
                <f:option value="0">INACTIVE</f:option>
            </f:select>
            <f:errors path="trangThai" cssClass="error" />
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </f:form>
</div>

</body>
</html>
