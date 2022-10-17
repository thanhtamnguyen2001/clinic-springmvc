<%-- 
    Document   : prescription-detail
    Created on : Sep 3, 2022, 11:19:05 PM
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<br><br>
<h1 class="text-danger text-center">Chi tiết toa thuốc</h1>
<br><br> 

<form method="post" id="prescriptionDetailForm" enctype="multipart/form-data">
    <div class="form-floating">
        <select class="form-select" id="prescriptionIdPrescriptionDetail" name="prescriptionIdPrescriptionDetail">
            <c:forEach items="${prescriptions}" var="prescription">
                <option id="${prescription.id}" value="${prescription.id}">${prescription.id}</option>
            </c:forEach>
        </select>
        <label for="prescriptionIdPrescriptionDetail" class="form-label">Mã toa thuốc</label>
    </div>
    <div class="form-floating">
        <select class="form-select" id="medicineIdPrescriptionDetail" name="medicineIdPrescriptionDetail">
            <c:forEach items="${medicines}" var="medicine">
                <option id="${medicine.id}" value="${medicine.id}">${medicine.id}</option>
            </c:forEach>
        </select>
        <label for="medicineIdPrescriptionDetail" class="form-label">Mã thuốc</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <input type="number" class="form-control" id="medicineQuantityPrescriptionDetail" placeholder="" name="medicineQuantityPrescriptionDetail"/>
        <label for="medicineQuantityPrescriptionDetail">Số lượng thuốc</label>
    </div>
    <br/>
    <div style="display:flex; justify-content: center">
        <c:url var="addApi" value="/api/prescriptiondetails"/>
        <input type="button" id="btnAddPrescriptionDetail" onclick="addPrescriptionDetail('${addApi}')" value="Thêm" class="btn btn-danger "/>
    </div>
    <br/>
</form>

<div id="mySpinner" style="display:flex; justify-content: center">
    <div class="spinner-border text-center"></div>
</div>
<table class="table table-hover">
    <thead class="text-center">
        <tr>
            <th>Mã chi tiết toa</th>
            <th>Mã toa thuốc</th>
            <th>Mã thuốc</th>
            <th>Số lượng thuốc</th>
            <th></th>
        </tr>
    </thead>
    <tbody id="myPrescriptionDetail" class="text-center">

    </tbody>
</table>

<script src="<c:url value="/js/admin.js"/>"></script>
<script>
    <c:url value="/api/prescriptiondetails" var="u"/>
            window.onload = function () {
                getPrescriptionDetails('${u}');
            }
</script>
