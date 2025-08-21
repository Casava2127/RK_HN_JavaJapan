package databaseforMYSQL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class Bai2 extends JFrame {

    private JTextField txtInputInfo, txtSQL;
    private JTable table;
    private DefaultTableModel tableModel;

    public Bai2() {
        initUI();
    }

    private void initUI() {
        setTitle("Database Programming");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Tạo Input Panel
        JPanel inputPanel = createInputPanel();
        add(inputPanel, BorderLayout.NORTH);

        // Tạo bảng hiển thị
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Tạo Button Panel
        JPanel buttonPanel = createButtonPanel();
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input Information"));

        inputPanel.add(new JLabel("Input Information:"));
        txtInputInfo = new JTextField("jdbc:mysql://localhost:3306/quanlythuvien");
        inputPanel.add(txtInputInfo);

        inputPanel.add(new JLabel("SQL:"));
        txtSQL = new JTextField("SELECT * FROM book");
        inputPanel.add(txtSQL);

        return inputPanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();

        JButton btnSubmit = new JButton("Submit");
        JButton btnReset = new JButton("Reset");
        JButton btnCancel = new JButton("Cancel");

        buttonPanel.add(btnSubmit);
        buttonPanel.add(btnReset);
        buttonPanel.add(btnCancel);

        btnSubmit.addActionListener(e -> fetchDataFromDatabase());
        btnReset.addActionListener(e -> resetForm());
        btnCancel.addActionListener(e -> dispose());

        return buttonPanel;
    }

    private void fetchDataFromDatabase() {
        String inputInfo = txtInputInfo.getText();
        String sqlQuery = txtSQL.getText();

        if (inputInfo.isEmpty() || sqlQuery.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Thông tin kết nối hoặc câu SQL không được để trống.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // Tải driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Kết nối cơ sở dữ liệu
            try (Connection conn = DriverManager.getConnection(inputInfo, "root", "123456");
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sqlQuery)) {

                // Lấy metadata
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();

                // Tạo lại các cột
                String[] columnNames = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    columnNames[i - 1] = metaData.getColumnName(i);
                }
                tableModel.setColumnIdentifiers(columnNames);

                // Xóa dữ liệu cũ và thêm dữ liệu mới
                tableModel.setRowCount(0);
                while (rs.next()) {
                    Object[] rowData = new Object[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                        rowData[i - 1] = rs.getObject(i);
                    }
                    tableModel.addRow(rowData);
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Lỗi truy vấn SQL: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy driver MySQL!", "Driver Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void resetForm() {
        txtInputInfo.setText("jdbc:mysql://localhost:3306/ecommerce_db");
        txtSQL.setText("SELECT * FROM categories");
        tableModel.setRowCount(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Bai2 frame = new Bai2();
            frame.setVisible(true);
        });
    }
}
