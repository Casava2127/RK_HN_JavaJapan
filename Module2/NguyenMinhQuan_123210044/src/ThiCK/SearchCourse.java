package ThiCK;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchCourse {
    public SearchCourse() {
        JFrame frame = new JFrame("Search Course");
        frame.setSize(400, 250);
        frame.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel codeLabel = new JLabel("Enter Code:");
        JTextField codeField = new JTextField();
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel creditLabel = new JLabel("Credit:");
        JTextField creditField = new JTextField();

        nameField.setEditable(false);
        creditField.setEditable(false);

        JButton searchButton = new JButton("Search");

        frame.add(codeLabel);
        frame.add(codeField);
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(creditLabel);
        frame.add(creditField);
        frame.add(searchButton);

        searchButton.addActionListener(e -> {
            String code = codeField.getText();

            try (Connection conn = DatabaseConnection.getConnection()) {
                String sql = "SELECT name, credit FROM Course WHERE code = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, code);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    nameField.setText(rs.getString("name"));
                    creditField.setText(String.valueOf(rs.getInt("credit")));
                } else {
                    JOptionPane.showMessageDialog(frame, "Course not found!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        frame.setVisible(true);
    }
}
