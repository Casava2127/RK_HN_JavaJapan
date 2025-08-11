package ra.demo.service;

import ra.demo.model.Class;
import java.util.List;

public interface ClassService {

    // Phương thức tìm tất cả các lớp
    List<Class> findAll();

    // Phương thức tìm lớp theo classId
    Class findById(int classId);

    // Phương thức lưu một lớp mới vào cơ sở dữ liệu
    boolean save(Class aClass);

    // Phương thức cập nhật thông tin một lớp
    boolean update(Class aClass);

    // Phương thức xóa một lớp theo classId
    boolean delete(int classId);



}
