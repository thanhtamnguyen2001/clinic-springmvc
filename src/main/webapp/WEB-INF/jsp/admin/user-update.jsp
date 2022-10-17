<%-- 
    Document   : user-update
    Created on : Sep 8, 2022, 12:55:50 AM
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<br><br>
<h1 class="text-danger text-center">Sửa người dùng</h1>
<br><br> 

<form method="put" id="userUpdateForm" enctype="multipart/form-data">
    <div class="form-floating mb-3 mt-3">
        <input type="text" class="form-control" id="lastName-user" placeholder="" name="lastName-user" value="${user.lastName}"/>
        <label for="lastName-user">Họ</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <input type="text" class="form-control" id="firstName-user" placeholder="" name="firstName-user" value="${user.firstName}"/>
        <label for="firstName-user">Tên</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <input type="text" class="form-control" id="phoneNumber-user" placeholder="" name="phoneNumber-user" value="${user.phoneNumber}"/>
        <label for="phoneNumber-user">SĐT</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        Giới tính:
        <input type="radio" name="active-sex" value="${'Nam'}" ${user.sex == 'Nam' ? 'checked' : ''}/>Nam
        <input type="radio" name="active-sex" value="${'Nữ'}" ${user.sex == 'Nam' ? '' : 'checked'}/>Nữ
    </div>
    <div class="form-floating mb-3 mt-3">
        <input type="text" class="form-control" id="identifier-user" placeholder="" name="identifier-user" value="${user.identifier}"/>
        <label for="identifier-user">CMND/CCCD</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <input type="email" class="form-control" id="email-user" placeholder="" name="email-user" value="${user.email}"/>
        <label for="email-user">Email</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <input type="text" class="form-control" id="username-user" placeholder="" name="username-user" value="${user.username}"/>
        <label for="username-user">Tài khoản</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <input type="password" class="form-control" id="password-user" placeholder="" name="password-user"/>
        <label for="password-user">Mật khẩu</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        Tình trạng:
        <input type="radio" name="active-user" value="${true}" ${user.active ? 'checked' : ''}/>Còn hạn
        <input type="radio" name="active-user" value="${false}" ${user.active ? '' : 'checked'}/>Hết hạn
    </div>
    <div class="form-floating mb-3 mt-3">
        <input type="file" accept="image/*" class="form-control" id="image-user" placeholder="" name="image-user"/>
        <label for="image-user">Ảnh đại diện</label>
    </div>
    <div style="width: 100px; height: 100px;">
        <img style="width: 100px; height: 100px;" src="${user.avatar}" />
    </div>
    <div class="form-floating">
        <select class="form-select" id="role-user" name="role-user">
            <option hidden id="${user.userRoleId.id}" value="${user.userRoleId.id}">${user.userRoleId.id}:${user.userRoleId.name}</option>
            <c:forEach items="${roles}" var="role">
                <option id="${role.id}" value="${role.id}">${role.id}:${role.name}</option>
            </c:forEach>
        </select>
        <label for="role-user" class="form-label">Quyền</label>
    </div>
    <br/>
    <div style="display:flex; justify-content: center">
        <c:url var="updateApi" value="/api/users/${user.id}"/>
        <input type="button" id="btnUpdateUnit" onclick="updateUser('${updateApi}')" value="Sửa" class="btn btn-danger "/>
    </div>
    <br/>
</form>

<script src="<c:url value="/js/admin.js"/>"></script>
