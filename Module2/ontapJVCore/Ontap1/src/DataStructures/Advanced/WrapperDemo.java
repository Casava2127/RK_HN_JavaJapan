package DataStructures.Advanced;

import java.util.ArrayList;

public class WrapperDemo {
    public static void main(String[] args) {
        // 1. Chuyển kiểu nguyên thủy sang Wrapper Class (Autoboxing)
        int primitiveInt = 42;
        Integer integerObject = primitiveInt; // Autoboxing: int -> Integer
        System.out.println("int to Integer: " + integerObject);

        double primitiveDouble = 3.14;
        Double doubleObject = primitiveDouble; // Autoboxing: double -> Double
        System.out.println("double to Double: " + doubleObject);

        char primitiveChar = 'A';
        Character charObject = primitiveChar; // Autoboxing: char -> Character
        System.out.println("char to Character: " + charObject);

        // 2. Chuyển kiểu nguyên thủy sang Wrapper Class (sử dụng valueOf)
        Integer integerObject2 = Integer.valueOf(100); // int -> Integer
        System.out.println("Using valueOf (int to Integer): " + integerObject2);

        Boolean booleanObject = Boolean.valueOf(true); // boolean -> Boolean
        System.out.println("Using valueOf (boolean to Boolean): " + booleanObject);

        // 3. Chuyển từ chuỗi sang Wrapper Class
        Integer integerFromString = Integer.valueOf("123"); // Chuỗi -> Integer
        System.out.println("String to Integer: " + integerFromString);

        Double doubleFromString = Double.valueOf("45.67"); // Chuỗi -> Double
        System.out.println("String to Double: " + doubleFromString);

        // 4. Chuyển Wrapper Class về kiểu nguyên thủy (Unboxing)
        Integer integerObject3 = 200;
        int primitiveInt2 = integerObject3; // Unboxing: Integer -> int
        System.out.println("Integer to int: " + primitiveInt2);

        // 5. Sử dụng Wrapper Class trong ArrayList
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10); // Autoboxing: int -> Integer
        numbers.add(20);
        System.out.println("ArrayList of Integers: " + numbers);

        // 6. Ví dụ về NullPointerException khi unboxing
        Integer nullInteger = null;
        try {
            int riskyInt = nullInteger; // Unboxing null -> NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Lỗi: NullPointerException khi unboxing giá trị null");
        }
    }
}
//Mục đích chính của việc chuyển kiểu nguyên thủy sang Wrapper Classes là để sử dụng trong Collections Framework,
// nơi yêu cầu dữ liệu phải là đối tượng. Ngoài ra, Wrapper Classes còn cung cấp các tính năng bổ sung như phương thức tiện ích, hỗ trợ null, và tương thích với các API hoặc lập trình hướng đối tượng.
// Tuy nhiên, cần sử dụng cẩn thận để tránh các vấn đề về hiệu suất hoặc lỗi runtime.