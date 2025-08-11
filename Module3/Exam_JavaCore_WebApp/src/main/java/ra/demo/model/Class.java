package ra.demo.model;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Class")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private int classId;

    @Column(name = "class_name", columnDefinition = "varchar(100)", nullable = false, unique = true)
    private String className;

    @Column(name = "majors", columnDefinition = "varchar(150)", nullable = false)
    private String majors;

    // Quan hệ 1-N giữa Class và Student
    @OneToMany(mappedBy = "classId")  // Liên kết với thuộc tính classId trong Student
    private List<Student> listStudent = new ArrayList<>(); // Một lớp có nhiều sinh viên
}
