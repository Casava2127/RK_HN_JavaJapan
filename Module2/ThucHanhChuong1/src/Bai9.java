public class Bai9 {
    //tinh S = 15 - 1 +1/2 -1/3! +1/4! ...
    private double sumS(int n){
        int giaiThua =1;
        double S = 0;
        for(int i=1;i<=n;i++){
            giaiThua *= i;
            if(i%2!=0){
                S -= 1.0/giaiThua;
            }else {
                S += 1.0/giaiThua;
            }
        }
        return 15 + S;
    }
    public static void main(String[] args) {
        Bai9 main = new Bai9();
        System.out.println("Tong S = " + main.sumS(3));
    }


}
