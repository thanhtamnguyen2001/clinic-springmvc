<%-- 
    Document   : regulation-mannagement
    Created on : Sep 4, 2022, 2:20:31 PM
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<br><br>
<h1 class="text-danger text-center">Quản lý quy tắc</h1>
<br><br> 

<c:url value="/admin/regulations" var="action"/>
<form:form method="post" action="${action}" modelAttribute="regulation" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
    <div class="form-floating mb-3 mt-3">
        <form:input type="number" path="patientQuantity" class="form-control" id="patientQuantity" placeholder="" name="patientQuantity" />
        <label for="patientQuantity">Số lượng bệnh nhân trong ngày</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="number" path="examinationPrice" class="form-control" id="examinationPrice" placeholder="" name="examinationPrice" />
        <label for="examinationPrice">Tiền khám</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        Tình trạng:
        <form:radiobutton path="active" value="${1}" checked="checked"/>Còn hạn
        <form:radiobutton path="active" value="${0}"/>Hết hạn
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
            <th>Mã quy tắc</th>
            <th>Số lượng bệnh nhân trong ngày</th>
            <th>Tiền khám</th>
            <th>Tình trạng</th>
            <th>Ngày tạo</th>
            <th></th>
        </tr>
    </thead>
    <tbody id="myRegulation" class="text-center">

    </tbody>
</table>

<script src="<c:url value="/js/admin.js"/>"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>
<script>
    <c:url value="/api/regulations" var="u"/>
            window.onload = function () {
                getRegulations('${u}');
            }
</script>
