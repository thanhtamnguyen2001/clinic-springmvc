<%-- 
    Document   : regulation-update
    Created on : Sep 4, 2022, 4:12:15 PM
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<br><br>
<h1 class="text-danger text-center">Sửa quy tắc</h1>
<br><br> 

<form method="patch" id="regulationForm" enctype="multipart/form-data">
    <div class="form-floating mb-3 mt-3">
        <input type="number" class="form-control" id="patientQuantity" placeholder="" name="patientQuantity" value="${regulation.patientQuantity}"/>
        <label for="patientQuantity">Số lượng bệnh nhân trong ngày</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <input type="number" class="form-control" id="examinationPrice" placeholder="" name="examinationPrice" value="${regulation.examinationPrice}"/>
        <label for="examinationPrice">Tiền khám</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        Tình trạng:
        <input type="radio" name="active-regulation" value="${true}" ${regulation.active ? 'checked' : ''}/>Còn hạn
        <input type="radio" name="active-regulation" value="${false}" ${regulation.active ? '' : 'checked'}/>Hết hạn
    </div>
    <br/>
    <div style="display:flex; justify-content: center">
        <c:url var="updatePatchApi" value="/api/regulations/${regulation.id}"/>
        <input type="button" id="btnEditRegulation" onclick="updatePathRegulation('${updatePatchApi}')" value="Sửa" class="btn btn-danger "/>
    </div>
    <br/>
</form>
    
<script src="<c:url value="/js/admin.js"/>"></script>
