package ra.com.reposistory.imp; // Khai báo package chứa lớp triển khai của CategoriesRepository

import ra.com.entity.Categories; // Import lớp Categories từ package ra.com.entity
import ra.com.reposistory.CategoriesRepository; // Import interface CategoriesRepository từ package ra.com.reposistory
import ra.com.util.ConnectionDB; // Import lớp ConnectionDB để quản lý kết nối cơ sở dữ liệu

import java.sql.CallableStatement; // Import CallableStatement để gọi các thủ tục lưu trữ trong cơ sở dữ liệu
import java.sql.Connection; // Import Connection để tạo kết nối với cơ sở dữ liệu
import java.sql.ResultSet; // Import ResultSet để làm việc với kết quả truy vấn
import java.util.ArrayList; // Import ArrayList để tạo danh sách động
import java.util.List; // Import List để sử dụng cấu trúc danh sách

// Lớp này thực hiện các thao tác với cơ sở dữ liệu
public class CategoriesRepositoryImp implements CategoriesRepository { // Định nghĩa lớp CategoriesRepositoryImp triển khai interface CategoriesRepository

    @Override
    public List<Categories> findAll() { // Triển khai phương thức findAll để lấy danh sách tất cả các danh mục
        Connection conn = null; // Khởi tạo biến kết nối cơ sở dữ liệu
        CallableStatement callSt = null; // Khởi tạo biến để gọi thủ tục lưu trữ
        List<Categories> listCategories = null; // Khởi tạo danh sách để chứa các danh mục

        try {
            conn = ConnectionDB.openConnection(); // Mở kết nối với cơ sở dữ liệu
            callSt = conn.prepareCall("{call find_all_categories()}"); // Chuẩn bị câu lệnh gọi thủ tục lưu trữ find_all_categories
            ResultSet rs = callSt.executeQuery(); // Thực thi thủ tục và lấy kết quả trả về

            listCategories = new ArrayList<>(); // Khởi tạo danh sách chứa các danh mục

            while (rs.next()) { // Duyệt từng bản ghi trong kết quả trả về
                Categories categories = new Categories(); // Tạo đối tượng Categories mới
                categories.setCatalogId(rs.getInt("catalog_id")); // Lấy giá trị catalog_id và gán vào đối tượng
                categories.setCatalogName(rs.getString("catalog_name")); // Lấy giá trị catalog_name và gán vào đối tượng
                categories.setDescription(rs.getString("catalog_description")); // Lấy giá trị catalog_description và gán vào đối tượng
                categories.setStatus(rs.getBoolean("catalog_status")); // Lấy giá trị catalog_status và gán vào đối tượng

                listCategories.add(categories); // Thêm đối tượng Categories vào danh sách
            }
        } catch (Exception ex) { // Bắt ngoại lệ nếu có lỗi xảy ra
            ex.printStackTrace(); // In ra lỗi để kiểm tra
        } finally {
            ConnectionDB.closeConnection(conn, callSt); // Đóng kết nối cơ sở dữ liệu và tài nguyên
        }

        return listCategories; // Trả về danh sách các danh mục
    }
}
