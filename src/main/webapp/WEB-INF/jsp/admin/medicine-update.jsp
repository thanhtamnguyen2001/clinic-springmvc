<%-- 
    Document   : medicine-update
    Created on : Aug 27, 2022, 11:18:36 AM
    Author     : Lenovo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<br><br>
<h1 class="text-danger text-center">Sửa thuốc</h1>
<br><br> 

<form method="put" id="medicineForm" enctype="multipart/form-data">
    <div class="form-floating mb-3 mt-3">
        <input type="text" class="form-control" id="name-medicine" placeholder="" name="name-medicine" value="${medicine.medicineName}"/>
        <label for="name-medicine">Tên thuốc</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <input type="text" class="form-control" id="howtouse-medicine" placeholder="" name="howtouse-medicine" value="${medicine.howToUse}"/>
        <label for="howtouse-medicine">Cách dùng</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <input type="number" class="form-control" id="price-medicine" placeholder="" name="price-medicine" value="${medicine.medicinePrice}"/>
        <label for="price-medicine">Đơn giá</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <input type="number" class="form-control" id="qunatity-medicine" placeholder="" name="quantity-medicine" value="${medicine.medicineQuantity}"/>
        <label for="qunatity-medicine">Số lượng</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        Tình trạng:
        <input type="radio" name="active-medicine" value="${true}" ${medicine.active ? 'checked' : ''}/>Còn hạn
        <input type="radio" name="active-medicine" value="${false}" ${medicine.active ? '' : 'checked'}/>Hết hạn
    </div>
        <div class="form-floating">
        <select class="form-select" id="unitMedicine" name="unit-medicine">
            <option hidden id="${medicine.unitId.id}" value="${medicine.unitId.id}">${medicine.unitId.unitName}</option>
            <c:forEach items="${units}" var="unit">
                <option id="${unit.id}" value="${unit.id}">${unit.unitName}</option>
            </c:forEach>
        </select>
        <label for="unit-medicine" class="form-label">Đơn vị</label>
    </div>
    <br/>
    <div style="display:flex; justify-content: center">
        <c:url var="updateApi" value="/api/medicines/${medicine.id}"/>
        <input type="button" id="btnUpdateMedicine" onclick="updateMedicine('${updateApi}')" value="Sửa" class="btn btn-danger "/>
    </div>
    <br/>
</form>

<script src="<c:url value="/js/admin.js"/>"></script>
<!--<script>
    document.getElementById('btnUpdateMedicine').click();
</script>-->