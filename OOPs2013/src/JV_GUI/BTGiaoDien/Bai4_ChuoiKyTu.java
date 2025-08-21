package JV_GUI.BTGiaoDien;

import java.awt.*; // Thư viện để thiết kế giao diện
import java.awt.event.*; // Thư viện để xử lý sự kiện
import javax.swing.*; // Thư viện Swing để tạo giao diện hiện đại

@SuppressWarnings("serial")
class Bai4_ChuoiKyTu extends JFrame implements ActionListener {
	// Khai báo các thành phần giao diện
	JLabel lb1, lb2, lb3, lb4, lb5; // Các nhãn để hiển thị nội dung
	JTextField tField1, tField2, tField3, tField4, tField5; // Các ô nhập dữ liệu
	JButton okButton, resetButton, exitButton; // Các nút bấm
	JPanel pn1, pn2, pn; // Các panel để tổ chức bố cục

	// Constructor
	public Bai4_ChuoiKyTu(String title) {
		super(title); // Đặt tiêu đề cho JFrame
		GUI(); // Gọi hàm thiết kế giao diện
	}

	public void GUI() {
		// Khởi tạo các thành phần giao diện
		lb1 = new JLabel("Enter a String");         // Nhãn nhập chuỗi
		lb2 = new JLabel("To UpperCase");          // Nhãn hiển thị kết quả viết hoa
		lb3 = new JLabel("To LowerCase");          // Nhãn hiển thị kết quả viết thường
		lb4 = new JLabel("To LowUpper");           // Nhãn hiển thị kết quả đổi hoa-thường
		lb5 = new JLabel("Number of word");        // Nhãn hiển thị số từ trong chuỗi

		tField1 = new JTextField();                // Ô nhập chuỗi đầu vào
		tField2 = new JTextField();               // Ô hiển thị chuỗi viết hoa
		tField3 = new JTextField();               // Ô hiển thị chuỗi viết thường
		tField4 = new JTextField();               // Ô hiển thị chuỗi hoa-thường
		tField5 = new JTextField();               // Ô hiển thị số từ

		okButton = new JButton("OK");             // Nút xử lý chuỗi
		resetButton = new JButton("Reset");       // Nút xóa dữ liệu
		exitButton = new JButton("Exit");         // Nút thoát chương trình

		// Gắn các sự kiện cho nút
		okButton.addActionListener(this);
		resetButton.addActionListener(this);
		exitButton.addActionListener(this);

		// Tạo các panel và tổ chức bố cục
		pn = new JPanel(new GridLayout(2, 1));      // Panel chính chứa 2 phần
		pn1 = new JPanel(new GridLayout(5, 2));     // Panel chứa nhãn và ô nhập
		pn2 = new JPanel(new FlowLayout());         // Panel chứa các nút

		// Thêm nhãn và ô nhập vào panel pn1
		pn1.add(lb1); pn1.add(tField1);
		pn1.add(lb2); pn1.add(tField2);
		pn1.add(lb3); pn1.add(tField3);
		pn1.add(lb4); pn1.add(tField4);
		pn1.add(lb5); pn1.add(tField5);

		// Thêm các nút vào panel pn2
		pn2.add(okButton);
		pn2.add(resetButton);
		pn2.add(exitButton);

		// Thêm pn1 và pn2 vào panel chính
		pn.add(pn1);
		pn.add(pn2);

		// Đặt panel chính vào JFrame
		add(pn);

		// Cài đặt kích thước và hiển thị cửa sổ
		setSize(500, 300); // Đặt kích thước cửa sổ
		show(); // Hiển thị cửa sổ
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton) {
			// Lấy chuỗi nhập từ tField1
			String string = tField1.getText();

			// Đếm số từ trong chuỗi
			int count = 0;
			char SPACE = ' '; // Ký tự khoảng trắng
			int size = string.length();
			Boolean notCount = true;
			for (int i = 0; i < size; i++) {
				if (string.charAt(i) != SPACE) {
					if (notCount) {
						count++; // Đếm từ nếu gặp ký tự khác khoảng trắng
						notCount = false;
					}
				} else {
					notCount = true; // Đặt lại trạng thái khi gặp khoảng trắng
				}
			}

			// Chuyển chuỗi thành chữ hoa và chữ thường xen kẽ
			String string2 = string;
			char[] s = string2.toCharArray();
			string2 = "";
			for (int j = 0; j < s.length; j++) {
				int ascii = s[j];
				if (ascii >= 65 && ascii <= 90) { // Nếu là chữ hoa
					string2 += (char) (ascii += 32); // Chuyển sang chữ thường
				} else if (ascii >= 97 && ascii <= 122) { // Nếu là chữ thường
					string2 += (char) (ascii -= 32); // Chuyển sang chữ hoa
				} else {
					string2 += (char) (ascii); // Giữ nguyên ký tự khác
				}
			}

			// Hiển thị kết quả vào các ô tField
			tField2.setText(string.toUpperCase()); // Chuỗi chữ hoa
			tField3.setText(string.toLowerCase()); // Chuỗi chữ thường
			tField4.setText(string2); // Chuỗi hoa-thường
			tField5.setText(Integer.toString(count)); // Số từ trong chuỗi
		} else if (e.getSource() == resetButton) {
			// Xóa dữ liệu trong các ô nhập
			tField1.setText("");
			tField2.setText("");
			tField3.setText("");
			tField4.setText("");
			tField5.setText("");
		} else if (e.getSource() == exitButton) {
			// Thoát chương trình
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		// Tạo đối tượng giao diện và hiển thị
		new Bai4_ChuoiKyTu("Xử lý chuỗi ký tự");
	}
}
