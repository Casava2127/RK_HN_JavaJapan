package ac.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ac.models.Attendance;
import ac.repositories.AttendanceRepository;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @PostMapping
    public ResponseEntity<Attendance> createAttendance(@RequestBody Attendance attendance) {
        Attendance createdAttendance = attendanceRepository.save(attendance);
        return ResponseEntity.ok(createdAttendance);
    }

    @GetMapping
    public ResponseEntity<List<Attendance>> getAllAttendance() {
        List<Attendance> attendanceList = attendanceRepository.findAll();
        return ResponseEntity.ok(attendanceList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attendance> getAttendanceById(@PathVariable Long id) {
        Attendance attendance = attendanceRepository.findById(id).orElse(null);
        if (attendance == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(attendance);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Attendance> updateAttendance(@PathVariable Long id, @RequestBody Attendance attendanceDetails) {
        Attendance attendance = attendanceRepository.findById(id).orElse(null);
        if (attendance == null) {
            return ResponseEntity.notFound().build();
        }
        attendance.setSomeField(attendanceDetails.getSomeField()); // Update fields as necessary
        Attendance updatedAttendance = attendanceRepository.save(attendance);
        return ResponseEntity.ok(updatedAttendance);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Long id) {
        Attendance attendance = attendanceRepository.findById(id).orElse(null);
        if (attendance == null) {
            return ResponseEntity.notFound().build();
        }
        attendanceRepository.delete(attendance);
        return ResponseEntity.noContent().build();
    }
}