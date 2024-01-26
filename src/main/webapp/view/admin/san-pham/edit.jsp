<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<%--<%@ taglib prefix="f" uri="jakarta.tags.functions" %>--%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sản Phẩm</title>
    <!-- Thêm các thư viện Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <f:form method="post" modelAttribute="sanPham">
        <div class="form-group">
            <label for="id">ID:</label>
            <f:input type="text" class="form-control" id="id" name="id" path="id" readonly="true"/>
            <f:errors path="id" cssStyle="color: red"/>
        </div>
        <div class="form-group">
            <label for="ma">Mã:</label>
            <f:input type="text" class="form-control" id="ma" name="ma" path="ma"/>
            <f:errors path="ma" cssStyle="color: red"/>
        </div>
        <div class="form-group">
            <label for="ten">Tên:</label>
            <f:input type="text" class="form-control" id="ten" name="ten" path="ten"/>
            <f:errors path="ten" cssStyle="color: red"/>
        </div>
        <div class="form-group">
            <label for="trangThai">Trạng Thái:</label>
            <f:select path="trangThai" id="trangThai" name="trangThai" class="form-control">
                <f:option value="1">ACTIVE</f:option>
                <f:option value="0">INACTIVE</f:option>
            </f:select>
            <f:errors path="trangThai" cssStyle="color: red"/>
        </div>
        <button formaction="/san-pham/update/${sanPham.id}" type="submit" class="btn btn-primary">Submit</button>
    </f:form>
</div>

<!-- Thêm các thư viện Bootstrap JavaScript -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
