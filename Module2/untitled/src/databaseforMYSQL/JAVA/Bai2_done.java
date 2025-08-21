package databaseforMYSQL.JAVA;//package databaseforMYSQL.JAVA;

import java.io.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class Bai2_done {
    // Khai báo và cấu hình kết nối cơ sở dữ liệu
    private static final String DB_URL = "jdbc:mysql://localhost:3306/qltourjava";  // URL kết nối tới cơ sở dữ liệu MySQL
    private static final String USER_NAME = "root";  // Tên đăng nhập vào cơ sở dữ liệu
    private static final String PASSWORD = "123456";  // Mật khẩu đăng nhập vào cơ sở dữ liệu
    private static final String FILE_DATA1 = "F:\\VsCodeLap\\HNPTHBJV240711\\Module2\\untitled\\src\\databaseforMYSQL\\JAVA\\data1.txt";  // Đường dẫn tới file dữ liệu 1
    private static final String FILE_DATA2 = "F:\\VsCodeLap\\HNPTHBJV240711\\Module2\\untitled\\src\\databaseforMYSQL\\JAVA\\data2.txt";  // Đường dẫn tới file dữ liệu 2
    private static final String FILE_ERROR = "F:\\VsCodeLap\\HNPTHBJV240711\\Module2\\untitled\\src\\databaseforMYSQL\\JAVA\\data3.txt";  // Đường dẫn tới file lỗi

    private static Connection conn;  // Biến kết nối đến cơ sở dữ liệu

    public static void main(String[] args) {
        try {
            // Step 1: Kết nối cơ sở dữ liệu
            conn = connectToDatabase(DB_URL, USER_NAME, PASSWORD);  // Kết nối tới cơ sở dữ liệu với URL, tên người dùng và mật khẩu đã cấu hình
            createDatabaseAndTable();  // Tạo cơ sở dữ liệu và bảng nếu chưa tồn tại

            // Step 2: Xử lý dữ liệu từ file data1.txt
            processFileData1();  // Chèn dữ liệu từ file data1.txt vào cơ sở dữ liệu

            // Step 3: Xử lý dữ liệu từ file data2.txt
            processFileData2();  // Xử lý dữ liệu từ file data2.txt và kiểm tra lỗi

            System.out.println("Processing completed.");  // Thông báo hoàn thành xử lý
        } catch (Exception e) {
            e.printStackTrace();  // In ra thông báo lỗi nếu có ngoại lệ xảy ra
        } finally {
            closeConnection();  // Đóng kết nối cơ sở dữ liệu
        }
    }

    // Kết nối đến cơ sở dữ liệu MySQL
    private static Connection connectToDatabase(String dbUrl, String userName, String password) {
        try {
            return DriverManager.getConnection(dbUrl, userName, password);  // Sử dụng DriverManager để kết nối đến cơ sở dữ liệu
        } catch (SQLException e) {
            System.out.println("Database connection failed!");  // Thông báo nếu kết nối thất bại
            e.printStackTrace();  // In ra chi tiết lỗi
            return null;  // Trả về null nếu kết nối không thành công
        }
    }

    // Tạo bảng THANHVIEN nếu chưa tồn tại
    private static void createDatabaseAndTable() throws SQLException {
        Statement stmt = conn.createStatement();  // Tạo đối tượng Statement để thực thi câu lệnh SQL

        // Câu lệnh SQL để tạo bảng THANHVIEN
        String createTableQuery = """
            CREATE TABLE IF NOT EXISTS THANHVIEN (
                MaThanhVien VARCHAR(50) PRIMARY KEY,  // Mã thành viên
                TenThanhVien VARCHAR(8),  // Tên thành viên
                NgaySinh DATE,  // Ngày sinh
                DiaChi VARCHAR(100),  // Địa chỉ
                Email VARCHAR(100),  // Email
                SoDienThoai VARCHAR(50),  // Số điện thoại
                ChiPhiNhan DOUBLE DEFAULT 0  // Chi phí nhận, mặc định là 0
            )
            """;
        stmt.executeUpdate(createTableQuery);  // Thực thi câu lệnh tạo bảng
        System.out.println("Table THANHVIEN created.");  // Thông báo đã tạo bảng thành công
    }

    // Xử lý dữ liệu từ file data1.txt và chèn vào cơ sở dữ liệu
    private static void processFileData1() throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_DATA1));  // Đọc dữ liệu từ file data1.txt
        String line;  // Biến chứa từng dòng dữ liệu trong file

        while ((line = reader.readLine()) != null) {  // Đọc từng dòng từ file
            String[] data = line.split(",\\s*");  // Tách các giá trị trong dòng dữ liệu bằng dấu phẩy và khoảng trắng
            if (data.length == 6) {  // Nếu có đúng 6 trường dữ liệu
                // Câu lệnh SQL để chèn dữ liệu vào bảng THANHVIEN
                String insertQuery = "INSERT INTO THANHVIEN (MaThanhVien, TenThanhVien, NgaySinh, DiaChi, Email, SoDienThoai) VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {  // Chuẩn bị câu lệnh SQL
                    pstmt.setString(1, data[0]);  // Chèn giá trị Mã thành viên
                    pstmt.setString(2, data[1]);  // Chèn giá trị Tên thành viên
                    pstmt.setDate(3, Date.valueOf(data[2]));  // Chèn giá trị Ngày sinh
                    pstmt.setString(4, data[3]);  // Chèn giá trị Địa chỉ
                    pstmt.setString(5, data[4]);  // Chèn giá trị Email
                    pstmt.setString(6, data[5]);  // Chèn giá trị Số điện thoại
                    pstmt.executeUpdate();  // Thực thi câu lệnh chèn dữ liệu vào cơ sở dữ liệu
                }
            } else {
                System.out.println("Invalid data format in data1.txt: " + line);  // Thông báo nếu dòng dữ liệu không hợp lệ
            }
        }
        reader.close();  // Đóng file sau khi đọc xong
        System.out.println("Data from data1.txt inserted.");  // Thông báo đã chèn dữ liệu thành công
    }

    // Xử lý dữ liệu từ file data2.txt và kiểm tra lỗi
    private static void processFileData2() throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_DATA2));  // Đọc dữ liệu từ file data2.txt
        BufferedWriter errorWriter = new BufferedWriter(new FileWriter(FILE_ERROR));  // Ghi lỗi vào file data3.txt
        String line;  // Biến chứa từng dòng dữ liệu trong file
        int lineNumber = 1;  // Biến đếm số dòng

        while ((line = reader.readLine()) != null) {  // Đọc từng dòng từ file
            String[] data = line.split(",\\s*");  // Tách các giá trị trong dòng dữ liệu
            if (data.length == 3) {  // Nếu có đúng 3 trường dữ liệu
                String maThanhVien = data[0];  // Mã thành viên
                String diemThuongStr = data[1];  // Điểm thưởng (dưới dạng chuỗi)
                String level = data[2];  // Cấp bậc (VIP hoặc NOR)

                boolean hasError = false;  // Biến kiểm tra lỗi
                StringBuilder errorMessage = new StringBuilder("Line " + lineNumber + ": ");  // Tạo chuỗi thông báo lỗi cho dòng hiện tại

                // Kiểm tra tính hợp lệ của điểm thưởng
                int diemThuong = 0;
                try {
                    diemThuong = Integer.parseInt(diemThuongStr);  // Chuyển điểm thưởng từ chuỗi thành số nguyên
                    if (diemThuong <= 0 || diemThuong > 500) {  // Nếu điểm thưởng không hợp lệ
                        hasError = true;  // Đánh dấu là có lỗi
                        errorMessage.append("Invalid DiemThuong. ");  // Thêm thông báo lỗi
                    }
                } catch (NumberFormatException e) {
                    hasError = true;  // Đánh dấu là có lỗi
                    errorMessage.append("DiemThuong is not an integer. ");  // Thêm thông báo lỗi nếu điểm thưởng không phải là số nguyên
                }

                // Kiểm tra tính hợp lệ của cấp bậc
                int heSo = 0;
                if (level.equals("VIP")) {  // Nếu cấp bậc là VIP
                    heSo = 50000;  // Hệ số cho cấp bậc VIP là 50000
                } else if (level.equals("NOR")) {  // Nếu cấp bậc là NOR
                    heSo = 20000;  // Hệ số cho cấp bậc NOR là 20000
                } else {  // Nếu cấp bậc không hợp lệ
                    hasError = true;  // Đánh dấu là có lỗi
                    errorMessage.append("Invalid Level. ");  // Thêm thông báo lỗi nếu cấp bậc không phải là VIP hoặc NOR
                }

                // Kiểm tra mã thành viên có tồn tại trong cơ sở dữ liệu không
                double currentChiPhi = 0;
                boolean exists = false;  // Biến kiểm tra xem mã thành viên có tồn tại hay không
                String selectQuery = "SELECT ChiPhiNhan FROM THANHVIEN WHERE MaThanhVien = ?";  // Câu lệnh SQL để kiểm tra mã thành viên
                try (PreparedStatement pstmt = conn.prepareStatement(selectQuery)) {  // Chuẩn bị câu lệnh SQL
                    pstmt.setString(1, maThanhVien);  // Chèn mã thành viên vào câu lệnh
                    ResultSet rs = pstmt.executeQuery();  // Thực thi câu lệnh và lấy kết quả
                    if (rs.next()) {  // Nếu tìm thấy kết quả
                        exists = true;  // Đánh dấu là mã thành viên tồn tại
                        currentChiPhi = rs.getDouble("ChiPhiNhan");  // Lấy giá trị ChiPhiNhan hiện tại
                    }
                }

                if (!exists) {  // Nếu mã thành viên không tồn tại trong cơ sở dữ liệu
                    hasError = true;  // Đánh dấu là có lỗi
                    errorMessage.append("MaThanhVien does not exist in database. ");  // Thêm thông báo lỗi
                }

                // Nếu có lỗi, ghi vào file lỗi
                if (hasError) {
                    errorWriter.write(errorMessage.toString());  // Ghi thông báo lỗi vào file
                    errorWriter.newLine();  // Thêm dòng mới
                } else {  // Nếu không có lỗi
                    double chiPhiNhan = currentChiPhi + diemThuong * heSo;  // Tính toán chi phí nhận
                    String updateQuery = "UPDATE THANHVIEN SET ChiPhiNhan = ? WHERE MaThanhVien = ?";  // Câu lệnh SQL để cập nhật ChiPhiNhan
                    try (PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {  // Chuẩn bị câu lệnh SQL
                        pstmt.setDouble(1, chiPhiNhan);  // Chèn giá trị ChiPhiNhan mới
                        pstmt.setString(2, maThanhVien);  // Chèn mã thành viên vào câu lệnh
                        pstmt.executeUpdate();  // Thực thi câu lệnh cập nhật
                    }
                }
            }
            lineNumber++;  // Tăng số dòng
        }

        reader.close();  // Đóng file sau khi đọc xong
        errorWriter.close();  // Đóng file lỗi sau khi ghi xong
        System.out.println("Data from data2.txt processed.");  // Thông báo đã xử lý xong dữ liệu
    }

    // Đóng kết nối cơ sở dữ liệu
    private static void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {  // Nếu kết nối không null và chưa đóng
                conn.close();  // Đóng kết nối
            }
        } catch (SQLException e) {
            e.printStackTrace();  // In ra lỗi nếu có
        }
    }

}
