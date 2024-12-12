package ra.demo.service;

import ra.demo.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(int studentId);
    boolean save(Student student);
    boolean update(Student student);
    boolean delete(int studentId);
}
