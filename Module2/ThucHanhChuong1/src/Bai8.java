public class Bai8 {
    //viet chuong trinh tinh S = 1/1+1/2+1/3+...1/n
    private static double tinhTong( int n)
        {
            double sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += 1.0 / i;
            }
            return sum;
        }
        public static void main(String[] args) {
            int n = 10;
            System.out.println("Tong S = " + tinhTong(n));
        }
}
// khi bo static thi phuong thuc thuoc ve CLASS
// nen neu bo di thi can khai bao 1 doi tuong trong ham main cua class de co the su dung

