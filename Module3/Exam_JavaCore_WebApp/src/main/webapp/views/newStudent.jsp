<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tạo mới Sinh viên</title>
</head>
<body>
<h1>Tạo mới Sinh viên</h1>

<form action="<%= request.getContextPath() %>/studentController/create" method="post">

    <label for="studentName">Tên sinh viên:</label>
    <input type="text" id="studentName" name="studentName" value="${studentUpdate != null ? studentUpdate.studentName : ''}" required><br><br>

    <label for="phoneNumber">Điện thoại:</label>
    <input type="text" id="phoneNumber" name="phoneNumber" value="${studentUpdate != null ? studentUpdate.phoneNumber : ''}" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${studentUpdate != null ? studentUpdate.email : ''}" required><br><br>

    <label for="address">Địa chỉ:</label>
    <input type="text" id="address" name="address" value="${studentUpdate != null ? studentUpdate.address : ''}" required><br><br>

    <label for="sex">Giới tính:</label>
    <select id="sex" name="sex" required>
        <option value="1" ${studentUpdate != null && studentUpdate.sex ? 'selected' : ''}>Nam</option>
        <option value="0" ${studentUpdate != null && !studentUpdate.sex ? 'selected' : ''}>Nữ</option>
    </select><br><br>

    <label for="classId">Chọn Lớp:</label>
    <select id="classId" name="classId" required>
        <c:forEach var="classItem" items="${listClasses}">
            <option value="${classItem.classId}">
                    ${classItem.className}
            </option>
        </c:forEach>
    </select><br><br>

    <input type="submit" value="Tạo mới">
</form>

</body>
</html>
