package DataStructures.ArrList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static void main(String[] args){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice", 8.5));
        students.add(new Student(2, "Bob", 7.0));
        students.add(new Student(3, "Charlie", 9.0));
        students.add(new Student(4, "Diana", 6.5));

        System.out.println("Danh sách sinh viên:");
        for(Student s : students){
            System.out.println(s.toStrign());
        }

        // Sử dụng Iterator để duyệt danh sách diem<5
        Iterator<Student> it = students.iterator();
        while(it.hasNext()){
            Student s = it.next();
            if(s.grade < 7.0){
                it.remove(); // Xóa sinh viên có điểm < 7.0
            }
        }
        System.out.println("\nSau khi xóa sinh viên có điểm < 7.0:");
        for(Student s : students){
            System.out.println(s.toStrign());
        }
    }
}
