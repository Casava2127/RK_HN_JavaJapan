<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Create New Class</title>
  <!-- Tiêu đề trang web -->
</head>
<body>
<h2>Create New Class</h2>
<!-- Tiêu đề form -->

<form action="<%=request.getContextPath()%>/classController/create" method="post">
  <!-- Form gửi yêu cầu POST đến controller để tạo lớp mới -->

  <label for="className">Class Name:</label>
  <input type="text" id="className" name="className" value="${newClass.className}" required/>
  <!-- Trường nhập tên lớp, bắt buộc nhập -->

  <br/>

  <label for="majors">Majors:</label>
  <input type="text" id="majors" name="majors" value="${newClass.majors}" required/>
  <!-- Trường nhập ngành học của lớp, bắt buộc nhập -->

  <br/>

  <input type="submit" value="Create Class"/>
  <!-- Nút submit để gửi form tạo lớp -->
</form>
</body>
</html>
