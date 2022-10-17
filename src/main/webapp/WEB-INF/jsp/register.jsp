<%-- 
    Document   : register
    Created on : Aug 12, 2022, 3:56:55 PM
    Author     : Thanh_Tam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<c:url value="/register" var="action" />

<c:if test="${errMsg != null}">
        <div class="alert alert-danger">
                ${errMsg}
        </div>
</c:if>

<h1 class="text-center text-danger">DANG KY</h1>

<form:form method="post" action="${action}" modelAttribute="user" enctype="multipart/form-data">
        <div class="form-group">
                <label for="username">User name</label>
                <form:input type="text"  id="username" class="form-control" path="username"/>
        </div>
        <div class="form-group">
                <label for="password">Password</label>
                <form:input type="password"  id="password" class="form-control" path="password"/>
        </div>
        <div class="form-group">
                <label for="confirmPassword">Confirm Password</label>
                <form:input type="password"  id="confirmPassword" class="form-control" path="confirmPassword"/>
        </div>
        <div class="form-group">
                <label for="firstName">First name</label>
                <form:input type="text"  id="firstName" class="form-control" path="firstName"/>
        </div>
        <div class="form-group">
                <label for="lastName">Last name</label>
                <form:input type="text"  id="lastName" class="form-control" path="lastName"/>
        </div>
        <div class="form-group">
                <label for="phoneNumber">Phone number </label>
                <form:input type="text"  id="phoneNumber" class="form-control" path="phoneNumber"/>
        </div>
        <div class="form-group">
                <label for="email">email </label>
                <form:input type="text"  id="email" class="form-control" path="email"/>
        </div>
        <div class="form-group">
                <label for="image">Avatar</label>
                <form:input type="file" accept="image/*" id="image" class="form-control" path="image"/>
        </div>
        <div class="form-group">
                <label for="sex">Gioi tinh </label>
                <form:input type="text"  id="sex" class="form-control" path="sex"/>
        </div>
        <!--
        
        
<div class="form-group">
        <label for="identifier">CMND </label>
        <form:input type="text"  id="identifier" class="form-control" path="identifier"/>
</div>
        -->

        <br><br>
        <div class="form-group">
                <input type="submit" value="DANG KI" class="btn btn-info" />
        </div>
</form:form>