package JV_GUI.BTGiaoDien;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class Bai3_Color extends JFrame implements ActionListener {
	// Khai báo các thành phần giao diện
	JPanel main = new JPanel(new BorderLayout(11, 11)); // Panel chính, sử dụng BorderLayout
	JPanel panbtn = new JPanel();   // Panel chứa các nút bấm
	JPanel panta = new JPanel();    // Panel chứa vùng nhập liệu
//	JTextArea tArea = new JTextArea(); // Vùng nhập liệu
	JButton jbtnRed = new JButton("RED");   // Nút bấm chuyển sang màu đỏ
	JButton jbtnGreen = new JButton("GREEN"); // Nút bấm chuyển sang màu xanh lá
	JButton jbtnBlue = new JButton("BLUE"); // Nút bấm chuyển sang màu xanh dương
	JButton jbtnExit = new JButton("Exit"); // Nút bấm thoát ứng dụng

	// Constructor khởi tạo giao diện
	public Bai3_Color(String title) {
		super(title); // Đặt tiêu đề cho cửa sổ JFrame

		// Thêm các nút bấm vào panel "panbtn"
		panbtn.add(jbtnRed);   // Thêm nút "RED"
		panbtn.add(jbtnGreen); // Thêm nút "GREEN"
		panbtn.add(jbtnBlue);  // Thêm nút "BLUE"
		panbtn.add(jbtnExit);  // Thêm nút "Exit"

		// Gắn sự kiện lắng nghe cho các nút bấm
		jbtnRed.addActionListener(this);   // Sự kiện khi nhấn nút "RED"
		jbtnGreen.addActionListener(this); // Sự kiện khi nhấn nút "GREEN"
		jbtnBlue.addActionListener(this);  // Sự kiện khi nhấn nút "BLUE"
		jbtnExit.addActionListener(this);  // Sự kiện khi nhấn nút "Exit"

		// Thêm vùng nhập liệu "tArea" vào panel "panta"
//		panta.add(tArea);

		// Thêm các panel con vào panel chính "main"
		main.add("North", panta); // Panel chứa vùng nhập liệu ở phía trên
		main.add("South", panbtn); // Panel chứa các nút bấm ở phía dưới

		// Cài đặt panel chính "main" làm nội dung của JFrame
		setContentPane(main);

		// Đặt kích thước và vị trí của cửa sổ
		pack(); // Tự động điều chỉnh kích thước vừa đủ để hiển thị các thành phần
		setBounds(100, 100, 450, 300); // Đặt vị trí (100, 100) và kích thước (450x300)

		// Hiển thị cửa sổ
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Xử lý sự kiện khi người dùng nhấn các nút
		if (e.getSource() == jbtnRed) {
			// Nếu nhấn nút "RED", thay đổi màu nền thành đỏ
			panta.setBackground(Color.RED); // Thay đổi màu nền panel chứa vùng nhập liệu
			panbtn.setBackground(Color.RED); // Thay đổi màu nền panel chứa các nút bấm
			main.setBackground(Color.RED);   // Thay đổi màu nền panel chính
		} else if (e.getSource() == jbtnGreen) {
			// Nếu nhấn nút "GREEN", thay đổi màu nền thành xanh lá
			panta.setBackground(Color.GREEN);
			panbtn.setBackground(Color.GREEN);
			main.setBackground(Color.GREEN);
		} else if (e.getSource() == jbtnBlue) {
			// Nếu nhấn nút "BLUE", thay đổi màu nền thành xanh dương
			panta.setBackground(Color.BLUE);
			panbtn.setBackground(Color.BLUE);
			main.setBackground(Color.BLUE);
		} else if (e.getSource() == jbtnExit) {
			// Nếu nhấn nút "Exit", đóng cửa sổ
			this.dispose(); // Đóng JFrame hiện tại
		}
	}

	public static void main(String[] args) {
		// Điểm bắt đầu của chương trình
		new Bai3_Color("Changed Background Color");
		// Tạo đối tượng giao diện và hiển thị
	}
}
