package Service.Implements;

import Model.User;
import Service.Service.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    MysqlConnectionImpl mysqlConnection = new MysqlConnectionImpl();
    private static final String sqlQr_findAllUser = "select * from user;";
    private static final String sqlQr_addNewUser = "insert into user(name, email, address, phoneNumber, password, role) values(?,?,?,?,?,?);";
    private static final String sqlQr_deleteUser = "delete from user where id=?";
    private static final String sqlQr_editUser = "update user set name=?,email=?,address=?,phoneNumber=?,password=?,role=?where id=?";

    @Override
    public List<User> findAllUser() {
        List<User> users = new ArrayList<>();
        try (
                Connection connection = mysqlConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sqlQr_findAllUser);
        ) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                String password = rs.getString("password");
                String role = rs.getString("role");
                users.add(new User(id, name, email, address, phoneNumber, password, role));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean addUser(String name, String email, String address, String phoneNumber, String password, String role) {
        boolean status = false;
        try {
            Connection connection = mysqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQr_addNewUser);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, phoneNumber);
            preparedStatement.setString(5, password);
            preparedStatement.setString(6, role);
            status = preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    private boolean status(User user, boolean status) {
        try {
            Connection connection = mysqlConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(UserServiceImpl.sqlQr_editUser);
            String name = user.getName();
            String email = user.getEmail();
            String address = user.getAddress();
            String phoneNumber = user.getPhoneNumber();
            String password = user.getPassword();
            String role = user.getRole();
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setString(4, phoneNumber);
            ps.setString(5, password);
            ps.setString(6, role);
            status = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean status = true;
        User user = findUserById(id);

        if (user == null) {
            status = false;
        }
        try {
            Connection connection = mysqlConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sqlQr_deleteUser);
            ps.setInt(1, id);
            status = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean editUser(int id) {
        boolean status = false;
        User user = findUserById(id);

        return status(user, status);
    }

    @Override
    public User findUserById(int id) {
        List<User> users = findAllUser();
        User myUser = null;
        for (User user : users) {
            if (user.getId() == id) {
                myUser = user;
            }
        }
        return myUser;
    }

    @Override
    public User findUserByEmail(String email) {
        List<User> users = findAllUser();
        User myUser = null;
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                myUser = user;
            }
        }
        return myUser;
    }
}
