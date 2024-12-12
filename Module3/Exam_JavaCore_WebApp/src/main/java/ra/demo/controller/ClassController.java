package ra.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
// Import annotation `@Autowired` từ Spring để tự động tiêm các bean vào trong lớp này.

import org.springframework.stereotype.Controller;
// Import annotation `@Controller` từ Spring để đánh dấu lớp này là một controller, giúp Spring nhận diện lớp này như một phần của MVC.

import org.springframework.ui.Model;
// Import `Model` từ Spring, đối tượng dùng để truyền dữ liệu từ controller sang view.

import org.springframework.web.bind.annotation.GetMapping;
// Import `@GetMapping` từ Spring để đánh dấu phương thức này xử lý các yêu cầu HTTP GET.

import org.springframework.web.bind.annotation.PostMapping;
// Import `@PostMapping` từ Spring để đánh dấu phương thức này xử lý các yêu cầu HTTP POST.

import org.springframework.web.bind.annotation.RequestMapping;
// Import `@RequestMapping` từ Spring để định nghĩa URL mà controller này sẽ xử lý.

import ra.demo.model.Class;
// Import đối tượng `Class`, model đại diện cho bảng lớp trong cơ sở dữ liệu.

import ra.demo.service.ClassService;
// Import interface `ClassService`, sẽ cung cấp các phương thức nghiệp vụ về lớp (Class).

import java.util.List;
// Import lớp `List`, để sử dụng kiểu dữ liệu danh sách cho kết quả trả về từ các phương thức.

@Controller
@RequestMapping("/classController")
// Đánh dấu lớp này là một controller, sẽ xử lý các yêu cầu HTTP.
// `@RequestMapping("/classController")` chỉ định rằng các yêu cầu HTTP bắt đầu với `/classController` sẽ được xử lý bởi lớp này.

public class ClassController {

    @Autowired
    private ClassService classService;
    // Tiêm đối tượng `ClassService` vào controller này để sử dụng các phương thức nghiệp vụ, như tìm kiếm, cập nhật lớp.

    @GetMapping("/findAll")
    public String findAllClass(Model model) {
        // Phương thức xử lý các yêu cầu GET tại URL `/classController/findAll`.
        // Trả về danh sách tất cả các lớp và hiển thị trên view "classes".

        List<Class> listClasses = classService.findAll();
        // Gọi phương thức `findAll()` trong `ClassService` để lấy danh sách tất cả các lớp.

        model.addAttribute("listClasses", listClasses);
        // Thêm danh sách `listClasses` vào đối tượng `model`, để có thể sử dụng trong view.

        return "classes";
        // Trả về tên view "classes" để hiển thị danh sách lớp. View này sẽ hiển thị danh sách các lớp.
    }
    @GetMapping("/initCreate")
    public String initCreateClass(Model model) {
        Class newClass = new Class();
        List<Class> listClasses = classService.findAll(); // Lấy danh sách phòng ban hoạt động
        model.addAttribute("newClass", newClass); // Truyền danh sách phòng ban vào model
        return "newClass"; // Trả về view tạo lớp mới
    }

    @PostMapping("/create")
    public String createClass(Class newClass) {
        boolean result = classService.save(newClass);
        if (result) {
            return "redirect:findAll"; // Nếu tạo lớp thành công, chuyển hướng về trang danh sách lớp
        }
        return "error"; // Nếu có lỗi, quay lại trang lỗi
    }

    @GetMapping("/initUpdate")
    public String initUpdateClass(Model model, int classId) {
        // Phương thức xử lý các yêu cầu GET tại URL `/classController/initUpdate` để khởi tạo trang cập nhật lớp.
        // Lấy thông tin lớp theo `classId` để hiển thị trên form cập nhật.

        Class classUpdate = classService.findById(classId);
        // Gọi phương thức `findById(classId)` trong `ClassService` để tìm lớp theo `classId`.

        model.addAttribute("classUpdate", classUpdate);
        // Thêm đối tượng `classUpdate` vào đối tượng `model`, để truyền thông tin lớp cần cập nhật vào form.

        return "updateClass";
        // Trả về tên view "updateClass" để hiển thị form cập nhật lớp.
    }

    @PostMapping("/update")
    public String updateClass(Class classUpdate) {
        // Phương thức xử lý các yêu cầu POST tại URL `/classController/update` khi người dùng submit form cập nhật lớp.

        boolean result = classService.update(classUpdate);
        // Gọi phương thức `update(classUpdate)` trong `ClassService` để cập nhật thông tin lớp trong cơ sở dữ liệu.

        if (result) {
            return "redirect:findAll";
            // Nếu cập nhật thành công, chuyển hướng người dùng về URL `/classController/findAll` để hiển thị danh sách lớp cập nhật.
        }
        return "error";
        // Nếu cập nhật không thành công, trả về view "error" để hiển thị thông báo lỗi.
    }

    @GetMapping("/delete")
    public String deleteClass(int classId) {
        // Phương thức xử lý các yêu cầu GET tại URL `/classController/delete` để xóa lớp theo `classId`.

        boolean result = classService.delete(classId);
        // Gọi phương thức `delete(classId)` trong `ClassService` để xóa lớp theo `classId`.

        if (result) {
            return "redirect:findAll";
            // Nếu xóa thành công, chuyển hướng người dùng về URL `/classController/findAll` để hiển thị danh sách lớp còn lại.
        }
        return "error";
        // Nếu xóa không thành công, trả về view "error" để hiển thị thông báo lỗi.
    }
}
