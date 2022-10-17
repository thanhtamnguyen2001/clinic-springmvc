<%-- 
    Document   : medical-certificate-update
    Created on : Sep 7, 2022, 4:57:54 PM
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<br><br>
<h1 class="text-danger text-center">Sửa quy tắc</h1>
<br><br> 

<form method="put" id="regulationForm" enctype="multipart/form-data">
    <div class="form-floating mb-3 mt-3">
        <input type="text" class="form-control" id="symptom" placeholder="" name="symptom" value="${medicalCertificate.symptom}"/>
        <label for="symptom">Triệu chứng</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <input type="text" class="form-control" id="conclusion" placeholder="" name="conclusion" value="${medicalCertificate.conclusion}"/>
        <label for="conclusion">Kết luận</label>
    </div>
    <div class="form-floating">
        <select class="form-select" id="medicalRegisterMC" name="medicalRegisterMC">
            <option hidden id="${medicalCertificate.medicalRegisterId.id}" value="${medicalCertificate.medicalRegisterId.id}">${medicalCertificate.medicalRegisterId.id}</option>
            <c:forEach items="${medicalRegisters}" var="medicalRegister">
                <option id="${medicalRegister.id}" value="${medicalRegister.id}">${medicalRegister.id}</option>
            </c:forEach>
        </select>
        <label for="medicalRegisterMC" class="form-label">Mã đăng ký khám</label>
    </div>
    <div class="form-floating">
        <select class="form-select" id="regulationMC" name="regulationMC">
            <option hidden id="${medicalCertificate.regulationId.id}" value="${medicalCertificate.regulationId.id}">${medicalCertificate.regulationId.id}</option>
            <c:forEach items="${regulations}" var="regulation">
                <option id="${regulation.id}" value="${regulation.id}">${regulation.id}</option>
            </c:forEach>
        </select>
        <label for="regulationMC" class="form-label">Mã quy tắc</label>
    </div>
    <br/>
    <div style="display:flex; justify-content: center">
        <c:url var="updateApi" value="/api/medical-certificates/${medicalCertificate.id}"/>
        <input type="button" id="btnEditMedicalCertificate" onclick="updateMedicalCertificate('${updateApi}')" value="Sửa" class="btn btn-danger "/>
    </div>
    <br/>
</form>
    
<script src="<c:url value="/js/admin.js"/>"></script>
