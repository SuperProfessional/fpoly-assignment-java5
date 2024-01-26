<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<%--<%@ taglib prefix="f" uri="jakarta.tags.functions" %>--%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sản Phẩm Chi Tiết</title>
    <!-- Thêm các thư viện Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-sm-9">
            <f:form action="/san-pham-chi-tiet/store" method="post" modelAttribute="sanPhamChiTiet">
                <div class="form-group">
                    <label for="id">ID:</label>
                    <f:input type="text" class="form-control" id="id" name="id" path="id" readonly="true"/>
                    <f:errors path="id" cssStyle="color: red"/>
                </div>
                <div class="form-group">
                    <label>ID Màu sắc:</label>
                    <f:input type="number" class="form-control" id="idMauSac" name="idMauSac" path="idMauSac"/>
                        <%--                    <f:select path="idMauSac">--%>
                        <%--                        <f:option value="${mauSacList[0].id}">${mauSacList[0].ten}</f:option>--%>
                        <%--                        <f:options items="${mauSacList}" itemValue="id" itemLabel="ten" ></f:options>--%>
                        <%--                    </f:select><br>--%>
                </div>
                <div class="form-group">
                    <label>ID Kích thước:</label>
                    <f:input type="number" class="form-control" id="idKichThuoc" name="idKichThuoc" path="idKichThuoc"/>
                        <%--                    <f:select path="idKichThuoc">--%>
                        <%--                        <f:option value="${kichThuocList[0].id}">${kichThuocList[0].ten}</f:option>--%>
                        <%--                        <f:options items="${kichThuocList}" itemValue="id" itemLabel="ten" ></f:options>--%>
                        <%--                    </f:select><br>--%>
                </div>
                <div class="form-group">
                    <label for="id">ID Sản Phẩm:</label>
                    <f:input type="text" class="form-control" id="idSanPham" name="idSanPham" path="idSanPham"
                             readonly="true"/>
                    <f:errors path="idSanPham" cssStyle="color: red"/>
                </div>
                <div class="form-group">
                    <label for="maSPCT">Mã SPCT:</label>
                    <f:input type="text" class="form-control" id="maSPCT" name="maSPCT" path="maSPCT"/>
                    <f:errors path="maSPCT" cssStyle="color: red"/>
                </div>
                <div class="form-group">
                    <label for="soLuong">Số lượng:</label>
                    <f:input type="number" class="form-control" id="soLuong" name="soLuong" path="soLuong"/>
                    <f:errors path="soLuong" cssStyle="color: red"/>
                </div>
                <div class="form-group">
                    <label for="donGia">Đơn giá:</label>
                    <f:input type="text" class="form-control" id="donGia" name="donGia" path="donGia"/>
                    <f:errors path="donGia" cssStyle="color: red"/>
                </div>
                <div class="form-group">
                    <label for="trangThai">Trạng Thái:</label>
                    <f:select path="trangThai" id="trangThai" name="trangThai" class="form-control">
                        <f:option value="1">ACTIVE</f:option>
                        <f:option value="0">INACTIVE</f:option>
                    </f:select>
                    <f:errors path="trangThai" cssStyle="color: red"/>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </f:form>
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
</div>

<!-- Thêm các thư viện Bootstrap JavaScript -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
