<%-- 
    Document   : disease-management
    Created on : Sep 4, 2022, 6:16:54 PM
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<br><br>
<h1 class="text-danger text-center">Quản lý bệnh</h1>
<br><br>  

<c:url value="/admin/diseases" var="action"/>
<form:form method="post" action="${action}" modelAttribute="disease" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="diseaseName" class="form-control" id="diseaseName" placeholder="" name="diseaseName" />
        <label for="diseaseName">Tên bệnh</label>
    </div>
    <br/>
    <div style="display:flex; justify-content: center">
        <input type="submit" value="Thêm bệnh" class="btn btn-danger "/>
    </div>
    <br/>
</form:form>

<div id="mySpinner" style="display:flex; justify-content: center">
    <div class="spinner-border text-center"></div>
</div>
<table class="table table-hover">
    <thead class="text-center">
        <tr>
            <th>Mã bệnh</th>
            <th>Tên bệnh</th>
            <th></th>
        </tr>
    </thead>
    <tbody id="myDisease" class="text-center">

    </tbody>
</table>

<script src="<c:url value="/js/admin.js"/>"></script>
<script>
    <c:url value="/api/diseases" var="u"/>
    window.onload = function () {
        getDiseases('${u}');
    }
</script>
