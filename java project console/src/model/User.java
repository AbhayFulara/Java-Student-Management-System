package model;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private String studentClass;
    private String studentId;
    private String gender;
    private double totalFee;
    private double amountPaid;
    private Map<String, Integer> marks = new HashMap<>();

    public User(String name, String studentClass, String studentId, String gender, double totalFee, double amountPaid) {
        this.name = name;
        this.studentClass = studentClass;
        this.studentId = studentId;
        this.gender = gender;
        this.totalFee = totalFee;
        this.amountPaid = amountPaid;
    }

    public String getStudentId() {
        return studentId;
    }

    public void addMark(String subject, int mark) {
        marks.put(subject, mark);
    }

    public double getPendingFee() {
        return totalFee - amountPaid;
    }

    public void display() {
        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + name);
        System.out.println("Class      : " + studentClass);
        System.out.println("Gender     : " + gender);
        System.out.println("Total Fee  : " + totalFee);
        System.out.println("Amount Paid: " + amountPaid);
        System.out.println("Pending    : " + getPendingFee());
        System.out.println("Marks:");
        if (marks.isEmpty()) {
            System.out.println("  No marks available.");
        } else {
            marks.forEach((subject, mark) -> System.out.println("  " + subject + ": " + mark));
        }
    }
}


