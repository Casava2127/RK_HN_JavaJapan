package ra.jsp_servlet_demo.service;

import ra.jsp_servlet_demo.entity.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(int id);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
}
