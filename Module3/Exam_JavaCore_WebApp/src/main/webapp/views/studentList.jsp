<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách Sinh viên</title>
</head>
<body>
<h1>Danh sách Sinh viên</h1>
<a href="${pageContext.request.contextPath}/studentController/initCreate">Tạo mới Sinh viên</a>
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
                <a href="${pageContext.request.contextPath}/studentController/initUpdate/${student.studentId}">Cập nhật</a>
                <a href="${pageContext.request.contextPath}/studentController/delete/${student.studentId}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
