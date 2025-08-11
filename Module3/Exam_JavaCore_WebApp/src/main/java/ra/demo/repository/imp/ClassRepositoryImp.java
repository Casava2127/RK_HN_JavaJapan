package ra.demo.repository.imp;

// Đặt tên package cho lớp `ClassRepositoryImp`, thường được sử dụng để chứa các lớp repository trong ứng dụng.

import org.springframework.stereotype.Repository;
// Import annotation `@Repository` từ Spring để đánh dấu lớp này là một Repository, Spring sẽ tự động nhận diện và quản lý như một bean trong Spring context.

import org.springframework.transaction.annotation.Transactional;
// Import annotation `@Transactional` từ Spring, giúp đảm bảo rằng các phương thức được đánh dấu này sẽ thực hiện trong một giao dịch, nghĩa là chúng sẽ được commit hoặc rollback trong một giao dịch.

import ra.demo.model.Class;
// Import lớp `Class` - đối tượng entity mà repository này sẽ thao tác với (lớp này ánh xạ với bảng `Class` trong cơ sở dữ liệu).

import ra.demo.repository.ClassRepository;
// Import interface `ClassRepository` mà lớp này phải thực thi. Interface này định nghĩa các phương thức mà `ClassRepositoryImp` phải cung cấp.

import javax.persistence.EntityManager;
// Import `EntityManager` từ JPA, đây là đối tượng chính để thực hiện các thao tác demo trên cơ sở dữ liệu.

import javax.persistence.PersistenceContext;
// Import annotation `@PersistenceContext`, giúp Spring tự động tiêm đối tượng `EntityManager` vào lớp này, giúp thao tác với cơ sở dữ liệu.

import java.util.List;
// Import lớp `List` từ Java để sử dụng kiểu dữ liệu danh sách cho kết quả trả về từ các phương thức.

@Repository
// Đánh dấu lớp này là một repository Spring, giúp Spring quản lý lớp như một bean trong container và cung cấp các phương thức thao tác với cơ sở dữ liệu.

public class ClassRepositoryImp implements ClassRepository {

    @PersistenceContext
    private EntityManager entityManager;
    // Tiêm đối tượng `EntityManager` từ JPA vào lớp này, `EntityManager` dùng để thực hiện các thao tác demo với cơ sở dữ liệu.

    @Override
    public List<Class> findAll() {
        return entityManager.createQuery("from Class", Class.class).getResultList();
        // Phương thức `findAll()` thực hiện truy vấn tất cả các bản ghi từ bảng `Class`.
        // `createQuery("from Class", Class.class)` tạo ra một câu truy vấn JPQL để lấy tất cả các đối tượng `Class`.
        // `getResultList()` trả về danh sách các đối tượng `Class` từ cơ sở dữ liệu.
    }

    @Override
    public Class findById(int classId) {
        return entityManager.createQuery("from Class where classId=:id", Class.class)
                .setParameter("id", classId).getSingleResult();
        // Phương thức `findById(int classId)` tìm kiếm một đối tượng `Class` theo `classId` (khóa chính).
        // `createQuery("from Class where classId=:id", Class.class)` tạo câu truy vấn JPQL để tìm kiếm theo `classId`.
        // `setParameter("id", classId)` thay thế tham số `:id` bằng giá trị `classId`.
        // `getSingleResult()` trả về duy nhất một đối tượng `Class` tìm thấy.
    }

    @Override
    @Transactional
    public boolean save(Class aClass) {
        try {
            entityManager.persist(aClass);
            // `persist(aClass)` dùng để lưu đối tượng `Class` vào cơ sở dữ liệu (INSERT).
            // Đối tượng `aClass` sẽ được lưu vào bảng `Class`.
            return true; // Trả về `true` nếu thao tác lưu thành công.
        } catch (Exception ex) {
            ex.printStackTrace();
            // Nếu có lỗi xảy ra trong quá trình lưu, in ra thông báo lỗi.
        }
        return false; // Trả về `false` nếu có lỗi trong quá trình lưu đối tượng.
    }

    @Override
    @Transactional
    public boolean update(Class aClass) {
        try {
            entityManager.merge(aClass);
            // `merge(aClass)` dùng để cập nhật đối tượng `Class` vào cơ sở dữ liệu (UPDATE).
            // Nếu đối tượng chưa có trong cơ sở dữ liệu, `merge` sẽ thực hiện thao tác INSERT.
            return true; // Trả về `true` nếu thao tác cập nhật thành công.
        } catch (Exception ex) {
            ex.printStackTrace();
            // Nếu có lỗi xảy ra trong quá trình cập nhật, in ra thông báo lỗi.
        }
        return false; // Trả về `false` nếu có lỗi trong quá trình cập nhật.
    }

    @Override
    @Transactional
    public boolean delete(int classId) {
        try {
            // 1. Lay doi tuong can xoa theo classId
            Class aClass = findById(classId);
            // Tìm đối tượng `Class` cần xóa bằng phương thức `findById(classId)`.

            // 2. Thuc hien xoa
            entityManager.remove(aClass);
            // `remove(aClass)` dùng để xóa đối tượng `Class` khỏi cơ sở dữ liệu.
            return true; // Trả về `true` nếu thao tác xóa thành công.
        } catch (Exception ex) {
            ex.printStackTrace();
            // Nếu có lỗi xảy ra trong quá trình xóa, in ra thông báo lỗi.
        }
        return false; // Trả về `false` nếu có lỗi trong quá trình xóa đối tượng.
    }
}
