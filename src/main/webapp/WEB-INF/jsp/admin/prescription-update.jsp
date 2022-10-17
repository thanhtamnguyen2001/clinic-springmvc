<%-- 
    Document   : prescription-update
    Created on : Sep 3, 2022, 9:23:00 PM
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<br><br>
<h1 class="text-danger text-center">Quản lý toa thuốc</h1>
<br><br> 

<form method="patch" id="prescriptionForm" enctype="multipart/form-data">
    <div class="form-floating">
        <select class="form-select" id="userPrescription" name="userPrescription">
            <option hidden id="${prescription.userId.id}" value="${prescription.userId.id}">${prescription.userId.id}-${prescription.userId.username}</option>
            <c:forEach items="${users}" var="user">
                <option id="${user.id}" value="${user.id}">${user.id}-${user.username}</option>
            </c:forEach>
        </select>
        <label for="userPrescription" class="form-label">Mã bác sĩ</label>
    </div>
    <div class="form-floating">
        <select class="form-select" id="medicalCertificatePrescription" name="medicalCertificatePrescription">
            <option hidden id="${prescription.medicalCertificateId.id}" value="${prescription.medicalCertificateId.id}">${prescription.medicalCertificateId.id}</option>
            <c:forEach items="${medicalCertificates}" var="medicalCertificate">
                <option id="${medicalCertificate.id}" value="${medicalCertificate.id}">${medicalCertificate.id}</option>
            </c:forEach>
        </select>
        <label for="medicalCertificatePrescription" class="form-label">Mã phiếu khám</label>
    </div>
    <br/>
    <div style="display:flex; justify-content: center">
        <c:url var="updatePatchApi" value="/api/prescriptions/${prescription.id}"/>
        <input type="button" id="btnEditPrescription" onclick="updatePatchPrescription('${updatePatchApi}')" value="Sửa" class="btn btn-danger "/>
    </div>
    <br/>
</form>
    
<script src="<c:url value="/js/admin.js"/>"></script>
