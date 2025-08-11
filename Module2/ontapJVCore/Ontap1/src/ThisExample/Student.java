package ThisExample;

public class Student {
    String name;
    int age;
    public Student(String name, int age){
        this.name = name; // name (1) la bien tham chieu, name (2) la tham so
        this.age = age; // age (1) la bien tham chieu, age (2) la tham so
    }
    // su dung this de goi constructor khac
    public Student(String name){
        this(name, 18); // goi toi constructor Student(String name, int age)
    }
    // 3. tra ve doi tuong hien tai
    public Student setName(String name){
        this.name = name;
        return this;
    }
    public Student setAge(int age){
        this.age = age;
        return this;
    }
    // truyen this vao mot phuong thuc khac
    public void introduce(){
        Helper.printStudentInfo(this);
    }
    // 5. Lớp lồng nhau và sử dụng OuterClass.this
    class StudentPrinter {
        public void print() {
            System.out.println("Name from inner class: " + Student.this.name);
            System.out.println("Age from inner class: " + Student.this.age);
        }
    }
}
