<%-- 
    Document   : header
    Created on : Jul 26, 2022, 3:47:12 PM
    Author     : Thanh_Tam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ page import = "java.util.ResourceBundle" %>

<!-------------------------------- properties file variables --------------------------------->
<% ResourceBundle resource = ResourceBundle.getBundle("images");
        String logo = resource.getString("cloudinary.logo");
        String email = resource.getString("email");
        String phone = resource.getString("phone");
%>


<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
        <div class="container-fluid">
                <a class="navbar-brand" href="<c:url value="/ " />"><img src="<%=logo%>" width="40"  />Home  </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                        <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="mynavbar">
                        <ul class="navbar-nav me-auto">
                                <c:choose>
                                        <c:when test="${username == null}">
                                                <li class="nav-item">
                                                        <a class="nav-link" href="<c:url value="/medical-registry" />">ĐĂNG KÝ KHÁM</a>
                                                </li>
                                                <li class="nav-item">
                                                        <a class="nav-link text-danger" href="<c:url value="/login" />">ĐĂNG NHẬP</a>
                                                </li>
                                                <li class="nav-item">
                                                        <a class="nav-link" href="<c:url value="/register" />">ĐĂNG KÝ</a>
                                                </li>
                                        </c:when>
                                        <c:when test="${user_role == 'ROLE_PATIENT'}">
                                                <li class="nav-item">
                                                        <a class="nav-link" href="<c:url value="/medical-registry" />">ĐĂNG KÝ KHÁM</a>
                                                </li>
                                                <li class="nav-item">
                                                        <a class="nav-link" href="<c:url value="/medical-history" />">LỊCH SU KHÁM BỆNH</a>
                                                </li>
                                        </c:when>
                                        <c:when test="${user_role == 'ROLE_DOCTOR'}">
                                                <li class="nav-item">
                                                        <a class="nav-link" href="<c:url value="/doctor" />">DANH SÁCH BỆNH NHÂN KHÁM BỆNH</a>
                                                </li>
                                        </c:when>
                                        <c:when test="${user_role == 'ROLE_NURSE'}">
                                                <li class="nav-item">
                                                        <a class="nav-link" href="<c:url value="/nurse/registration-list" />">DANH SÁCH KHÁM BỆNH</a>
                                                </li>
                                                <li class="nav-item">
                                                        <a class="nav-link" href="<c:url value="/nurse/payment" />">THANH TOÁN</a>
                                                </li>
                                                <li class="nav-item">
                                                        <a class="nav-link" href="<c:url value="/nurse/medical-registry" />">ĐĂNG KÝ CHO BỆNH NHÂN</a>
                                                </li>
                                        </c:when>
                                        <c:when test="${user_role == 'ROLE_ADMIN'}">
                                                <li class="nav-item">
                                                        <a class="nav-link text-danger" href="<c:url value="/admin/users" />">QUẢN LÝ USER</a>
                                                </li>
                                                <li class="nav-item">
                                                        <a class="nav-link text-danger" href="<c:url value="/admin/medicines" />">THUỐC</a>
                                                </li>
                                                <li class="nav-item">
                                                        <a class="nav-link text-danger" href="<c:url value="/admin/units" />">ĐƠN VỊ</a>
                                                </li>
                                                <li class="nav-item">
                                                        <a class="nav-link text-danger" href="<c:url value="/admin/prescriptions" />">ĐƠN THUỐC</a>
                                                </li>
                                                <li class="nav-item">
                                                        <a class="nav-link text-danger" href="<c:url value="/admin/prescription-detail" />">CHI TIẾT ĐƠN THUỐC</a>
                                                </li>
                                                <li class="nav-item">
                                                        <a class="nav-link text-danger" href="<c:url value="/admin/medical-certificates" />">PHIẾU KHÁM</a>
                                                </li>
                                                <li class="nav-item">
                                                        <a class="nav-link text-danger" href="<c:url value="/admin/diseases" />">BỆNH</a>
                                                </li>
                                                <li class="nav-item">
                                                        <a class="nav-link text-danger" href="<c:url value="/admin/register-stats" />">THỐNG KÊ</a>
                                                </li>
                                                <li class="nav-item">
                                                        <a class="nav-link text-danger" href="<c:url value="/admin/regulations" />">QUY TẮC</a>
                                                </li>
                                        </c:when>

                                        <c:when test="${user_role == 'ROLE_SUPERADMIN'}">
                                                <li class="nav-item">
                                                        <a class="nav-link text-danger" href="<c:url value="/admin/users" />">QUẢN LÝ USER</a>
                                                </li>
                                                <li class="nav-item">
                                                        <a class="nav-link text-danger" href="<c:url value="/admin/medicines" />">THUỐC</a>
                                                </li>
                                                <li class="nav-item">
                                                        <a class="nav-link text-danger" href="<c:url value="/admin/units" />">ĐƠN VỊ</a>
                                                </li>
                                                <li class="nav-item">
                                                        <a class="nav-link text-danger" href="<c:url value="/admin/prescriptions" />">ĐƠN THUỐC</a>
                                                </li>
                                                <li class="nav-item">
                                                        <a class="nav-link text-danger" href="<c:url value="/admin/prescription-detail" />">CHI TIẾT ĐƠN THUỐC</a>
                                                </li>
                                                <li class="nav-item">
                                                        <a class="nav-link text-danger" href="<c:url value="/admin/medical-certificates" />">PHIẾU KHÁM</a>
                                                </li>
                                                <li class="nav-item">
                                                        <a class="nav-link text-danger" href="<c:url value="/admin/diseases" />">BỆNH</a>
                                                </li>
                                                <li class="nav-item">
                                                        <a class="nav-link text-danger" href="<c:url value="/admin/stats" />">THỐNG KÊ</a>
                                                </li>
                                                <li class="nav-item">
                                                        <a class="nav-link text-danger" href="<c:url value="/admin/regulations" />">QUY TẮC</a>
                                                </li>
                                        </c:when>
                                </c:choose>

                                <c:if test="${username != null}">
                                        <li class="nav-item d-flex ">
                                                <a class="nav-link text-white " href="<c:url value="/" />">${username}</a>
                                                <img src="${avatar}" class="img-circle" alt="Cinque Terre" width="30"> 
                                        </li>
                                        <li class="nav-item">
                                                <a class="nav-link text-danger" href="<c:url value="/logout" />">ĐĂNG XUẤT</a>
                                        </li>
                                </c:if>


                        </ul>
                        <form class="d-flex" >
                                <input class="form-control me-2" type="text" placeholder="Search" name="kw" />
                                <input type="submit" class="btn btn-primary" value ="Search" />
                        </form>
                </div>
        </div>
</nav>