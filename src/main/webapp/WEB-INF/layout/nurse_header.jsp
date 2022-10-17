<%-- 
    Document   : nurse_header
    Created on : Aug 8, 2022, 1:54:32 PM
    Author     : Thanh_Tam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
        <div class="container-fluid">
                <a class="navbar-brand" href="<c:url value="/ " />">Home  </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                        <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="mynavbar">
                        <ul class="navbar-nav me-auto">
                                <li class="nav-item">
                                        <a class="nav-link" href="<c:url value="/nurse/registration-list" />">DANH SÁCH KHÁM BỆNH</a>
                                </li>
                                <li class="nav-item">
                                        <a class="nav-link" href="<c:url value="/nurse/payment" />">THANH TOÁN</a>
                                </li>
                                <li class="nav-item">
                                        <a class="nav-link" href="<c:url value="/nurse/medical-registry" />">ĐĂNG KÝ CHO BỆNH NHÂN</a>
                                </li>
                                <li class="nav-item">
                                        <a class="nav-link" href="<c:url value="/nurse/register" />">ĐĂNG KÝ</a>
                                </li>
                                <li class="nav-item">
                                        <a class="nav-link" href="<c:url value="/nurse/login" />">ĐĂNG NHẬP</a>
                                </li>
                        </ul>
                        <form class="d-flex">
                                <input class="form-control me-2" type="text" placeholder="Search" name="kw" />
                                <input type="submit" class="btn btn-primary" value ="Search" />
                        </form>
                </div>
        </div>
</nav>