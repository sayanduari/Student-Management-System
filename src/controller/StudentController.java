package controller;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import model.Student;

import java.util.List;
import java.util.Scanner;

public class StudentController {

    private StudentDAO studentDAO = new StudentDAOImpl();
    private Scanner sc = new Scanner(System.in);

    public void addStudent() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter department: ");
        String dept = sc.nextLine();

        System.out.print("Enter marks: ");
        double marks = sc.nextDouble();
        sc.nextLine();

        Student student = new Student(name, email, dept, marks);
        studentDAO.addStudent(student);

        System.out.println("Student added successfully.");
    }

    public void viewStudents() {
        List<Student> students = studentDAO.getAllStudents();

        for (Student s : students) {
            System.out.println(
                s.getId() + " | " +
                s.getName() + " | " +
                s.getEmail() + " | " +
                s.getDept() + " | " +
                s.getMarks()
            );
        }
    }

    public void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter new name: ");
        String name = sc.nextLine();

        System.out.print("Enter new email: ");
        String email = sc.nextLine();

        System.out.print("Enter new department: ");
        String dept = sc.nextLine();

        System.out.print("Enter new marks: ");
        double marks = sc.nextDouble();
        sc.nextLine();

        Student student = new Student(id, name, email, dept, marks);
        studentDAO.updateStudent(student);

        System.out.println("Student updated successfully.");
    }

    public void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        studentDAO.deleteStudent(id);
        System.out.println("Student deleted successfully.");
    }
}
