package ra.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.demo.model.Class;
import ra.demo.model.Student;
import ra.demo.service.ClassService;
import ra.demo.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/studentController")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassService classService;

    @GetMapping("/findAll")
    public String findAllStudent(Model model) {
        // Phương thức xử lý các yêu cầu GET tại URL `/studentController/findAll`.
        // Trả về danh sách tất cả các sinh viên và hiển thị trên view "students".

        List<Student> listStudents = studentService.findAll();
        // Gọi phương thức `findAll()` trong `StudentService` để lấy danh sách tất cả các sinh viên.

        model.addAttribute("listStudents", listStudents);
        // Thêm danh sách `listStudents` vào đối tượng `model`, để có thể sử dụng trong view.

        return "studentList";
        // Trả về tên view "students" để hiển thị danh sách sinh viên.
    }

    @GetMapping("/initCreate")
    public String initCreateStudent(Model model) {
        Student newStudent = new Student();
        List<Class> listClasses = classService.findAll();
        // Gọi phương thức `findAll()` trong `ClassService` để lấy danh sách tất cả các lớp.

        model.addAttribute("listClasses", listClasses);
        model.addAttribute("studentUpdate", newStudent);
        // Truyền đối tượng `newStudent` vào model để hiển thị trong form tạo mới.

        return "newStudent";
        // Trả về view để người dùng nhập thông tin sinh viên mới.
    }

    @PostMapping("/create")
    public String createStudent(Student newStudent) {
        boolean result = studentService.save(newStudent);
        // Lưu sinh viên mới vào cơ sở dữ liệu thông qua `StudentService`.

        if (result) {
            return "redirect:findAll";
            // Nếu tạo thành công, chuyển hướng về trang danh sách sinh viên.
        }
        return "error";
        // Nếu có lỗi, quay lại trang lỗi.
    }

    @GetMapping("/initUpdate")
    public String initUpdateStudent(Model model, int studentId) {
        // Phương thức xử lý yêu cầu GET tại URL `/studentController/initUpdate` để khởi tạo trang cập nhật sinh viên.
        // Lấy thông tin sinh viên theo `studentId` để hiển thị trên form cập nhật.

        Student studentUpdate = studentService.findById(studentId);
        // Gọi phương thức `findById(studentId)` trong `StudentService` để tìm sinh viên theo `studentId`.

        model.addAttribute("studentUpdate", studentUpdate);
        // Thêm đối tượng `studentUpdate` vào model, để truyền thông tin sinh viên cần cập nhật vào form.

        return "updateStudent";
        // Trả về view "updateStudent" để hiển thị form cập nhật sinh viên.
    }

    @PostMapping("/update")
    public String updateStudent(Student studentUpdate) {
        // Phương thức xử lý các yêu cầu POST tại URL `/studentController/update` khi người dùng submit form cập nhật sinh viên.

        boolean result = studentService.update(studentUpdate);
        // Gọi phương thức `update(studentUpdate)` trong `StudentService` để cập nhật thông tin sinh viên trong cơ sở dữ liệu.

        if (result) {
            return "redirect:findAll";
            // Nếu cập nhật thành công, chuyển hướng người dùng về URL `/studentController/findAll` để hiển thị danh sách sinh viên đã được cập nhật.
        }
        return "error";
        // Nếu cập nhật không thành công, trả về view "error" để hiển thị thông báo lỗi.
    }

    @GetMapping("/delete")
    public String deleteStudent(int studentId) {
        // Phương thức xử lý các yêu cầu GET tại URL `/studentController/delete` để xóa sinh viên theo `studentId`.

        boolean result = studentService.delete(studentId);
        // Gọi phương thức `delete(studentId)` trong `StudentService` để xóa sinh viên theo `studentId`.

        if (result) {
            return "redirect:findAll";
            // Nếu xóa thành công, chuyển hướng người dùng về URL `/studentController/findAll` để hiển thị danh sách sinh viên còn lại.
        }
        return "error";
        // Nếu xóa không thành công, trả về view "error" để hiển thị thông báo lỗi.
    }

    public ClassService getClassService() {
        return classService;
    }

    public void setClassService(ClassService classService) {
        this.classService = classService;
    }
}
