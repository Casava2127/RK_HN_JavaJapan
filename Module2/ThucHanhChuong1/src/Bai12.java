public class Bai12 {
    // tinh tong va tich cac chu so nguyen duong m  cho truoc
    private static void tongCacChuSo(int n){
        int sum=0;
        int tich = 1;
        do{
            sum+=n%10;
            tich*=n%10;
            n/=10;
        }while(n>0);
        System.out.println(sum +" "+ tich);
    }

    public static void main(String[] args) {
        int n = 1239;
        tongCacChuSo(n);

    }
}
