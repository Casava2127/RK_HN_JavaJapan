package JV_GUI.BTGiaoDien;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Bai2_Arithmetic_Operations extends JFrame implements ActionListener {
	// Khai báo các thành phần giao diện
	JLabel lb1, lb2, lb3, lb;              // Nhãn (Label) để hiển thị thông tin
	JTextField txt1, txt2, txt3;           // Trường nhập liệu và hiển thị kết quả
	JButton cong, tru, nhan, chia, reset, exit; // Nút bấm cho các phép toán và chức năng khác
	JPanel pn1, pn2, pn3, pn4, pn;         // Các Panel để tổ chức bố cục giao diện

	public Bai2_Arithmetic_Operations(String title) {
		// Constructor: đặt tiêu đề cho cửa sổ và gọi phương thức tạo giao diện
		super(title);
		GUI();
	}

	public void GUI() {
		// Tạo và sắp xếp giao diện

		// Tạo nhãn
		lb = new JLabel("Basic Arithmetic Operations"); // Tiêu đề của ứng dụng
		lb1 = new JLabel("Number 1:");                  // Nhãn cho số thứ nhất
		lb2 = new JLabel("Number 2:");                  // Nhãn cho số thứ hai
		lb3 = new JLabel("Result:");                    // Nhãn cho kết quả

		// Tạo các trường nhập liệu
		txt1 = new JTextField(); // Trường nhập số thứ nhất
		txt2 = new JTextField(); // Trường nhập số thứ hai
		txt3 = new JTextField(); // Trường hiển thị kết quả

		// Tạo các nút bấm
		cong = new JButton("Addition");          // Nút cộng
		tru = new JButton("Subtraction");        // Nút trừ
		nhan = new JButton("Multiplication");    // Nút nhân
		chia = new JButton("Division");          // Nút chia
		reset = new JButton("Reset");            // Nút xóa dữ liệu
		exit = new JButton("Exit");              // Nút thoát ứng dụng

		// Đăng ký sự kiện cho các nút
		cong.addActionListener(this);
		tru.addActionListener(this);
		nhan.addActionListener(this);
		chia.addActionListener(this);
		reset.addActionListener(this);
		exit.addActionListener(this);

		// Tạo các panel và bố trí các thành phần
		pn = new JPanel(new GridLayout(4, 1));            // Panel chính với 4 hàng
		pn1 = new JPanel();                               // Panel chứa tiêu đề
		pn2 = new JPanel(new GridLayout(3, 2));           // Panel chứa nhãn và trường nhập
		pn3 = new JPanel(new FlowLayout());               // Panel chứa các nút phép toán
		pn4 = new JPanel(new FlowLayout());               // Panel chứa các nút chức năng khác

		// Thêm tiêu đề vào panel pn1
		pn1.add(lb);

		// Thêm nhãn và trường nhập vào panel pn2
		pn2.add(lb1);    // Nhãn "Number 1:"
		pn2.add(txt1);   // Trường nhập số thứ nhất
		pn2.add(lb2);    // Nhãn "Number 2:"
		pn2.add(txt2);   // Trường nhập số thứ hai
		pn2.add(lb3);    // Nhãn "Result:"
		pn2.add(txt3);   // Trường hiển thị kết quả

		// Thêm các nút phép toán vào panel pn3
		pn3.add(cong);    // Nút "Addition"
		pn3.add(tru);     // Nút "Subtraction"
		pn3.add(nhan);    // Nút "Multiplication"
		pn3.add(chia);    // Nút "Division"

		// Thêm các nút chức năng vào panel pn4
		pn4.add(reset);   // Nút "Reset"
		pn4.add(exit);    // Nút "Exit"

		// Thêm các panel con vào panel chính
		pn.add(pn1); // Thêm panel chứa tiêu đề
		pn.add(pn2); // Thêm panel chứa nhãn và trường nhập
		pn.add(pn3); // Thêm panel chứa các nút phép toán
		pn.add(pn4); // Thêm panel chứa các nút chức năng khác

		// Thêm panel chính vào JFrame
		add(pn);

		// Cài đặt kích thước và hiển thị cửa sổ
		setSize(500, 300); // Kích thước cửa sổ 500x300 pixel
		show();            // Hiển thị cửa sổ
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Xử lý sự kiện cho các nút bấm

		if (e.getSource() == cong) {
			// Thực hiện phép cộng
			int a = Integer.parseInt(txt1.getText()); // Lấy giá trị số thứ nhất
			int b = Integer.parseInt(txt2.getText()); // Lấy giá trị số thứ hai
			txt3.setText(Integer.toString(a + b));    // Hiển thị kết quả cộng
		}
		if (e.getSource() == tru) {
			// Thực hiện phép trừ
			int a = Integer.parseInt(txt1.getText());
			int b = Integer.parseInt(txt2.getText());
			txt3.setText(Integer.toString(a - b));    // Hiển thị kết quả trừ
		}
		if (e.getSource() == nhan) {
			// Thực hiện phép nhân
			int a = Integer.parseInt(txt1.getText());
			int b = Integer.parseInt(txt2.getText());
			txt3.setText(Integer.toString(a * b));    // Hiển thị kết quả nhân
		}
		if (e.getSource() == chia) {
			// Thực hiện phép chia
			int a = Integer.parseInt(txt1.getText());
			int b = Integer.parseInt(txt2.getText());
			txt3.setText(Float.toString((float) a / b)); // Hiển thị kết quả chia
		}
		if (e.getSource() == reset) {
			// Xóa dữ liệu các trường nhập và kết quả
			txt1.setText("");
			txt2.setText("");
			txt3.setText("");
		}
		if (e.getSource() == exit) {
			// Thoát ứng dụng
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		// Điểm bắt đầu của chương trình
		new Bai2_Arithmetic_Operations("Arithmetic Operations");
		// Tạo đối tượng ứng dụng và khởi chạy giao diện
	}
}
