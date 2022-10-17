<%-- 
    Document   : base
    Created on : Jul 26, 2022, 3:46:48 PM
    Author     : Thanh_Tam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
        <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
                <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
                <link rel="stylesheet" href="<c:url value="/css/patient.css" />">
                <link rel="stylesheet" href="<c:url value="/css/common.css" />">
                <title><tiles:insertAttribute name="title" /></title>
        </head>
        <body>
                <tiles:insertAttribute name="logo" />
                <tiles:insertAttribute name="header" />
                <div class="container" style="min-height: 500px;" >
                        <tiles:insertAttribute name="content" />
                </div>
                <tiles:insertAttribute name="footer" />

        </body>
        <script src="<c:url value="/js/stats.js" />"></script>
        <script src="<c:url value="/js/nurse.js" />"></script>
        <script src="<c:url value="/js/doctor.js" />"></script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>
</html>
