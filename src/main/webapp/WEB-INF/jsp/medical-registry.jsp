<%-- 
    Document   : medical-registry
    Created on : Aug 2, 2022, 10:17:08 AM
    Author     : Thanh_Tam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>



<form:form method="post"  modelAttribute="medical-regiter">
        <div class="form-group">
                <label for="patientName">Your name</label>
                <form:input type="text" id="patientName" path="patientName" class="form-control" />
        </div>
        <div class="form-group">
                <label for="fullName">Email</label>
                <form:input type="text" id="email" path="email" class="form-control" />
        </div>
        <div class="form-group">
                <label for="fullName">Phone Number</label>
                <form:input type="text" id="phoneNumber" path="phoneNumber" class="form-control" />
        </div>
        <div class="form-group">
                <label for="fullName">Health issues</label>
                <form:input type="text" id="healthIssues" path="healthIssues" class="form-control" />
        </div>
        <div>
                <label for="examinationTime">Date of the examination</label>
                <form:input type="date" id="examinationTime" path="dateString" class="form-control" />
        </div>
        <br>
        <div class="form-group">
                <input type="submit" value="Medical Resistry" class="btn btn-danger" />
        </div>
</form:form>



<c:if test = "${limitMsg  != null}">
        <h3 class="text-danger">Đã vượt qua số lượng khám, vui lòng chọn ngày hẹn khác </h3>
</c:if>

