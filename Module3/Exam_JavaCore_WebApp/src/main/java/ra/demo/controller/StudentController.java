package ra.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ra.demo.model.Student;
import ra.demo.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/studentController")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/findAll")
    public String findAllStudents(Model model) {
        List<Student> listStudents = studentService.findAll();
        model.addAttribute("listStudents", listStudents);
        return "studentList";  // Trả về giao diện hiển thị danh sách sinh viên
    }

    @GetMapping("/initCreate")
    public String initCreateStudent(Model model) {
        Student newStudent = new Student();
        model.addAttribute("newStudent", newStudent);
        return "studentForm";  // Trả về giao diện tạo mới sinh viên
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute("newStudent") Student newStudent) {
        boolean result = studentService.save(newStudent);
        if (result) {
            return "redirect:findAll";  // Nếu tạo mới thành công, chuyển hướng về trang danh sách sinh viên
        }
        return "error";  // Nếu có lỗi, quay lại trang lỗi
    }

    @GetMapping("/initUpdate/{studentId}")
    public String initUpdateStudent(@PathVariable("studentId") int studentId, Model model) {
        Student studentUpdate = studentService.findById(studentId);
        model.addAttribute("studentUpdate", studentUpdate);
        return "studentForm";  // Trả về giao diện cập nhật sinh viên
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute("studentUpdate") Student studentUpdate) {
        boolean result = studentService.update(studentUpdate);
        if (result) {
            return "redirect:findAll";  // Nếu cập nhật thành công, chuyển hướng về trang danh sách sinh viên
        }
        return "error";  // Nếu cập nhật thất bại, quay lại trang lỗi
    }

    @GetMapping("/delete/{studentId}")
    public String deleteStudent(@PathVariable("studentId") int studentId) {
        boolean result = studentService.delete(studentId);
        if (result) {
            return "redirect:findAll";  // Nếu xóa thành công, chuyển hướng về trang danh sách sinh viên
        }
        return "error";  // Nếu xóa thất bại, quay lại trang lỗi
    }
}
