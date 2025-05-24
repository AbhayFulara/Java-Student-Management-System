package storage;

import model.User;
import java.util.ArrayList;
import java.util.List;

public class UserStorage {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User findById(String id) {
        for (User user : users) {
            if (user.getStudentId().equalsIgnoreCase(id)) {
                return user;
            }
        }
        return null;
    }

    public boolean deleteById(String id) {
        User user = findById(id);
        if (user != null) {
            users.remove(user);
            return true;
        }
        return false;
    }
}
