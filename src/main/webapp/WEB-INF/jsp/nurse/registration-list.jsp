<%-- 
    Document   : registration-list
    Created on : Aug 8, 2022, 2:04:59 PM
    Author     : Thanh_Tam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<br><br>
<h1 class="text-danger text-center">Medical Registration List</h1>
<br><br>

<div class="container mt-3">   
        <table class="table table-striped">
                <thead>
                        <tr>
                                <th>ID</th>
                                <th>Patient Name</th>
                                <th>Date of the examination</th>
                                <th>Email</th>
                                <th>Phone Number</th>
                                <th>Disease symptoms</th>
                                <th>Verified</th>
                        </tr>
                </thead>
                <tbody>
                        <c:forEach var="m" items="${medicalRegisters}">
                                <tr>
                                        <td>${m.id}</td>
                                        <td>${m.patientName}</td>
                                        <td>${m.dateOfExamination}</td>
                                        <td>${m.email}</td>
                                        <td>${m.phoneNumber}</td>
                                        <td>${m.healthIssues}</td>
                                        <td id="medicalRegister-${m.id}">
                                                <c:url  value="/verified-medical-register/${m.id}" var="endpoint" />
                                                <c:choose>
                                                        <c:when test="${m.isVerified == false}">
                                                                <button type="button" class="btn btn-danger" onclick="confirmMedicalRegister('${endpoint}', '${m.isVerified}')">Unverified</button>
                                                        </c:when>    
                                                        <c:otherwise>
                                                                <button type="button" class="btn btn-success" onclick="confirmMedicalRegister('${endpoint}', '${m.isVerified}')">Verified</button>
                                                        </c:otherwise>
                                                </c:choose>
                                        </td>
                                </tr>
                        </c:forEach>

                </tbody>
        </table>
</div>