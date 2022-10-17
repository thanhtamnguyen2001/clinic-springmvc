<%-- 
    Document   : disease-update
    Created on : Sep 4, 2022, 7:16:59 PM
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<br><br>
<h1 class="text-danger text-center">Sửa quy tắc</h1>
<br><br> 

<form method="put" id="regulationForm" enctype="multipart/form-data">
    <div class="form-floating mb-3 mt-3">
        <input type="text" class="form-control" id="diseaseName" placeholder="" name="diseaseName" value="${disease.diseaseName}"/>
        <label for="patientQuantity">Tên bệnh</label>
    </div>
    <br/>
    <div style="display:flex; justify-content: center">
        <c:url var="updateApi" value="/api/diseases/${disease.id}"/>
        <input type="button" id="btnEditDisease" onclick="updateDisease('${updateApi}')" value="Sửa" class="btn btn-danger "/>
    </div>
    <br/>
</form>
    
<script src="<c:url value="/js/admin.js"/>"></script>
