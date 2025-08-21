package JV_GUI.Layout_Manager;

import javax.swing.*;
import java.awt.*;

public class GridBagLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridBagLayout Example");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Đặt GridBagLayout
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Thêm Button 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        frame.add(new JButton("Button 1"), gbc);

        // Thêm Button 2
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        frame.add(new JButton("Button 2"), gbc);

        // Thêm Button 3
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        frame.add(new JButton("Button 3"), gbc);

        frame.setVisible(true);
    }
}
