public class Bai6 {
    public static int karaoke(int a, int b){
        if(a < b ){
            System.out.println("Khong hop le");
            return 0;
        }else if(b < 18){
            return (b-a)*45000;
        }else{
            return (b-18)*60000 + (18-a)*45000;
        }
    }
    public static void main(String[] args) {
        System.out.println("Starting" + karaoke(16,21));

    }
}
