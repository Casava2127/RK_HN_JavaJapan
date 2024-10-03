public class Bai13 {
    private int a, b;
    public Bai13(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public int getUCLN() {
        int ucln = UCLN(a, b);
        return ucln;
    }
    public int getBCNN() {
        int bcnn = BCNN(a, b);
        return bcnn;
    }
    private int UCLN(int a, int b) {
        while (b!=0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    private int BCNN(int a, int b) {
        int bcnn = a * b / UCLN(a, b);
        return bcnn;
    }
    public static void main(String[] args) {
        Bai13 ucandbc = new Bai13(12, 18);
        System.out.println("UCLN: " + ucandbc.getUCLN());
        System.out.println("BCNN: " + ucandbc.getBCNN());
    }
}
