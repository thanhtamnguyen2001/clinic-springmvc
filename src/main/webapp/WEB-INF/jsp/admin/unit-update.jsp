<%-- 
    Document   : unit-update
    Created on : Aug 31, 2022, 6:44:34 PM
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<br><br>
<h1 class="text-danger text-center">Sửa đơn vị</h1>
<br><br> 

<form method="put" id="unitForm" enctype="multipart/form-data">
    <div class="form-floating mb-3 mt-3">
        <input type="text" class="form-control" id="name-unit" placeholder="" name="name-unit" value="${unit.unitName}"/>
        <label for="name-unit">Tên đơn vị</label>
    </div>
    <br/>
    <div style="display:flex; justify-content: center">
        <c:url var="updateApi" value="/api/units/${unit.id}"/>
        <input type="button" id="btnUpdateUnit" onclick="updateUnit('${updateApi}')" value="Sửa" class="btn btn-danger "/>
    </div>
    <br/>
</form>

<script src="<c:url value="/js/admin.js"/>"></script>
