package databaseforMYSQL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class bai4 extends JFrame {
    private JTextField searchField;
    private JRadioButton idRadioButton, nameRadioButton, dateRadioButton, addressRadioButton, genderRadioButton;
    private JTable resultTable;
    private DefaultTableModel tableModel;

    public bai4() {
        setTitle("Database Search");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Search Panel
        JPanel searchPanel = new JPanel();
        searchField = new JTextField(20);
        searchPanel.add(new JLabel("Nhap noi dung:"));
        searchPanel.add(searchField);

        // Radio Buttons for Search Criteria
        idRadioButton = new JRadioButton("Id");
        nameRadioButton = new JRadioButton("Name");
        dateRadioButton = new JRadioButton("Date");
        addressRadioButton = new JRadioButton("Address");
        genderRadioButton = new JRadioButton("Gender");

        ButtonGroup group = new ButtonGroup();
        group.add(idRadioButton);
        group.add(nameRadioButton);
        group.add(dateRadioButton);
        group.add(addressRadioButton);
        group.add(genderRadioButton);

        searchPanel.add(idRadioButton);
        searchPanel.add(nameRadioButton);
        searchPanel.add(dateRadioButton);
        searchPanel.add(addressRadioButton);
        searchPanel.add(genderRadioButton);

        add(searchPanel, BorderLayout.NORTH);

        // Table Model and Table
        tableModel = new DefaultTableModel(new Object[] { "Id", "Name", "Date", "Address", "Gender" }, 0);
        resultTable = new JTable(tableModel);
        add(new JScrollPane(resultTable), BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchDatabase();
            }
        });
        buttonPanel.add(searchButton);

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchField.setText("");
                group.clearSelection();
                tableModel.setRowCount(0);
            }
        });
        buttonPanel.add(resetButton);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void searchDatabase() {
        String keyword = searchField.getText();
        String searchColumn = "";

        if (idRadioButton.isSelected()) {
            searchColumn = "Id";
        } else if (nameRadioButton.isSelected()) {
            searchColumn = "Name";
        } else if (dateRadioButton.isSelected()) {
            searchColumn = "Date";
        } else if (addressRadioButton.isSelected()) {
            searchColumn = "Address";
        } else if (genderRadioButton.isSelected()) {
            searchColumn = "Gender";
        }

        if (!searchColumn.isEmpty()) {
            String query = "SELECT * FROM bai4 WHERE " + searchColumn + " LIKE ?";

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/giaodien", "root",
                    "minhbeo123");
                    PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setString(1, "%" + keyword + "%");
                ResultSet rs = stmt.executeQuery();

                tableModel.setRowCount(0); // Clear existing data

                while (rs.next()) {
                    int id = rs.getInt("Id");
                    String name = rs.getString("Name");
                    Date date = rs.getDate("Date");
                    String address = rs.getString("Address");
                    String gender = rs.getString("Gender");
                    tableModel.addRow(new Object[] { id, name, date, address, gender });
                }

                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new bai4().setVisible(true);
            }
        });
    }
}
