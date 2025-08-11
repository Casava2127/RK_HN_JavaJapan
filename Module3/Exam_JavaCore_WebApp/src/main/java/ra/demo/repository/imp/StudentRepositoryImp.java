package ra.demo.repository.imp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ra.demo.model.Student;
import ra.demo.repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StudentRepositoryImp implements StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> findAll() {
        List<Student> students = entityManager.createQuery("from Student", Student.class).getResultList();
        System.out.println("List of students: " + students); // Debug output
        return students;
    }


    @Override
    public Student findById(int studentId) {
        return entityManager.createQuery("from Student where studentId=:id", Student.class)
                .setParameter("id", studentId)
                .getSingleResult();
        // Truy vấn tìm kiếm một đối tượng `Student` theo `studentId`.
    }

    @Override
    @Transactional
    public boolean save(Student student) {
        try {
            entityManager.persist(student);
            // Lưu đối tượng `Student` vào cơ sở dữ liệu (INSERT).
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean update(Student student) {
        try {
            entityManager.merge(student);
            // Cập nhật đối tượng `Student` trong cơ sở dữ liệu (UPDATE).
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(int studentId) {
        try {
            // Tìm đối tượng cần xóa.
            Student student = findById(studentId);
            // Thực hiện xóa.
            entityManager.remove(student);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
