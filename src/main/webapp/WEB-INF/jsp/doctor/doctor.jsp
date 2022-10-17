<%-- 
    Document   : doctor
    Created on : Aug 8, 2022, 3:59:54 PM
    Author     : Thanh_Tam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<br>
<h1 class="text-danger text-center">DANH SÁCH BỆNH NHÂN KHÁM BỆNH HÔM NAY</h1>
<br><br>

<form class="d-flex">
        <input class="form-control me-2" type="text" placeholder="Search Patient" name="kw" />
        <input type="submit" class="btn btn-primary" value ="Search" />
</form>
<c:url value="/doctor/examine" var="examine" />
<div class="container mt-3">   
        <table class="table table-striped">
                <thead>
                        <tr>
                                <th>ID</th>
                                <th>Tên bệnh nhân</th>
                                <th>Số điện thoại</th>
                                <th>Triệu chung bệnh</th>
                        </tr>
                </thead>
                <tbody>
                        <c:forEach var="m" items="${medicalRegisters}">
                                <tr>
                                        <td>${m.id}</td>
                                        <td>${m.patientName}</td>
                                        <td>${m.phoneNumber}</td>
                                        <td>${m.healthIssues}</td>
                                        <td>
                                                <a class="btn btn-success" href="${examine}/${m.id}" >KHÁM</a>
                                        </td>
                                </tr>
                        </c:forEach>

                </tbody>
        </table>
</div>


