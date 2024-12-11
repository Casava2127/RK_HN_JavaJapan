package JV_GUI.Layout_Manager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CardLayout Example");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo CardLayout
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // Thêm các "thẻ"
        cardPanel.add(new JButton("Card 1"), "Card1");
        cardPanel.add(new JButton("Card 2"), "Card2");
        cardPanel.add(new JButton("Card 3"), "Card3");

        // Thêm nút để chuyển đổi giữa các thẻ
        JPanel buttonPanel = new JPanel();
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e -> cardLayout.next(cardPanel));
        buttonPanel.add(nextButton);

        frame.setLayout(new BorderLayout());
        frame.add(cardPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}

//Chỉ hiển thị một "thẻ" tại một thời điểm.
//Thích hợp cho giao diện có nhiều màn hình hoặc tab ẩn