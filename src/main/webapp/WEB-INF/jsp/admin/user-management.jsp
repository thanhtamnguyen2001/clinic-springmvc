<%-- 
    Document   : user-management
    Created on : Sep 7, 2022, 11:43:53 PM
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<br><br>
<h1 class="text-danger text-center">Quản lý người dùng</h1>
<br><br>  

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<c:url value="/admin/users" var="action"/>
<form:form method="post" action="${action}" modelAttribute="user" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="lastName" class="form-control" id="lastNameUser" placeholder="" name="lastNameUser" />
        <label for="lastNameUser">Họ</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="firstName" class="form-control" id="firstNameUser" placeholder="" name="firstNameUser" />
        <label for="firstNameUser">Tên</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="phoneNumber" class="form-control" id="phoneNumberUser" placeholder="" name="phoneNumberUser" />
        <label for="phoneNumberUser">SĐT</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="date" path="dateString" class="form-control" id="dateOfBirthUser" placeholder="" name="dateOfBirthUser" />
        <label for="dateOfBirthUser">Ngày sinh</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        Giới tính:
        <form:radiobutton path="sex" value="${'Nam'}" checked="checked"/>Nam
        <form:radiobutton path="sex" value="${'Nữ'}"/>Nữ
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="identifier" class="form-control" id="identifierUser" placeholder="" name="identifierUser" />
        <label for="identifierUser">CMND/CCCD</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="email" path="email" class="form-control" id="emailUser" placeholder="" name="emailUser" />
        <label for="emailUser">Email</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="username" class="form-control" id="usernameUser" placeholder="" name="usernameUser" />
        <label for="usernameUser">Tài khoản</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="password" path="password" class="form-control" id="passwordUser" placeholder="" name="passwordUser" />
        <label for="passwordUser">Mật khẩu</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="password" path="confirmPassword" class="form-control" id="confirmPasswordUser" placeholder="" name="confirmPasswordUser" />
        <label for="confirmPasswordUser">Nhập lại mật khẩu</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        Tình trạng:
        <form:radiobutton path="active" value="${1}" checked="checked"/>Còn hạn
        <form:radiobutton path="active" value="${0}"/>Hết hạn
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" path="image" accept="image/*" class="form-control" id="imageUser" placeholder="" name="imageUser" />
        <label for="imageUser">Ảnh đại diện</label>
    </div>
    <div class="form-floating">
        <form:select path="userRoleId" class="form-select" id="userRoleId" name="userRoleId">
            <c:forEach items="${roles}" var="role">
                <option id="${role.id}" value="${role.id}">${role.id}:${role.name}</option>
            </c:forEach>
        </form:select>
        <label for="userRoleId" class="form-label">Quyền</label>
    </div>
    <br/>
    <div style="display:flex; justify-content: center">
        <input type="submit" value="Thêm người dùng" class="btn btn-danger "/>
    </div>
    <br/>
</form:form>

<div id="mySpinner" style="display:flex; justify-content: center">
    <div class="spinner-border text-center"></div>
</div>
<div style="width: 100%; overflow-x: scroll">
    <table class="table table-hover" >
        <thead class="text-center">
            <tr>
                <th>Mã người dùng</th>
                <th>Họ</th>
                <th>Tên</th>
                <th>SĐT</th>
                <th>Ngày sinh</th>
                <th>Giới tính</th>
                <th>CMND/CCCD</th>
                <th>Email</th>
                <th>Tài khoản</th>
                <th>Mật khẩu</th>
                <th>Tình trạng</th>
                <th>Ngày tạo</th>
                <th>Ảnh đại diện</th>
                <th>Quyền</th>
            </tr>
        </thead>
        <tbody id="myUser" class="text-center">

        </tbody>
    </table>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>
<script src="<c:url value="/js/admin.js"/>"></script>
<script>
    <c:url value="/api/users" var="u"/>
    window.onload = function () {
        getUsers('${u}');
    }
</script>
