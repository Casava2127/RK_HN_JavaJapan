package ThiCK;

import javax.swing.*;
import java.awt.*;

public class CourseManagement {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Courses Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Courses Management", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));

        JButton addButton = new JButton("Add New Course");
        JButton searchButton = new JButton("Search Course");
        JButton displayButton = new JButton("Display All Courses");
        JButton exitButton = new JButton("Exit");

        buttonPanel.add(addButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(exitButton);

        frame.add(buttonPanel, BorderLayout.CENTER);

        addButton.addActionListener(e -> new AddCourse());
        searchButton.addActionListener(e -> new SearchCourse());
        displayButton.addActionListener(e -> new ListCourse());
        exitButton.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }
}
