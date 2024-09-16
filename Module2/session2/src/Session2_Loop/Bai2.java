package Session2_Loop;

import java.util.Scanner;

public class Bai2 {
    // Mảng chứa các chữ số bằng tiếng Việt
    private static final String[] so = {"", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín"};
    private static final String[] hang = {"", "nghìn", "triệu", "tỷ"};

    //Hàm đọc 3 số
    private static String docBaSo(int num) {
        String ketQua = "";
        int tram = num / 100;
        int chuc = (num % 100) / 10;
        int donVi = num % 10;
        if (tram != 0) {
            ketQua += so[tram] + " trăm ";
            if (chuc == 0) {
                ketQua += " lẻ ";
            }
        }
        if (chuc != 0 && chuc != 1) {
            ketQua += so[chuc] + " mươi ";
            if (donVi == 1) {
                ketQua += " mốt ";
            } else if (donVi == 5) {
                ketQua += " lăm ";
            } else if (donVi != 0) {
                ketQua += so[donVi] + " ";
            }
        } else if (chuc == 1) {
            ketQua += " mười ";
            if (donVi == 1) {
                ketQua += " một ";
            } else if (donVi == 5) {
                ketQua += " lăm ";
            } else if (donVi != 0) {
                ketQua += so[donVi] + " ";
            }
        } else if (donVi != 0) {
            ketQua += so[donVi] + " ";
        }
        return ketQua;
    }

    private static String docSoThanhChu(long num) {
        if (num == 0) {
            return "0 đồng";
        }
        String ketQua = "";
        int viTriHang = 0;
        while (num > 0) {
            int baSoCuoi = (int) (num % 1000);
            if (baSoCuoi != 0) {
                String docBaSoCuoi = docBaSo(baSoCuoi);
                ketQua = docBaSoCuoi + hang[viTriHang] + " " + ketQua;
            }
            viTriHang++;
            num /= 1000;
        }
        return ketQua.trim() + " đồng ";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Nhập số tiền muốn quy đổi: ");
        int n = sc.nextInt();
        System.out.print(docSoThanhChu(n));
    }
}



