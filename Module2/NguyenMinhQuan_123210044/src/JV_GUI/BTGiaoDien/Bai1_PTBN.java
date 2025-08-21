package JV_GUI.BTGiaoDien;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Bai1_PTBN extends Frame implements ActionListener {
	// Khai báo các thành phần giao diện
	Label lb1, lb2, lb3, lb;       // Các nhãn (Label) hiển thị thông tin
	TextField txta, txtb, txtkq;   // Các trường nhập liệu và kết quả
	Button tinh, reset, thoat;     // Các nút chức năng
	Panel pn, pn1, pn2, pn3;       // Các panel để tổ chức bố cục

	@SuppressWarnings("deprecation")
	public void GUI() {
		// Tạo tiêu đề
		lb = new Label("GIAI PHUONG TRINH BAC NHAT"); // Nhãn tiêu đề của ứng dụng
		lb1 = new Label("Nhap a: ");                  // Nhãn nhập hệ số a
		lb2 = new Label("Nhap b: ");                  // Nhãn nhập hệ số b
		lb3 = new Label("Ket qua: ");                 // Nhãn hiển thị kết quả

		// Tạo các trường nhập liệu
		txta = new TextField(7);   // Trường nhập liệu cho hệ số a (7 ký tự)
		txtb = new TextField(7);   // Trường nhập liệu cho hệ số b (7 ký tự)
		txtkq = new TextField();   // Trường hiển thị kết quả

		// Tạo các nút bấm
		tinh = new Button("Tinh");     // Nút tính nghiệm phương trình
		reset = new Button("Reset");   // Nút xóa dữ liệu
		thoat = new Button("Thoat");   // Nút thoát ứng dụng

		// Đăng ký sự kiện cho các nút
		tinh.addActionListener(this);  // Đăng ký sự kiện cho nút "Tinh"
		reset.addActionListener(this); // Đăng ký sự kiện cho nút "Reset"
		thoat.addActionListener(this); // Đăng ký sự kiện cho nút "Thoat"

		// Tạo các panel để tổ chức bố cục
		pn = new Panel(new GridLayout(3, 1));         // Panel chính, chứa 3 hàng
		pn1 = new Panel(new FlowLayout());            // Panel chứa tiêu đề
		pn2 = new Panel(new GridLayout(3, 2));        // Panel chứa nhãn và trường nhập
		pn3 = new Panel(new GridLayout(1, 3));        // Panel chứa các nút bấm

		// Thêm tiêu đề vào panel pn1
		pn1.add(lb);

		// Thêm các nhãn và trường nhập vào panel pn2
		pn2.add(lb1);  // Nhãn "Nhập a:"
		pn2.add(txta); // Trường nhập "a"
		pn2.add(lb2);  // Nhãn "Nhập b:"
		pn2.add(txtb); // Trường nhập "b"
		pn2.add(lb3);  // Nhãn "Kết quả:"
		pn2.add(txtkq); // Trường hiển thị kết quả

		// Thêm các nút vào panel pn3
		pn3.add(tinh);  // Nút "Tinh"
		pn3.add(reset); // Nút "Reset"
		pn3.add(thoat); // Nút "Thoat"

		// Thêm các panel con vào panel chính
		pn.add(pn1); // Thêm panel tiêu đề
		pn.add(pn2); // Thêm panel nhập liệu
		pn.add(pn3); // Thêm panel nút bấm

		// Thêm panel chính vào Frame
		add(pn);

		// Cài đặt kích thước và hiển thị cửa sổ
		setSize(400, 300); // Kích thước cửa sổ (400x300 pixel)
		show();            // Hiển thị cửa sổ
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Xử lý sự kiện khi nhấn nút
		if (e.getSource() == tinh) {
			// Khi nhấn nút "Tinh"
			int a = Integer.parseInt(txta.getText()); // Lấy giá trị a từ trường nhập
			int b = Integer.parseInt(txtb.getText()); // Lấy giá trị b từ trường nhập
			if (a != 0)
				txtkq.setText(Float.toString((float) -b / a)); // Tính nghiệm và hiển thị
			else if (b == 0)
				txtkq.setText("PT vo so nghiem"); // Trường hợp a = 0, b = 0
			else
				txtkq.setText("PT vo nghiem");   // Trường hợp a = 0, b ≠ 0
		}

		if (e.getSource() == reset) {
			// Khi nhấn nút "Reset"
			txta.setText(""); // Xóa giá trị trong trường nhập "a"
			txtb.setText(""); // Xóa giá trị trong trường nhập "b"
			txtkq.setText(""); // Xóa giá trị trong trường kết quả
		}

		if (e.getSource() == thoat) {
			// Khi nhấn nút "Thoat"
			System.exit(0); // Thoát ứng dụng
		}
	}

	public Bai1_PTBN(String st) {
		// Constructor
		super(st); // Gọi constructor của Frame, đặt tiêu đề cho cửa sổ
		GUI();     // Gọi phương thức GUI để thiết kế giao diện
	}

	public static void main(String[] args) {
		// Điểm bắt đầu của chương trình
		new Bai1_PTBN("Giai phuong trinh bac nhat");
		// Tạo đối tượng Bai1_PTBN và khởi chạy giao diện
	}
}
