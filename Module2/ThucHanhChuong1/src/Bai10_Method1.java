public class Bai10_Method1 {
   private static double sum10(int n){
       double S = 1.0;
       int giaiThua = 1;
       for(int i =3; i<= 2*n-1; i++){
           giaiThua *= (i-1)*i;
           S+=1.0/giaiThua;
       }
       return S;
   }
    public static void main(String[] args) {
        System.out.println("Tong S: " + sum10(2));
    }
}