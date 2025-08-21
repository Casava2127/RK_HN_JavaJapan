package JV_GUI.Layout_Manager;

import javax.swing.*;
import java.awt.*;

public class GridLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridLayout Example");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Đặt GridLayout (2 hàng, 3 cột)
        frame.setLayout(new GridLayout(2, 3, 5, 5));

        // Thêm các thành phần
        for (int i = 1; i <= 6; i++) {
            frame.add(new JButton("Button " + i));
        }

        frame.setVisible(true);
    }
}
