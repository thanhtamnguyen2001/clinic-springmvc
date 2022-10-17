<%-- 
    Document   : index
    Created on : Aug 1, 2022, 7:31:14 PM
    Author     : Thanh_Tam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<br>
<h1 class="text-center text-danger">This is home page</h1>
<br><br>

<c:if test = "${isSuccess  == true}">
        <h3 class="text-danger">Bạn đã đăng ký khám thành công! </h3>
</c:if>

<sec:authorize access="hasRole('ROLE_DOCTOR')">
        <a href="<c:url value="/doctor" />" class="btn btn-info">Toi trang bác sĩ</a>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_SUPERADMIN')">
        <h1 class="text-center text-info">This is supper admin page</h1>
        <a href="<c:url value="/super-admin" />" class="btn btn-info">Go to super admin page</a>
</sec:authorize>