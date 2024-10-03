public class Bai11 {
    public static void main(String[] args) {
        //tinh n!!
        int n = 6;
        int result = 1;
        for (int i = 1; i <= n; i++) {
            if(n%2==0){
                result *= ++i;

            }else{
                result *= i;
                ++i;
            }
        }
        System.out.println("n!! = " + result);
    }
}
