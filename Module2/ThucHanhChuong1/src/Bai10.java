public class Bai10 {
    //tinh S =  1  +1/3!  ...
    private double sumS10(int n){
        double S = 0;
        for(int i=1;i<=2*n-1;i+=2){
            int giaiThua =1;
           for(int j=1;j<=i;j++){
               giaiThua *= j;
           }
            S += (double)1/giaiThua;
        }
        return  S;
    }
    public static void main(String[] args) {
        Bai10 main = new Bai10();
        System.out.println("Tong S = " + main.sumS10(2));
    }
}
