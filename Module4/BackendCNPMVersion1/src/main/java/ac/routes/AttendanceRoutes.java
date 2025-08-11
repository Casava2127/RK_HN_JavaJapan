package ac.routes;

import ac.controllers.AttendanceController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

@Configuration
@RequestMapping("/api/attendance")
public class AttendanceRoutes {

    private final AttendanceController attendanceController;

    @Autowired
    public AttendanceRoutes(AttendanceController attendanceController) {
        this.attendanceController = attendanceController;
    }

    @PostMapping
    public void createAttendance(@RequestBody Attendance attendance) {
        attendanceController.createAttendance(attendance);
    }

    @GetMapping("/{id}")
    public Attendance getAttendance(@PathVariable Long id) {
        return attendanceController.getAttendance(id);
    }

    @PutMapping("/{id}")
    public void updateAttendance(@PathVariable Long id, @RequestBody Attendance attendance) {
        attendanceController.updateAttendance(id, attendance);
    }

    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable Long id) {
        attendanceController.deleteAttendance(id);
    }

    @GetMapping
    public List<Attendance> getAllAttendance() {
        return attendanceController.getAllAttendance();
    }
}