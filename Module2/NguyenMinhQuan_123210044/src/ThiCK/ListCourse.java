package ThiCK;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListCourse {
    private JTable table;
    private DefaultTableModel model;
    private int currentRowIndex = -1; // Lưu vị trí hiện tại của dòng được chọn

    public ListCourse() {
        JFrame frame = new JFrame("Display All Courses");
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Tạo bảng dữ liệu
        String[] columnNames = {"Code", "Name", "Credit"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Tải dữ liệu từ CSDL
        loadData();

        // Tạo thanh cuộn cho bảng
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Panel chứa các nút điều khiển
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton firstButton = new JButton("Move First");
        JButton nextButton = new JButton("Move Next");
        JButton previousButton = new JButton("Move Previous");
        JButton lastButton = new JButton("Move Last");

        buttonPanel.add(firstButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(previousButton);
        buttonPanel.add(lastButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Xử lý sự kiện cho các nút
        firstButton.addActionListener(e -> moveToFirstRow());
        nextButton.addActionListener(e -> moveToNextRow());
        previousButton.addActionListener(e -> moveToPreviousRow());
        lastButton.addActionListener(e -> moveToLastRow());

        frame.setVisible(true);
    }

    // Tải dữ liệu từ CSDL
    private void loadData() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM Course";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("code"),
                        rs.getString("name"),
                        rs.getInt("credit")
                });
            }
            // Đặt dòng đầu tiên được chọn mặc định
            if (model.getRowCount() > 0) {
                currentRowIndex = 0;
                table.setRowSelectionInterval(currentRowIndex, currentRowIndex);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    // Di chuyển đến dòng đầu tiên
    private void moveToFirstRow() {
        if (model.getRowCount() > 0) {
            currentRowIndex = 0;
            table.setRowSelectionInterval(currentRowIndex, currentRowIndex);
            table.scrollRectToVisible(table.getCellRect(currentRowIndex, 0, true));
        }
    }

    // Di chuyển đến dòng tiếp theo
    private void moveToNextRow() {
        if (currentRowIndex < model.getRowCount() - 1) {
            currentRowIndex++;
            table.setRowSelectionInterval(currentRowIndex, currentRowIndex);
            table.scrollRectToVisible(table.getCellRect(currentRowIndex, 0, true));
        }
    }

    // Di chuyển đến dòng trước đó
    private void moveToPreviousRow() {
        if (currentRowIndex > 0) {
            currentRowIndex--;
            table.setRowSelectionInterval(currentRowIndex, currentRowIndex);
            table.scrollRectToVisible(table.getCellRect(currentRowIndex, 0, true));
        }
    }

    // Di chuyển đến dòng cuối cùng
    private void moveToLastRow() {
        if (model.getRowCount() > 0) {
            currentRowIndex = model.getRowCount() - 1;
            table.setRowSelectionInterval(currentRowIndex, currentRowIndex);
            table.scrollRectToVisible(table.getCellRect(currentRowIndex, 0, true));
        }
    }
}
