package LVR;

import java.io.*;
import java.util.Scanner;

public class cau_03 {
    public static int nhapSo() throws IOException {
        InputStreamReader luongVao = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(luongVao);
        String s = br.readLine();
        return Integer.parseInt(s);
    }

    // Tổng số dương lẻ
    public static int tinhTongSoLe(int[] mang) {
        int tong = 0;
        for (int i = 0; i < mang.length; i++) {
            if (mang[i] % 2 != 0)
                tong += mang[i];
        }
        return tong;
    }

    // Tìm phần tử K
    public static int timPhanTuK(int K, int[] mang) {
        int viTri = -1;
        for (int i = 0; i < mang.length; i++) {
            if (K == mang[i])
                return i;
        }
        return viTri;
    }

    // Sắp xếp tăng dần
    public static int[] sapXepTangDan(int[] mang) {
        for (int i = 0; i < mang.length - 1; i++) {
            for (int j = i + 1; j < mang.length; j++) {
                if (mang[j] < mang[i]) {
                    int temp = mang[j];
                    mang[j] = mang[i];
                    mang[i] = temp;
                }
            }
        }
        return mang;
    }

    // Chèn phần tử P
    public static int[] chenPhanTuP(int[] mang, int P) {
        int doDai = mang.length;
        int[] mangMoi = new int[doDai + 1];
        for (int i = 0; i < doDai; i++) {
            mangMoi[i] = mang[i];
        }
        mangMoi[doDai] = P;
        cau_03.sapXepTangDan(mangMoi);
        return mangMoi;
    }

    public static void main(String[] args) {
        int soLuongPhanTu = 0;
        do {
            try {
                System.out.print("a. Nhập số lượng phần tử: ");
                soLuongPhanTu = cau_03.nhapSo();
                int[] mang = new int[soLuongPhanTu];
                for (int i = 0; i < soLuongPhanTu; i++) {
                    System.out.print("Nhập mang[" + i + "] : ");
                    mang[i] = cau_03.nhapSo();
                }
                System.out.println("b. Tổng các phần tử số lẻ: " + cau_03.tinhTongSoLe(mang));

                System.out.print("c. Nhập một số cần tìm: ");
                int K = cau_03.nhapSo();

                int viTriTimThay = cau_03.timPhanTuK(K, mang);
                if (viTriTimThay == -1)
                    System.out.println("Không tìm thấy số " + K);
                else
                    System.out.println(K + " nằm ở vị trí thứ " + viTriTimThay + " trong mảng");

                System.out.println("d. Mảng sau khi sắp xếp tăng dần: ");
                for (int phanTu : cau_03.sapXepTangDan(mang)) {
                    System.out.print(phanTu + " ");
                }
                System.out.println();

                System.out.print("e. Nhập phần tử cần chèn: ");
                int P = cau_03.nhapSo();
                System.out.println("Mảng sau khi chèn: ");
                for (int phanTu : cau_03.chenPhanTuP(mang, P)) {
                    System.out.print(phanTu + " ");
                }

            } catch (Exception e) {
            }
        } while (soLuongPhanTu < 0);
    }
}
