package ra.jsp_servlet_demo.reposistory;



import ra.jsp_servlet_demo.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> findAllUsers();
    User findUserById(int id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
}
