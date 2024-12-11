package JV_GUI.BTGiaoDien;

import java.awt.*;

public class PanelExample {
    public static void main(String[] args) {
        // Tạo Frame
        Frame frame = new Frame("Demo Panel");
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        // Tạo Panel
        Panel panel = new Panel();
        panel.setLayout(new FlowLayout());

        // Thêm các thành phần vào Panel
        panel.add(new Button("Button 1"));
        panel.add(new Button("Button 2"));

        // Thêm Panel vào Frame
        frame.add(panel);

        // Hiển thị Frame
        frame.setVisible(true);
    }
}
