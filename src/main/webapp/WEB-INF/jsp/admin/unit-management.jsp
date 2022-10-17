<%-- 
    Document   : unit-management
    Created on : Aug 31, 2022, 2:25:25 PM
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<br><br>
<h1 class="text-danger text-center">Quản lý đơn vị</h1>
<br><br> 

<form method="post" enctype="multipart/form-data">
    <div class="form-floating mb-3 mt-3">
        <input type="text" class="form-control" id="name-unit" placeholder="" name="name-unit"/>
        <label for="name-unit">Tên đơn vị</label>
    </div>
    <br/>
    <div style="display:flex; justify-content: center">
        <c:url var="addApi" value="/api/units"/>
        <input type="button" id="btnAddUnit" onclick="addUnit('${addApi}')" value="Thêm" class="btn btn-danger "/>
    </div>
    <br/>
</form>

<div id="mySpinner" style="display:flex; justify-content: center">
    <div class="spinner-border text-center"></div>
</div>
<table class="table table-hover">
    <thead class="text-center">
        <tr>
            <th>Mã đơn vị</th>
            <th>Tên đơn vị</th>
            <th></th>
        </tr>
    </thead>
    <tbody id="myUnit" class="text-center">

    </tbody>
</table>

<script src="<c:url value="/js/admin.js"/>"></script>
<script>
    <c:url value="/api/units" var="u"/>
            window.onload = function () {
                getUnits('${u}');
            }
</script>
