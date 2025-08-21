package LVR;

import java.io.*;

public class cau_02 {
	public static int nhapSo() throws IOException {
		InputStreamReader luongVao = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(luongVao);
		String s = br.readLine();
		return Integer.parseInt(s);
	}

	// Tổng chữ số
	public static int tinhTongChuSo(int m) {
		int tong = 0;
		while (m != 0) {
			tong += m % 10;
			m /= 10;
		}
		return tong;
	}

	// Số đảo ngược
	public static int daoNguocSo(int m) {
		if (m > 0 && m < 10)
			return m;
		else {
			int tam = 0;
			while (m != 0) {
				tam *= 10;
				tam += m % 10;
				m /= 10;
			}
			return tam;
		}
	}

	public static int tinhFibonacci(int n) {
		if (n <= 2)
			return 1;
		else
			return tinhFibonacci(n - 1) + tinhFibonacci(n - 2);
	}

	// Kiểm tra số Fibonacci
	public static boolean kiemTraFibonacci(int K) {
		for (int i = 1; i < K; i++) {
			int tam = tinhFibonacci(i);
			if (tam == K)
				return true;
			if (tam > K)
				break;
		}
		return false;
	}

	// Kiểm tra số đối xứng
	public static boolean kiemTraDoiXung(int input) {
		int tam = input;
		int key = cau_02.daoNguocSo(tam);
		if (key - input == 0)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		int m = 0;
		do {
			try {
				System.out.print("Nhập một số: ");
				m = cau_02.nhapSo();

				System.out.println("a. Tổng chữ số: " + cau_02.tinhTongChuSo(m));
				System.out.println("b. Số đảo ngược: " + cau_02.daoNguocSo(m));

				String s1 = cau_02.kiemTraFibonacci(m) ? "phải" : "Không phải";
				System.out.println("c. Thuộc dãy số Fibonacci? " + s1);

				String s2 = cau_02.kiemTraDoiXung(m) ? "phải" : "không phải";
				System.out.println("d. Thuộc số đối xứng? " + s2);
			} catch (NumberFormatException e) {
				System.out.println("Vui lòng nhập một số nguyên.");
				System.exit(0);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (m < 0);
	}
}
