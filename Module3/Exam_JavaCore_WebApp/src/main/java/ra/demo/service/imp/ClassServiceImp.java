package ra.demo.service.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.demo.model.Class;
import ra.demo.repository.ClassRepository;
import ra.demo.service.ClassService;
import java.util.List;

@Service
// Đánh dấu lớp này là một service trong Spring, Spring sẽ tự động nhận diện và quản lý lớp này như một bean trong container.
public class ClassServiceImp implements ClassService {

    @Autowired
    private ClassRepository classRepository;
    // Tiêm đối tượng `ClassRepository` vào trong lớp này. `ClassRepository` sẽ cung cấp các phương thức để
    // thao tác với cơ sở dữ liệu.

    @Override
    public List<Class> findAll() {
        return classRepository.findAll();
        // Phương thức `findAll()` gọi phương thức `findAll()` của `classRepository` để lấy tất cả các đối tượng `Class`
        // từ cơ sở dữ liệu.
        // Kết quả trả về là một danh sách các `Class`.
    }

    @Override
    public Class findById(int classId) {
        return classRepository.findById(classId);
        // Phương thức `findById(int classId)` gọi phương thức `findById(classId)` của `classRepository` để
        // tìm kiếm một đối tượng `Class` theo `classId`.
        // Trả về một đối tượng `Class` tìm thấy theo `classId`.
    }

    @Override
    public boolean save(Class aClass) {
        return classRepository.save(aClass);
        // Phương thức `save(Class aClass)` gọi phương thức `save(aClass)` của `classRepository`
        // để lưu đối tượng `Class` vào cơ sở dữ liệu.
        // Trả về giá trị `true` nếu lưu thành công, `false` nếu thất bại.
    }

    @Override
    public boolean update(Class aClass) {
        return classRepository.update(aClass);
        // Phương thức `update(Class aClass)` gọi phương thức `update(aClass)` của `classRepository`
        // để cập nhật thông tin của đối tượng `Class` trong cơ sở dữ liệu.
        // Trả về `true` nếu cập nhật thành công, `false` nếu thất bại.
    }

    @Override
    public boolean delete(int classId) {
        return classRepository.delete(classId);
        // Phương thức `delete(int classId)` gọi phương thức `delete(classId)` của `classRepository`
        // để xóa một đối tượng `Class` theo `classId`.
        // Trả về `true` nếu xóa thành công, `false` nếu thất bại.
    }


}
