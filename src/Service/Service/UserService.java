package Service.Service;

import Model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser();
    boolean addUser(String name, String email, String address, String phoneNumber, String password, String role);
    boolean deleteUser(int id);
    boolean editUser(int id);
    User findUserById(int id);
    User findUserByEmail(String email);

}
