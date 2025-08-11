# 14/02/2025
 ## Servlet
Định nghĩa:
Servlet là các lớp Java chạy trên máy chủ web (như Tomcat, Jetty), xử lý các yêu cầu HTTP (GET, POST...) và trả về phản hồi. Chúng kế thừa lớp javax.servlet.http.HttpServlet và ghi đè các phương thức như doGet(), doPost().
Vai trò: 
Xử lý logic nghiệp vụ (kết nối database, tính toán).
Điều hướng request/response (chuyển hướng, forward).
Thường đóng vai trò Controller trong mô hình MVC.

Vòng đời:

init(): Khởi tạo Servlet.

service(): Xử lý yêu cầu.

destroy(): Hủy Servlet.
 ## JSP (JavaServer Pages)
Định nghĩa:
JSP là công nghệ tạo trang web động bằng cách nhúng Java vào HTML qua các thẻ đặc biệt (<% %>, <%= %>). Khi chạy, JSP được biên dịch thành Servlet.

Vai trò:

Tạo giao diện người dùng (UI) động.

Đóng vai trò View trong MVC, tập trung vào hiển thị dữ liệu.

### Kết hợp JSP và Servlet
Mô hình MVC:

Servlet nhận request → Xử lý logic → Truyền dữ liệu đến JSP (qua request.setAttribute()).

JSP hiển thị dữ liệu (dùng EL/JSTL như ${data}).

Ví dụ:

java
Copy
// Servlet (Controller)
protected void doGet(HttpServletRequest request, HttpServletResponse response) {
String message = "Xin chào!";
request.setAttribute("msg", message);
request.getRequestDispatcher("/page.jsp").forward(request, response);
}
jsp
Copy
<!-- JSP (View) -->
<html>
    <body>Thông điệp: ${msg}</body>
</html>
Xu hướng hiện đại
Các framework như Spring MVC sử dụng Servlet nền tảng nhưng ẩn đi boilerplate code.
Thư viện templating (Thymeleaf, Freemarker) thay thế JSP để tách biệt rõ ràng logic và giao diện.
Tóm lại: JSP và Servlet là nền tảng của web Java, kết hợp để tách biệt logic (Servlet) và giao diện (JSP), giúp phát triển ứng dụng web hiệu quả.