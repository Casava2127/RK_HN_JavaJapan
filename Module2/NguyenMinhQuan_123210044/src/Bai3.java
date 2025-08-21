import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Bai3 extends JFrame {

    // Các thành phần giao diện chính
    private JTextField inputInfoField; // Ô nhập thông tin kết nối CSDL
    private JComboBox<String> sqlDropdown; // Dropdown chọn lệnh SQL
    private JTextField sqlField; // Ô nhập câu truy vấn SQL
    private JTable resultTable; // Bảng hiển thị kết quả
    private DefaultTableModel tableModel; // Mô hình dữ liệu của bảng

    public Bai3() {
        // Cấu hình cửa sổ
        setTitle("Database Programming"); // Tiêu đề
        setSize(600, 400); // Kích thước cửa sổ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Thoát khi đóng cửa sổ
        setLayout(new BorderLayout()); // Sử dụng BorderLayout

        // Tạo Input Panel để nhập thông tin kết nối và truy vấn SQL
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Input Information:")); // Nhãn cho chuỗi kết nối
        inputInfoField = new JTextField("jdbc:mysql://127.0.0.1:3306/quanlythuvien"); // Chuỗi kết nối mặc định
        inputPanel.add(inputInfoField);

        inputPanel.add(new JLabel("SQL Query:")); // Nhãn cho câu truy vấn SQL

        // Dropdown chọn lệnh SQL và hành động khi chọn
        sqlDropdown = new JComboBox<>(new String[]{"SELECT", "INSERT", "UPDATE", "DELETE"});
        sqlDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCommand = (String) sqlDropdown.getSelectedItem();
                switch (selectedCommand) {
                    case "SELECT":
                        sqlField.setText("SELECT * FROM book"); // Lệnh SELECT mặc định
                        break;
                    case "INSERT":
                        sqlField.setText("INSERT INTO booktype (TypeId, TypeName, Description, IsDeleted) VALUES ('1','Truyen', '123 ABC St', 1)");
                        break; // Lệnh INSERT mặc định
                    case "UPDATE":
                        sqlField.setText("UPDATE booktype SET Total = 2000 WHERE id = 1"); // Lệnh UPDATE mặc định
                        break;
                    case "DELETE":
                        sqlField.setText("DELETE FROM booktype WHERE id = 1"); // Lệnh DELETE mặc định
                        break;
                }
            }
        });

        // Ô nhập câu truy vấn và Dropdown
        JPanel sqlPanel = new JPanel(new BorderLayout());
        sqlField = new JTextField("SELECT * FROM booktype"); // Lệnh SQL mặc định
        sqlPanel.add(sqlField, BorderLayout.CENTER); // Ô nhập truy vấn
        sqlPanel.add(sqlDropdown, BorderLayout.EAST); // Dropdown lệnh SQL
        inputPanel.add(sqlPanel);
        add(inputPanel, BorderLayout.NORTH); // Đặt Input Panel ở phía trên

        // Tạo bảng hiển thị kết quả với các cột mặc định
        tableModel = new DefaultTableModel();
        resultTable = new JTable(tableModel);
        add(new JScrollPane(resultTable), BorderLayout.CENTER); // Đặt bảng ở giữa

        // Tạo Button Panel để chứa các nút điều khiển
        JPanel buttonPanel = new JPanel();

        // Nút Submit để thực hiện truy vấn
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeQuery(); // Thực thi truy vấn khi nhấn nút
            }
        });
        buttonPanel.add(submitButton);

        // Nút Reset để xóa dữ liệu và làm lại từ đầu
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputInfoField.setText("jdbc:mysql://127.0.0.1:3306/quanlythuvien"); // Đặt lại chuỗi kết nối mặc định
                sqlField.setText("SELECT * FROM book"); // Đặt lại câu truy vấn mặc định
                tableModel.setRowCount(0); // Xóa dữ liệu trong bảng
                tableModel.setColumnCount(0); // Xóa luôn tên cột
            }
        });

        buttonPanel.add(resetButton);

        // Nút Cancel để thoát chương trình
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Thoát chương trình
            }
        });
        buttonPanel.add(cancelButton);

        add(buttonPanel, BorderLayout.SOUTH); // Đặt Button Panel ở phía dưới
    }

    // Phương thức thực hiện câu truy vấn SQL
    private void executeQuery() {
        String dbUrl = inputInfoField.getText(); // Lấy chuỗi kết nối từ ô nhập
        String sql = sqlField.getText(); // Lấy câu truy vấn từ ô nhập

        try (Connection conn = DriverManager.getConnection(dbUrl, "root", "123456"); // Kết nối CSDL
             Statement stmt = conn.createStatement()) { // Tạo Statement để thực thi câu truy vấn

            if (sql.trim().toUpperCase().startsWith("SELECT")) { // Kiểm tra nếu là câu lệnh SELECT
                ResultSet rs = stmt.executeQuery(sql); // Thực thi SELECT
                tableModel.setRowCount(0); // Xóa dữ liệu cũ trong bảng

                ResultSetMetaData metaData = rs.getMetaData(); // Lấy metadata của kết quả
                int columnCount = metaData.getColumnCount(); // Đếm số cột trong kết quả

                // Tạo mảng tên cột dựa trên metadata
                String[] columnNames = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    columnNames[i - 1] = metaData.getColumnName(i); // Lấy tên từng cột
                }
                tableModel.setColumnIdentifiers(columnNames);
                tableModel.setRowCount(0);
                while (rs.next()) { // Duyệt qua từng hàng kết quả
                    Object[] rowData = new Object[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                        rowData[i - 1] = rs.getObject(i); // Lấy giá trị từng cột
                    }
                    tableModel.addRow(rowData); // Thêm hàng vào bảng
                }
            } else { // Nếu không phải SELECT
                int affectedRows = stmt.executeUpdate(sql); // Thực thi câu lệnh (INSERT, UPDATE, DELETE)
                JOptionPane.showMessageDialog(this, "Query executed. Affected rows: " + affectedRows);
            }
        } catch (SQLException e) { // Bắt lỗi nếu có
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() { // Chạy giao diện trong luồng sự kiện
            @Override
            public void run() {
                new Bai3().setVisible(true); // Hiển thị giao diện
            }
        });
    }
}
