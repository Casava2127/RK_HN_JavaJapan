<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Class</title>
    <!-- Tiêu đề trang cập nhật lớp -->
</head>
<body>
<h2>Update Class</h2>
<!-- Tiêu đề form cập nhật lớp -->

<form action="<%=request.getContextPath()%>/classController/update" method="post">
    <!-- Form gửi yêu cầu POST đến controller để cập nhật lớp -->

    <input type="hidden" name="classId" value="${classUpdate.classId}"/>
    <!-- Trường ẩn chứa ID của lớp cần cập nhật. Dùng để truyền thông tin ID đến controller. -->

    <label for="className">Class Name:</label>
    <input type="text" id="className" name="className" value="${classUpdate.className}" required/>
    <!-- Trường nhập tên lớp, giá trị mặc định là tên lớp hiện tại -->

    <br/>

    <label for="majors">Majors:</label>
    <input type="text" id="majors" name="majors" value="${classUpdate.majors}" required/>
    <!-- Trường nhập ngành học của lớp, giá trị mặc định là ngành học hiện tại -->

    <br/>

    <input type="submit" value="Update Class"/>
    <!-- Nút submit để gửi form cập nhật lớp -->
</form>
</body>
</html>
