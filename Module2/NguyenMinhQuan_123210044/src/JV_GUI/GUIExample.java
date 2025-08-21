package JV_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIExample extends JFrame {

    private JLabel nameLabel, passwordLabel, genderLabel, hobbyLabel;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JComboBox<String> layoutComboBox;
    private JPanel panel;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private JCheckBox readingCheckBox, sportsCheckBox, musicCheckBox;

    public GUIExample() {
        // Khởi tạo giao diện người dùng
        setTitle("Enhanced GUI Example");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo các thành phần giao diện
        nameLabel = new JLabel("Họ và tên: ");
        passwordLabel = new JLabel("Mật khẩu: ");
        genderLabel = new JLabel("Giới tính: ");
        hobbyLabel = new JLabel("Sở thích: ");

        nameField = new JTextField(20);
        passwordField = new JPasswordField(20);

        textArea = new JTextArea(5, 20);
        scrollPane = new JScrollPane(textArea);

        layoutComboBox = new JComboBox<>(new String[]{"Border Layout", "Flow Layout", "Grid Layout"});
        panel = new JPanel();

        // Radio buttons for gender
        maleRadioButton = new JRadioButton("Nam");
        femaleRadioButton = new JRadioButton("Nữ");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        // Checkboxes for hobbies
        readingCheckBox = new JCheckBox("Đọc sách");
        sportsCheckBox = new JCheckBox("Thể thao");
        musicCheckBox = new JCheckBox("Âm nhạc");

        // Thiết lập ActionListener cho JComboBox
        layoutComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedLayout = (String) layoutComboBox.getSelectedItem();
                switch (selectedLayout) {
                    case "Border Layout":
                        panel.setLayout(new BorderLayout());
                        panel.removeAll();
                        panel.add(nameLabel, BorderLayout.NORTH);
                        panel.add(nameField, BorderLayout.CENTER);
                        panel.add(passwordLabel, BorderLayout.SOUTH);
                        panel.add(passwordField, BorderLayout.SOUTH);
                        break;

                    case "Flow Layout":
                        panel.setLayout(new FlowLayout());
                        panel.removeAll();
                        panel.add(nameLabel);
                        panel.add(nameField);
                        panel.add(passwordLabel);
                        panel.add(passwordField);
                        break;

                    case "Grid Layout":
                        panel.setLayout(new GridLayout(4, 2));
                        panel.removeAll();
                        panel.add(nameLabel);
                        panel.add(nameField);
                        panel.add(passwordLabel);
                        panel.add(passwordField);
                        panel.add(genderLabel);
                        panel.add(maleRadioButton);
                        panel.add(femaleRadioButton);
                        panel.add(hobbyLabel);
                        panel.add(readingCheckBox);
                        panel.add(sportsCheckBox);
                        panel.add(musicCheckBox);
                        break;
                }
                panel.revalidate();
                panel.repaint();
            }
        });

        // Thiết lập layout mặc định cho panel là BorderLayout
        panel.setLayout(new BorderLayout());
        panel.add(nameLabel, BorderLayout.NORTH);
        panel.add(nameField, BorderLayout.CENTER);
        panel.add(passwordLabel, BorderLayout.SOUTH);
        panel.add(passwordField, BorderLayout.SOUTH);

        // Thêm các thành phần vào cửa sổ
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(layoutComboBox, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        // Khởi tạo và hiển thị giao diện
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUIExample().setVisible(true);
            }
        });
    }
}
