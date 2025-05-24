package service;

import model.User;
import storage.UserStorage;

public class UserService {
    private UserStorage storage;

    public UserService(UserStorage storage) {
        this.storage = storage;
    }

    public void addUser(User user) {
        storage.addUser(user);
    }

    public void displayAll() {
        if (storage.getAllUsers().isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (User u : storage.getAllUsers()) {
                u.display();
                System.out.println("------------------------------");
            }
        }
    }

    public void addMarks(String id, String subject, int mark) {
        User user = storage.findById(id);
        if (user != null) {
            user.addMark(subject, mark);
            System.out.println("Mark added successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void searchById(String id) {
        User user = storage.findById(id);
        if (user != null) {
            user.display();
        } else {
            System.out.println("Student not found.");
        }
    }

    public void deleteUser(String id) {
        boolean removed = storage.deleteById(id);
        System.out.println(removed ? "Student deleted successfully." : "Student not found.");
    }
}
