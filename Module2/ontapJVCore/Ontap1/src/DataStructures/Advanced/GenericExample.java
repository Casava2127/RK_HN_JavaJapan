package DataStructures.Advanced;

import java.util.ArrayList;
import java.util.List;

public class GenericExample {
    public static void main(String[] args){
        // dung generic voi arraylist
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        //in danh sach
        printList(numbers);

        //dung phuong thuc generic
        Pair<String, Integer> pair = new Pair<>("Age",25);
        System.out.println("key"+pair.getKey()+", value: "+pair.getValue());

    }
    public static void printList(List<?> list){
        for(Object item : list){
            System.out.println(item);
        }
    }
}
