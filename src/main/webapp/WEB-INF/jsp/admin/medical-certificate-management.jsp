<%-- 
    Document   : medical-certificate-management
    Created on : Sep 7, 2022, 4:57:17 PM
    Author     : Lenovo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<br><br>
<h1 class="text-danger text-center">Quản lý phiếu khám</h1>
<br><br>  

<c:url value="/admin/medical-certificates" var="action"/>
<form:form method="post" action="${action}" modelAttribute="medicalCertificate" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="symptom" class="form-control" id="symptom" placeholder="" name="symptom" />
        <label for="symptom">Triệu chứng</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="conclusion" class="form-control" id="conclusion" placeholder="" name="conclusion" />
        <label for="conclusion">Kết luận</label>
    </div>
    <div class="form-floating">
        <form:select path="medicalRegisterId" class="form-select" id="medicalRegisterId" name="medicalRegisterId">
            <c:forEach items="${medicalRegisters}" var="medicalRegister">
                <option id="${medicalRegister.id}" value="${medicalRegister.id}">${medicalRegister.id}</option>
            </c:forEach>
        </form:select>
        <label for="medicalRegisterId" class="form-label">Mã đăng ký khám</label>
    </div>
    <div class="form-floating">
        <form:select path="regulationId" class="form-select" id="regulationId" name="regulationId">
            <c:forEach items="${regulations}" var="regulation">
                <option id="${regulation.id}" value="${regulation.id}">${regulation.id}</option>
            </c:forEach>
        </form:select>
        <label for="regulationId" class="form-label">Mã quy tắc</label>
    </div>
    <br/>
    <div style="display:flex; justify-content: center">
        <input type="submit" value="Thêm phiếu khám" class="btn btn-danger "/>
    </div>
    <br/>
</form:form>

<div id="mySpinner" style="display:flex; justify-content: center">
    <div class="spinner-border text-center"></div>
</div>
<table class="table table-hover">
    <thead class="text-center">
        <tr>
            <th>Mã phiếu khám</th>
            <th>Ngày khám</th>
            <th>Triệu chứng</th>
            <th>Kết luận</th>
            <th>Mã đăng ký khám</th>
            <th>Mã quy tắc</th>
        </tr>
    </thead>
    <tbody id="myMedicalCertificate" class="text-center">

    </tbody>
</table>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>
<script src="<c:url value="/js/admin.js"/>"></script>
<script>
    <c:url value="/api/medical-certificates" var="u"/>
    window.onload = function () {
        getMedicalCertificates('${u}');
    }
</script>