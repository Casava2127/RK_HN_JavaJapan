package Chuong3_Class_Object;

public class Player {
    int number = 0; // thuoc tinh cua obj
    public void guess(){ // phuong thuc guess de doan nhan number
        number = (int)(Math.random() * 10); // dung thu vien math
        System.out.println("I'm guessing: " + number);
    }
}
