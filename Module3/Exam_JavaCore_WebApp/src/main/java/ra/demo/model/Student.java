package ra.demo.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "Student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "student_name", columnDefinition = "varchar(100)", nullable = false, unique = true)
    private String studentName;

    @Column(name = "phone_number", columnDefinition = "varchar(11)", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "email", columnDefinition = "varchar(100)", nullable = false, unique = true)
    private String email;

    @Column(name = "address", columnDefinition = "varchar(150)", nullable = false)
    private String address;

    @Column(name = "sex", columnDefinition = "bit(1)", nullable = false)
    private boolean sex;

    // Quan hệ N-M giữa Student và Class
    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "class_id", nullable = false)
    private Class classId;

    @Column(name = "image_url", columnDefinition = "varchar(255)")
    private String imageUrl;

    @Column(name = "status", columnDefinition = "tinyint default 1")
    private int status = 1; // Trạng thái sinh viên, mặc định là đang theo học
}
