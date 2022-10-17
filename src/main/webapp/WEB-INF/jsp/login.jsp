<%-- 
    Document   : login
    Created on : Aug 12, 2022, 9:47:25 AM
    Author     : Thanh_Tam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<c:url value="/login" var="action" />

<c:if test="${param.error != null}">
        <div class="alert alert-danger">
                Ten dang nhap hoac mat khau khong dung
        </div>
</c:if>

<c:if test="${param.accessDenied != null}">
        <div class="alert alert-danger">
                Ban khong  co quyen truy cap
        </div>
</c:if>

<h1 class="text-center text-danger">DANG NHAP</h1>

<form method="post" action="${action}">
        <div class="form-group">
                <label for="username">User name</label>
                <input type="text"  name="username" class="form-control"/>
        </div>
        <div class="form-group">
                <label for="password">Password</label>
                <input type="password" name="password" class="form-control"/>
        </div>
        <br><br>
        <div class="form-group">
                <input type="submit" value="DANG NHAP" class="btn btn-info" />
        </div>
</form>