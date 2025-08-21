<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách Sinh viên</title>
</head>
<body>
<h1>Danh sách Sinh viên</h1>
<a href="<%=request.getContextPath()%>/studentController/initCreate">Tạo mới Sinh viên</a>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên Sinh viên</th>
        <th>Điện thoại</th>
        <th>Email</th>
        <th>Địa chỉ</th>
        <th>Giới tính</th>
        <th>Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${listStudents}">
        <tr>
            <td>${student.studentId}</td>
            <td>${student.studentName}</td>
            <td>${student.phoneNumber}</td>
            <td>${student.email}</td>
            <td>${student.address}</td>
            <td>${student.sex == 1 ? 'Nam' : 'Nữ'}</td>
            <td>
                <a href="<%=request.getContextPath()%>/studentController/initUpdate?studentId=${student.studentId}">Cập nhật</a>
                <a href="<%=request.getContextPath()%>/studentController/delete?studentId=${student.studentId}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
