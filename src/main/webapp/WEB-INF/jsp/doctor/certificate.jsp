<%-- 
    Document   : create-prescription
    Created on : Aug 9, 2022, 8:20:13 AM
    Author     : Thanh_Tam
--%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">
        <br><br>
        <h1 class="text-center text-danger">Patient Information</h1>
        <br><br>

        <div id="patientRegister" class="container mt-3">   
                <table class="table table-striped">
                        <thead>
                                <tr>
                                        <th>ID</th>
                                        <th>TÊN BỆNH NHÂN</th>
                                        <th>TRIEU CHUNG</th>
                                        <th>SDT</th>
                                </tr>
                        </thead>
                        <tbody>
                                <tr>
                                        <td>${medicalRegister.id}</td>
                                        <td>${medicalRegister.patientName}</td>
                                        <td>${medicalRegister.healthIssues}</td>
                                        <td>${medicalRegister.phoneNumber}</td>
                                </tr>

                        </tbody>
                </table>
        </div>

        <c:url value="/doctor/create-certificate/${medicalRegister.id}" var="endpointCreateCertificate" />
        <c:url value="/doctor/get-certificate/${medicalRegister.id}" var="getEndpoint" />
        <c:url value="/doctor/create-prescription" var="endpointCreatePrescription" />
        <c:url value="/doctor" var="doctorEndpoint" />


        <form id="certificate" name="certificate"  method="post">
                <div class="mb-3 mt-3">
                        <label for="symptom" class="form-label">Trieu chung</label>
                        <input class="form-control" type="text" name="symptom">
                </div>
                <div class="mb-3 mt-3">
                        <label for="symptom" class="form-label">Ket luan</label>
                        <textarea  class="form-control" type="text" name="conclusion"></textarea>
                </div>

                <button id="submitCertificate" type="button" class="btn btn-primary" onclick="createCertificate('${endpointCreateCertificate}', '${doctorEndpoint}', '${pageContext.request.userPrincipal.name}')">Tạo phiếu khám</button>
        </form>


        <div id="showCertificate"></div>
        <br><br>
        <div>
                <div id="medicalHistory"></div>
                <div id="hideAndPresently"></div>
        </div>
        <div id="prescription"></div>
<div id="medicineForm"></div>
</div>


<br><br><br><br><br>
</div>