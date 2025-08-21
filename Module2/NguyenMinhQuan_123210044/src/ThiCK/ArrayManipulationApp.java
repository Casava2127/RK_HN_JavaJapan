package ThiCK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayManipulationApp {

    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Array Manipulation");
        frame.setSize(600,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 1));

        // Input panel
        JPanel inputPanel = new JPanel();
        JLabel inputLabel = new JLabel("Nhập vào mảng:");
        JTextField inputField = new JTextField(20);
        inputPanel.add(inputLabel);
        inputPanel.add(inputField);

        // Result panel
        JPanel resultPanel = new JPanel();
        JLabel resultLabel = new JLabel("Kết quả:");
        JTextField resultField = new JTextField(20);
        resultField.setEditable(false);
        resultPanel.add(resultLabel);
        resultPanel.add(resultField);

        // Remove element panel
        JPanel removePanel = new JPanel();
        JLabel removeLabel = new JLabel("Loại bỏ phần tử thứ:");
        JTextField removeField = new JTextField(5);
        removePanel.add(removeLabel);
        removePanel.add(removeField);

        // Button panel
        JPanel buttonPanel = new JPanel();
        JButton reverseButton = new JButton("Đảo Ngược mảng");
        JButton removeButton = new JButton("Loại bỏ phần tử");
        JButton resetButton = new JButton("Reset");
        JButton exitButton = new JButton("Exit");
        buttonPanel.add(reverseButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(exitButton);

        // Add panels to frame
        frame.add(inputPanel);
        frame.add(resultPanel);
        frame.add(removePanel);
        frame.add(buttonPanel);

        // Action listeners
        reverseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                if (!input.isEmpty()) {
                    try {
                        String[] parts = input.split(",");
                        ArrayList<Integer> array = new ArrayList<>();
                        for (String part : parts) {
                            array.add(Integer.parseInt(part.trim()));
                        }
                        // Reverse array
                        for (int i = 0; i < array.size() / 2; i++) {
                            int temp = array.get(i);
                            array.set(i, array.get(array.size() - 1 - i));
                            array.set(array.size() - 1 - i, temp);
                        }
                        resultField.setText(array.toString());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Vui lòng nhập đúng định dạng số nguyên cách nhau bởi dấu ','", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Vui lòng nhập mảng trước", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                String removeIndexStr = removeField.getText();
                if (!input.isEmpty() && !removeIndexStr.isEmpty()) {
                    try {
                        String[] parts = input.split(",");
                        ArrayList<Integer> array = new ArrayList<>();
                        for (String part : parts) {
                            array.add(Integer.parseInt(part.trim()));
                        }
                        int removeIndex = Integer.parseInt(removeIndexStr.trim()); // Keep as 0-based index
                        if (removeIndex >= 0 && removeIndex < array.size()) {
                            array.remove(removeIndex);
                            resultField.setText(array.toString());
                        } else {
                            JOptionPane.showMessageDialog(frame, "Vị trí không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Vui lòng nhập số nguyên hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Vui lòng nhập mảng và vị trí cần loại bỏ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");
                resultField.setText("");
                removeField.setText("");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Show frame
        frame.setVisible(true);
    }
}
