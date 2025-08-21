package LVR;

import java.io.*;

public class cau_01 {
	public static String nhapChuoi() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	public static String inputString() throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		return input;
	}

	// Đảo ngược chuỗi
	public static String daoNguoc(String s) {
		String daoNguoc = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			daoNguoc += s.charAt(i);
		}
		return daoNguoc;
	}
	public static String reverseString(String s){
		String reverse = "";
		for(int i = s.length()-1; i >= 0; i--){
			reverse += s.charAt(i);
		}
		return reverse;
	}

	// Chữ hoa
	public static String vietHoa(String s) {
		String vietHoa = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				vietHoa += (char) (s.charAt(i) - 32);
			} else {
				vietHoa += s.charAt(i);
			}
		}
		return vietHoa;
	}
	public static String capitalize(String s) {
		String capitalize = "";
        capitalize += Character.toUpperCase(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (Character.isWhitespace(s.charAt(i))) {
                capitalize += Character.toUpperCase(s.charAt(i + 1));
            } else {
                capitalize += Character.toUpperCase(s.charAt(i));
            }
        }
        return capitalize;
	}

	// Chữ thường
	public static String vietThuong(String s) {
		String vietThuong = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				vietThuong += (char) (s.charAt(i) + 32);
			} else {
				vietThuong += s.charAt(i);
			}
		}
		return vietThuong;
	}

	// Kết hợp chữ hoa và chữ thường
	public static String hoaThuongHop(String s) {
		String hoaThuong = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				hoaThuong += (char) (s.charAt(i) + 32);
			} else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				hoaThuong += (char) (s.charAt(i) - 32);
			} else {
				hoaThuong += s.charAt(i);
			}
		}
		return hoaThuong;
	}

	// Đếm ký tự
	public static int demKyTu(String s, char c) {
		int dem = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				dem++;
			}
		}
		return dem;
	}

	// Bảng tần suất xuất hiện
	public static void TanSuatKyTu(String s) {
		System.out.println("Bảng tần suất xuất hiện ký tự:");
		String kyTu = "";
		for (int i = 0; i < s.length(); i++) {
			if (kyTu.indexOf(s.charAt(i)) < 0) {
				kyTu += s.charAt(i);
			}
		}
		for (int i = 0; i < kyTu.length(); i++) {
			char c = kyTu.charAt(i);
			System.out.println(c + " : " + cau_01.demKyTu(s, c) + " lần");
		}
	}

	public static void main(String[] args) {
		try {
			System.out.println("Nhập chuỗi: ");
			String input = cau_01.nhapChuoi();
			System.out.println("a. In chuỗi đảo ngược: " + cau_01.daoNguoc(input));
			System.out.println("b. Chữ hoa: " + cau_01.vietHoa(input));
			System.out.println("c. Chữ thường: " + cau_01.vietThuong(input));
			System.out.println("d. Kết hợp hoa và thường: " + cau_01.hoaThuongHop(input));
			System.out.print("e. Đếm ký tự xuất hiện: Nhập ký tự cần đếm: ");
			char kyTu = (char) System.in.read();
			System.out.println("Ký tự " + kyTu + " xuất hiện " + cau_01.demKyTu(input, kyTu) + " lần");
			System.out.print("f. ");
			cau_01.TanSuatKyTu(input);
		} catch (Exception e) {
		}
	}
}
