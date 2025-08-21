package LVR;

import java.io.*;

public class cau_04 {
    public static int nhapSo() throws IOException {
        InputStreamReader luongVao = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(luongVao);
        String s = br.readLine();
        return Integer.parseInt(s);
    }

    public static int[] xoaPhanTuDau(int[] mang) {
        int[] mangMoi = new int[mang.length - 1];
        for (int i = 0; i < mangMoi.length; i++) {
            mangMoi[i] = mang[i + 1];
        }
        return mangMoi;
    }

    public static int[] timMaxTrenMoiDong(int[][] maTran) {
        int[] ketQua = new int[maTran.length];
        for (int i = 0; i < maTran.length; i++) {
            int max = 0;
            for (int j = 0; j < maTran[i].length; j++) {
                if (maTran[i][j] > max) {
                    max = maTran[i][j];
                }
            }
            ketQua[i] = max;
        }
        return ketQua;
    }

    public static int tichBoiSo3TrenDongDau(int[][] maTran) {
        int tich = 1;
        for (int i = 0; i < maTran[0].length; i++) {
            if (maTran[0][i] % 3 == 0) {
                tich *= maTran[0][i];
            }
        }
        return tich;
    }

    public static void main(String[] args) {
        int soDong = 0, soCot = 0;
        do {
            try {
                System.out.print("a. Nhập số dòng m: ");
                soDong = cau_04.nhapSo();
                System.out.print("   Nhập số cột n: ");
                soCot = cau_04.nhapSo();
                int[][] maTran = new int[soDong][soCot];

                System.out.println("   Nhập ma trận: ");

                for (int i = 0; i < soDong; i++) {
                    for (int j = 0; j < soCot; j++) {
                        System.out.print("   A[" + i + "][" + j + "] :");
                        maTran[i][j] = cau_04.nhapSo();
                    }
                }

                System.out.println("   Ma trận vừa nhập: ");

                for (int i = 0; i < soDong; i++) {
                    for (int j = 0; j < soCot; j++) {
                        System.out.print(maTran[i][j] + " ");
                    }
                    System.out.println();
                }
                int tichBoiSo3 = cau_04.tichBoiSo3TrenDongDau(maTran);
                System.out.println("b. Tích các bội số của 3 trên dòng đầu tiên: " + tichBoiSo3);
                System.out.println("c. Mảng X[i] gồm giá trị lớn nhất trên mỗi dòng: ");
                for (int max : cau_04.timMaxTrenMoiDong(maTran)) {
                    System.out.println(max);
                }

                System.out.println("d. Sau khi xóa phần tử đầu tiên, mảng X[i] là: ");
                int[] maxTrenMoiDong = cau_04.timMaxTrenMoiDong(maTran);
                if (maxTrenMoiDong.length > 0) {
                    maxTrenMoiDong = cau_04.xoaPhanTuDau(maxTrenMoiDong);
                    for (int i : maxTrenMoiDong) {
                        System.out.print(i + " ");
                    }
                } else {
                    System.out.println("Mảng rỗng.");
                }
            } catch (Exception e) {
            }
        } while (soDong < 0 || soCot < 0);
    }
}

