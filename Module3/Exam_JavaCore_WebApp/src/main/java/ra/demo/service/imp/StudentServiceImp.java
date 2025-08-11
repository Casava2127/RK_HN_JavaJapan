package ra.demo.service.imp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.demo.model.Student;
import ra.demo.repository.StudentRepository;
import ra.demo.service.StudentService;


import java.util.List;
@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public boolean save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public boolean update(Student student) {
        return studentRepository.update(student);
    }

    @Override
    public boolean delete(int studentId) {
        return studentRepository.delete(studentId);
    }
}
