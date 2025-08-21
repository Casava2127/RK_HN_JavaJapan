package ra.jsp_servlet_demo.service.ipm;



import ra.jsp_servlet_demo.entity.User;
import ra.jsp_servlet_demo.reposistory.ipm.UserReposistoryImpl;
import ra.jsp_servlet_demo.reposistory.UserRepository;
import ra.jsp_servlet_demo.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository = new UserReposistoryImpl();

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findUserById(id);
    }

    @Override
    public void addUser(User user) {
        userRepository.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteUser(id);
    }
}
