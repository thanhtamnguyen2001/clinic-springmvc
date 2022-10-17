<%-- 
    Document   : prescription-detail-update
    Created on : Sep 4, 2022, 11:09:00 AM
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<br><br>
<h1 class="text-danger text-center">Quản lý toa thuốc</h1>
<br><br> 

<form method="put" id="prescriptionDetailEditForm" enctype="multipart/form-data">
    <div class="form-floating">
        <select class="form-select" id="prescriptionIdPrescriptionDetail" name="prescriptionIdPrescriptionDetail">
            <option hidden id="${prescriptionDetail.prescriptionId.id}" value="${prescriptionDetail.prescriptionId.id}">${prescriptionDetail.prescriptionId.id}</option>
            <c:forEach items="${prescriptions}" var="prescription">
                <option id="${prescription.id}" value="${prescription.id}">${prescription.id}</option>
            </c:forEach>
        </select>
        <label for="prescriptionIdPrescriptionDetail" class="form-label">Mã toa thuốc</label>
    </div>
    <div class="form-floating">
        <select class="form-select" id="medicineIdPrescriptionDetail" name="medicineIdPrescriptionDetail">
            <option hidden id="${prescriptionDetail.medicineId.id}" value="${prescriptionDetail.medicineId.id}">${prescriptionDetail.medicineId.id}</option>
            <c:forEach items="${medicines}" var="medicine">
                <option id="${medicine.id}" value="${medicine.id}">${medicine.id}</option>
            </c:forEach>
        </select>
        <label for="medicineIdPrescriptionDetail" class="form-label">Mã thuốc</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <input type="number" class="form-control" id="medicineQuantityPrescriptionDetail" placeholder="" name="medicineQuantityPrescriptionDetail" value="${prescriptionDetail.medicineQuantity}"/>
        <label for="medicineQuantityPrescriptionDetail">Số lượng thuốc</label>
    </div>
    <br/>
    <div style="display:flex; justify-content: center">
        <c:url var="updateApi" value="/api/prescriptiondetails/${prescriptionDetail.id}"/>
        <input type="button" id="btnEditPrescriptionDetail" onclick="updatePrescriptionDetail('${updateApi}')" value="Sửa" class="btn btn-danger "/>
    </div>
    <br/>
</form>

<script src="<c:url value="/js/admin.js"/>"></script>
