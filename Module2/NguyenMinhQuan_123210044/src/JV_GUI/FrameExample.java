package JV_GUI;

import java.awt.*;

public class FrameExample {
    public static void main(String[] args) {
        // Tạo một Frame
        Frame frame = new Frame("Demo Frame");
        frame.setSize(400, 300); // Đặt kích thước
        frame.setLayout(new FlowLayout()); // Sử dụng FlowLayout

        // Thêm một Button vào Frame
        Button button = new Button("Click Me");
        frame.add(button);

        // Hiển thị Frame
        frame.setVisible(true);
    }
}
