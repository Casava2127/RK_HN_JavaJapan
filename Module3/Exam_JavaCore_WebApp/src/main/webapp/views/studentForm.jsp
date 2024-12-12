<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tạo/Sửa Sinh viên</title>
</head>
<body>
<h1>${studentUpdate != null ? 'Cập nhật Sinh viên' : 'Tạo mới Sinh viên'}</h1>
<form action="${studentUpdate != null ? '/studentController/update' : '/studentController/create'}" method="post">
    <input type="hidden" name="studentId" value="${studentUpdate != null ? studentUpdate.studentId : ''}">
    <label for="studentName">Tên sinh viên:</label>
    <input type="text" id="studentName" name="studentName" value="${studentUpdate != null ? studentUpdate.studentName : ''}" required><br><br>

    <label for="phoneNumber">Điện thoại:</label>
    <input type="text" id="phoneNumber" name="phoneNumber" value="${studentUpdate != null ? studentUpdate.phoneNumber : ''}" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${studentUpdate != null ? studentUpdate.email : ''}" required><br><br>

    <label for="address">Địa chỉ:</label>
    <input type="text" id="address" name="address" value="${studentUpdate != null ? studentUpdate.address : ''}" required><br><br>

    <label for="sex">Giới tính:</label>
    <select id="sex" name="sex">
        <option value="1" ${studentUpdate != null && studentUpdate.sex == 1 ? 'selected' : ''}>Nam</option>
        <option value="0" ${studentUpdate != null && studentUpdate.sex == 0 ? 'selected' : ''}>Nữ</option>
    </select><br><br>

    <input type="submit" value="${studentUpdate != null ? 'Cập nhật' : 'Tạo mới'}">
</form>
</body>
</html>
