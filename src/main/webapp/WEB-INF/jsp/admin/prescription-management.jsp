<%-- 
    Document   : prescription-management
    Created on : Sep 1, 2022, 6:03:25 PM
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<br><br>
<h1 class="text-danger text-center">Quản lý toa thuốc</h1>
<br><br> 

<form method="post" id="prescriptionForm" enctype="multipart/form-data">
    <div class="form-floating">
        <select class="form-select" id="userPrescription" name="userPrescription">
            <c:forEach items="${users}" var="user">
                <option id="${user.id}" value="${user.id}">${user.id}-${user.username}</option>
            </c:forEach>
        </select>
        <label for="userPrescription" class="form-label">Mã bác sĩ</label>
    </div>
    <div class="form-floating">
        <select class="form-select" id="medicalCertificatePrescription" name="medicalCertificatePrescription">
            <c:forEach items="${medicalCertificates}" var="medicalCertificate">
                <option id="${medicalCertificate.id}" value="${medicalCertificate.id}">${medicalCertificate.id}</option>
            </c:forEach>
        </select>
        <label for="medicalCertificatePrescription" class="form-label">Mã phiếu khám</label>
    </div>
    <br/>
    <div style="display:flex; justify-content: center">
        <c:url var="addApi" value="/api/prescriptions"/>
        <input type="button" id="btnAddPrescription" onclick="addPrescription('${addApi}')" value="Thêm" class="btn btn-danger "/>
    </div>
    <br/>
</form>

<div id="mySpinner" style="display:flex; justify-content: center">
    <div class="spinner-border text-center"></div>
</div>
<table class="table table-hover">
    <thead class="text-center">
        <tr>
            <th>Mã toa thuốc</th>
            <th>Mã bác sĩ</th>
            <th>Mã phiếu khám</th>
            <th>Ngày tạo</th>
            <th></th>
        </tr>
    </thead>
    <tbody id="myPrescription" class="text-center">

    </tbody>
</table>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>
<script src="<c:url value="/js/admin.js"/>"></script>
<script>
    <c:url value="/api/prescriptions" var="u"/>
            window.onload = function () {
                getPrescriptions('${u}');
            }
</script>
