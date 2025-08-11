<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Đưa thư viện JSTL vào trang JSP, cho phép sử dụng các thẻ JSTL (c:forEach, c:if, ...) trong trang -->
<!-- `prefix="c"` có nghĩa là các thẻ JSTL sẽ được sử dụng với tiền tố "c" (ví dụ: `c:forEach>`) -->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Đặt loại nội dung của trang web là HTML và mã hóa ký tự là UTF-8 (hỗ trợ các ký tự đặc biệt như tiếng Việt) -->
<!-- `language="java"` cho biết mã trong JSP sử dụng ngôn ngữ Java -->

<html>
<head>
    <title>List of Classes</title>
    <!-- Tiêu đề trang web khi hiển thị trên tab của trình duyệt -->
</head>
<body>
<h2>Class List</h2>
<table border="1">
    <!-- Tạo bảng với viền -->
    <thead>
    <tr>
        <th>No</th>
        <th>Class ID</th>
        <th>Class Name</th>
        <th>Majors</th>

    </tr>
    </thead>
    <tbody>
    <!-- Bắt đầu phần thân bảng, nơi danh sách các lớp sẽ được hiển thị -->

    <c:forEach items="${listClasses}" var="cls" varStatus="loop">
        <!-- Sử dụng thẻ JSTL c:forEach để duyệt qua danh sách lớp -->
        <!-- `items="${listClasses}"`: Dữ liệu được duyệt qua là danh sách lớp (listClasses) từ model -->
        <!-- `var="cls"`: Mỗi phần tử trong danh sách sẽ được lưu trữ vào biến `cls` -->
        <!-- `varStatus="loop"`: Cung cấp thông tin về trạng thái vòng lặp (số lần lặp, v.v.) -->

        <tr>
            <td>${loop.index + 1}</td>
            <!-- In ra số thứ tự (index) của lớp trong danh sách, cộng thêm 1 để bắt đầu từ 1 thay vì 0 -->

            <td>${cls.classId}</td>
            <!-- In ra ID của lớp -->

            <td>${cls.className}</td>
            <!-- In ra tên lớp -->

            <td>${cls.majors}</td>
            <td>
                <!-- Thêm cột hành động với các liên kết để cập nhật hoặc xóa lớp -->
                <a href="<%=request.getContextPath()%>/classController/initUpdate?classId=${cls.classId}">Update</a>
                <!-- Liên kết để chuyển đến trang cập nhật lớp, với tham số `classId` là ID lớp cần cập nhật -->

                <a href="<%=request.getContextPath()%>/classController/delete?classId=${cls.classId}">Delete</a>
                <!-- Liên kết để xóa lớp, với tham số `classId` là ID lớp cần xóa -->
            </td>
        </tr>
    </c:forEach>
    <!-- Kết thúc vòng lặp -->
    </tbody>
</table>

<!-- Tạo liên kết để thêm lớp mới -->
<a href="<%=request.getContextPath()%>/classController/initCreate">Create New Class</a>
</body>
</html>
