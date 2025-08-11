<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Update Student</title>
</head>
<body>
<h2>Update Student</h2>
<form action="<%=request.getContextPath()%>/studentController/update" method="post">
  <input type="hidden" name="studentId" value="${student.studentId}"/>
  Name: <input type="text" name="studentName" value="${student.studentName}" required/><br>
  Phone: <input type="text" name="phoneNumber" value="${student.phoneNumber}" required/><br>
  Email: <input type="email" name="email" value="${student.email}" required/><br>
  Address: <input type="text" name="address" value="${student.address}" required/><br>
  Sex: <select name="sex">
  <option value="true" ${student.sex ? "selected" : ""}>Male</option>
  <option value="false" ${!student.sex ? "selected" : ""}>Female</option>
</select><br>
  Class:
  <select name="classId.classId">
    <c:forEach var="class" items="${classes}">
      <option value="${class.classId}" ${class.classId == student.classId.classId ? "selected" : ""}>${class.className}</option>
    </c:forEach>
  </select><br>
  <input type="submit" value="Update"/>
</form>
</body>
</html>
