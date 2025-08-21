package ThiCK;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddCourse {
    public AddCourse() {
        JFrame frame = new JFrame("Add New Course");
        frame.setSize(400, 250);
        frame.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel codeLabel = new JLabel("Code:");
        JTextField codeField = new JTextField();
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel creditLabel = new JLabel("Credit:");
        JTextField creditField = new JTextField();

        JButton addButton = new JButton("Add");
        JButton clearButton = new JButton("Clear");

        frame.add(codeLabel);
        frame.add(codeField);
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(creditLabel);
        frame.add(creditField);
        frame.add(addButton);
        frame.add(clearButton);

        addButton.addActionListener(e -> {
            String code = codeField.getText();
            String name = nameField.getText();
            int credit = Integer.parseInt(creditField.getText());

            try (Connection conn = DatabaseConnection.getConnection()) {
                String sql = "INSERT INTO Course (code, name, credit) VALUES (?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, code);
                stmt.setString(2, name);
                stmt.setInt(3, credit);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(frame, "Course added successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        clearButton.addActionListener(e -> {
            codeField.setText("");
            nameField.setText("");
            creditField.setText("");
        });

        frame.setVisible(true);
    }
}

