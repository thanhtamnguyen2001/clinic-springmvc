<%-- 
    Document   : medical-history
    Created on : Aug 16, 2022, 11:41:41 AM
    Author     : Thanh_Tam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<h1 class="text-danger text-center">Lịch sử khám bệnh</h1>

<c:url value="/" var="endpoint" />

<div id="root" ></div>

<script onload="getMedicalHistory('${endpoint}')"  src="<c:url value="/js/patient.js" />"></script>