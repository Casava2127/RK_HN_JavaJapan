package JV_GUI.Layout_Manager;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FlowLayout Example");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Đặt FlowLayout cho container
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Thêm các thành phần
        for (int i = 1; i <= 5; i++) {
            frame.add(new JButton("Button " + i));
        }

        frame.setVisible(true);
    }
}
//Sắp xếp các thành phần từ trái sang phải.
//Căn chỉnh theo center, left, hoặc right (mặc định là center).
//Tự động xuống dòng nếu không đủ không gian.