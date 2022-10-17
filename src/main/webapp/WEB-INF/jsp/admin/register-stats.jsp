<%-- 
    Document   : register-stats
    Created on : Sep 10, 2022, 8:47:42 AM
    Author     : Thanh_Tam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-danger">THONG KE BENH NHAN DEN KHAM</h1>

<div>
        <canvas id="registerChart"></canvas>
</div>


<script>
        let labels=[], info=[];
        <c:forEach items="${registerStats}" var="r">
                labels.push('${r.dateOfExamination}');  
                info.push(${r.id});
        </c:forEach>
        window.onload = function() {
                registerChart('registerChart', labels, info);
        };
</script>