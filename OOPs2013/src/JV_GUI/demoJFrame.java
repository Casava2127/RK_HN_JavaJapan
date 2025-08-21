package JV_GUI;

import javax.swing.*;

public class demoJFrame {
    public static void main(String[] args) {
        // Tạo JFrame (Container chính)
        JFrame frame = new JFrame("Demo Container");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo JPanel (Container phụ)
        JPanel panel = new JPanel();

        // Thêm thành phần vào JPanel
        panel.add(new JLabel("Welcome!"));
        panel.add(new JButton("Click Me"));

        // Thêm JPanel vào JFrame
        frame.add(panel);

        // Hiển thị JFrame
        frame.setVisible(true);
    }
}
