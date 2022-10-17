<%-- 
    Document   : medicine-management
    Created on : Aug 19, 2022, 1:04:38 PM
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<br><br>
<h1 class="text-danger text-center">Quản lý thuốc</h1>
<br><br>     

<c:url value="/admin/medicines" var="action"/>
<form:form method="post" action="${action}" modelAttribute="medicine" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="medicineName" class="form-control" id="name-medicine" placeholder="" name="name-medicine" />
        <label for="name-medicine">Tên thuốc</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="howToUse" class="form-control" id="howtouse-medicine" placeholder="" name="howtouse-medicine" />
        <label for="howtouse-medicine">Cách dùng</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="number" path="medicinePrice" class="form-control" id="price-medicine" placeholder="" name="price-medicine" />
        <label for="price-medicine">Đơn giá</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="medicineQuantity" class="form-control" id="qunatity-medicine" placeholder="" name="quantity-medicine" />
        <label for="qunatity-medicine">Số lượng</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        Tình trạng:
        <form:radiobutton path="active" value="${1}" checked="checked"/>Còn hạn
        <form:radiobutton path="active" value="${0}"/>Hết hạn
    </div>
    <div class="form-floating">
        <form:select path="unitId" class="form-select" id="unit-medicine" name="unit-medicine">
            <c:forEach items="${units}" var="unit">
                <option id="${unit.id}" value="${unit.id}">${unit.unitName}</option>
            </c:forEach>
        </form:select>
        <label for="unit-medicine" class="form-label">Đơn vị</label>
    </div>
    <br/>
    <div style="display:flex; justify-content: center">
        <input type="submit" value="Thêm quy tắc" class="btn btn-danger "/>
    </div>
    <br/>
</form:form>

<div id="mySpinner" style="display:flex; justify-content: center">
    <div class="spinner-border text-center"></div>
</div>
<table class="table table-hover">
    <thead class="text-center">
        <tr>
            <th>Mã thuốc</th>
            <th>Tên thuốc</th>
            <th>Cách dùng</th>
            <th>Đơn giá</th>
            <th>Số lượng</th>
            <th>Đơn vị</th>
            <th>Còn dùng</th>
            <th></th>
        </tr>
    </thead>
    <tbody id="myMedicine" class="text-center">

    </tbody>
</table>

<script src="<c:url value="/js/admin.js"/>"></script>
<script>
    <c:url value="/api/medicines" var="u"/>
    window.onload = function () {
        getMedicines('${u}');
    }
</script>
