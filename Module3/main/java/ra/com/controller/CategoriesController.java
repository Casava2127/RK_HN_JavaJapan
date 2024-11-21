package ra.com.controller; // Khai báo package chứa lớp CategoriesController

import ra.com.entity.Categories; // Import lớp Categories từ package ra.com.entity
import ra.com.service.CategoriesService; // Import interface CategoriesService từ package ra.com.service
import ra.com.service.imp.CategoriesServiceImp; // Import lớp triển khai CategoriesServiceImp từ package ra.com.service.imp

import javax.servlet.*; // Import các lớp cần thiết cho servlet
import javax.servlet.http.*; // Import các lớp cần thiết cho HTTP servlet
import javax.servlet.annotation.*; // Import các annotation hỗ trợ cho servlet
import java.io.IOException; // Import lớp IOException dùng cho xử lý ngoại lệ I/O
import java.util.List; // Import lớp List từ thư viện Java để làm việc với danh sách

@WebServlet(name = "CategoriesController", value = "/CategoriesController") // Định nghĩa servlet với tên "CategoriesController" và đường dẫn "/CategoriesController"
public class CategoriesController extends HttpServlet { // Khai báo lớp CategoriesController kế thừa HttpServlet

    // Khởi tạo một instance của CategoriesService để sử dụng trong controller
    private CategoriesService categoriesService;

    public CategoriesController() {  // Constructor của lớp CategoriesController
        categoriesService = new CategoriesServiceImp(); // Gán cho categoriesService một đối tượng CategoriesServiceImp (lớp triển khai của CategoriesService)
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Ghi đè phương thức doGet để xử lý các yêu cầu GET

        String action = request.getParameter("action"); // Lấy tham số "action" từ yêu cầu của người dùng

        if (action.equals("findAll")) { // Nếu action là "findAll" thì thực hiện khối lệnh sau
            List<Categories> listCategories = categoriesService.findAll(); // Gọi phương thức findAll() từ service để lấy danh sách tất cả các danh mục

            request.setAttribute("listCategories", listCategories); // Đưa danh sách danh mục vào yêu cầu dưới tên "listCategories"

            request.getRequestDispatcher("/views/categories.jsp").forward(request, response);
            // Chuyển tiếp yêu cầu và phản hồi tới trang categories.jsp để hiển thị danh sách danh mục
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Ghi đè phương thức doPost để xử lý các yêu cầu POST (hiện tại chưa được triển khai)
    }
}
