package ThreadIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * luong huong byte (8 bit)
 * luong huong char ( 16 bit)
 *
 * ong ty cap nuoc --> xay dung duong ong
 * xay dung duong ong --> vao be chua ( vung dem )
 * tu be chua -> nguoi dan dung
 *
 * tu System.in --> tao luong vao ISR ( inputstreamREaderS)
 * tu luong vao ISR --> tao vung dem BR (BufferREader)
 * tu vung dem  --- > do vao bien chuong trinh
 *
 *
 *
 */

public class Demo1 {
public int nhapso() throws IOException {
    InputStreamReader ISR = new InputStreamReader(System.in); // System.in/out/err is standard I/O stream
    BufferedReader br = new BufferedReader(ISR);
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine(); // duong ong nay doc/truyen du lieu vao bien String s
    return Integer.parseInt(s);
//    return Integer.parseInt(br.readLine());
}
    public String nhapChuoi() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return  br.readLine();
    }
public static void TongTichCacChuSo(int m){
    int S = 0, P =1;
    while(m!=0){
    S+=m%10;
    P*=m%10;
    m=m/10;
    }
    System.out.println("Tong cac chu so cua so: " + S);
    System.out.println("Tich cac chu so cua so: " + P);
}
public static void UCLN( int a, int b){
    int r;
    while(b!=0){
        r = a%b;
        a = b;
        b = r;
    }
    System.out.println("UCLN cua " + a + " va " + b + " la: " + a);
}
// nhap 1 chuoi, in ra chuoi dao
//    public static void daoNguocChuoi(String s){
//        StringBuilder sb = new StringBuilder(s);
//        System.out.println("Chuoi dao nguoc la: " + sb.reverse().toString());
//    }

public static void daoNguocChuoi(String s){
    String s1 = "";
    for(int i=s.length()-1; i >=0;i--){
        s1 += s.charAt(i);
    }
    System.out.println("Chuoi dao nguoc la: " + s1);
}
    public static void main(String[] args) {
        Demo1 d = new Demo1();
        try {
            int so = d.nhapso(); // ham tra ve 1 so duoc nhap vao luong
            int so1 = d.nhapso(); // ham tra ve 1 so duoc
            String s = d.nhapChuoi();
            // dao chuoi
            daoNguocChuoi(s);
            // chay ham tinh tong, tich, UCLN
            TongTichCacChuSo(so);
            UCLN(so, so1);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
