package week13;

import java.io.*;
import java.util.*;

// Entry point and core class
public class test1 {
    public static void main(String[] args) {
        EnrollmentSystem system = new EnrollmentSystem();
        system.loadDataFromFile("Book1.csv");
        system.menu();
        system.saveDataToFile("Book2.csv");
    }
}

// Student class
class Student implements Comparable<Student> {
    String id;
    String name;
    String program;

    public Student(String id, String name, String program) {
        this.id = id;
        this.name = name;
        this.program = program;
    }

    @Override
    public int compareTo(Student other) {
        return this.id.compareTo(other.id);
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Program: %s", id, name, program);
    }
}

// BST Node
class TreeNode {
    Student student;
    TreeNode left, right;

    public TreeNode(Student student) {
        this.student = student;
    }
}

// BST Implementation
class BST {
    TreeNode root;

    public boolean insert(Student s) {
        if (root == null) {
            root = new TreeNode(s);
            return true;
        }
        TreeNode current = root;
        while (true) {
            if (s.compareTo(current.student) < 0) {
                if (current.left == null) {
                    current.left = new TreeNode(s);
                    return true;
                }
                current = current.left;
            } else if (s.compareTo(current.student) > 0) {
                if (current.right == null) {
                    current.right = new TreeNode(s);
                    return true;
                }
                current = current.right;
            } else {
                return false;
            }
        }
    }

    public Student search(String id) {
        TreeNode current = root;
        while (current != null) {
            if (id.compareTo(current.student.id) < 0) {
                current = current.left;
            } else if (id.compareTo(current.student.id) > 0) {
                current = current.right;
            } else {
                return current.student;
            }
        }
        return null;
    }

    public void inOrderTraversal(List<Student> list) {
        inOrder(root, list);
    }

    private void inOrder(TreeNode node, List<Student> list) {
        if (node != null) {
            inOrder(node.left, list);
            list.add(node.student);
            inOrder(node.right, list);
        }
    }

    public int count() {
        return countNodes(root);
    }

    private int countNodes(TreeNode node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public int countProgram(String program) {
        return countProgramRecursive(root, program);
    }

    private int countProgramRecursive(TreeNode node, String program) {
        if (node == null) return 0;
        int count = 0;
        if (node.student.program.equalsIgnoreCase(program)) count++;
        count += countProgramRecursive(node.left, program);
        count += countProgramRecursive(node.right, program);
        return count;
    }
}

// Main Enrollment System
class EnrollmentSystem {
    BST tree = new BST();
    Scanner scanner = new Scanner(System.in);

    public void menu() {
        int choice;
        do {
            System.out.println("\nFSKTM Student Enrollment System");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student by ID");
            System.out.println("3. Display All Students (Sorted)");
            System.out.println("4. Count Students");
            System.out.println("5. Count by Program");
            System.out.println("6. Exit and Save");
            System.out.print("Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> searchStudent();
                case 3 -> displayAllStudents();
                case 4 -> System.out.println("Total Students: " + tree.count());
                case 5 -> countByProgram();
                case 6 -> System.out.println("Saving and exiting...");
                default -> System.out.println("Invalid option.");
            }
        } while (choice != 6);
    }

    private void addStudent() {
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Program: ");
        String program = scanner.nextLine();
        Student s = new Student(id, name, program);
        if (tree.insert(s)) {
            System.out.println("Student added.");
        } else {
            System.out.println("Duplicate ID. Not added.");
        }
    }

    private void searchStudent() {
        System.out.print("Enter ID to search: ");
        String id = scanner.nextLine();
        Student s = tree.search(id);
        if (s != null) {
            System.out.println("Found: " + s);
        } else {
            System.out.println("Student not found.");
        }
    }

    private void displayAllStudents() {
        List<Student> list = new ArrayList<>();
        tree.inOrderTraversal(list);
        System.out.println("\n-- All Students (Sorted by ID) --");
        for (Student s : list) {
            System.out.println(s);
        }
    }

    private void countByProgram() {
        System.out.print("Enter Program to count: ");
        String prog = scanner.nextLine();
        int count = tree.countProgram(prog);
        System.out.println("Total in " + prog + ": " + count);
    }

    public void loadDataFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("Loading data from file...");
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    Student s = new Student(parts[0], parts[1], parts[2]);
                    tree.insert(s);
                }
            }
        } catch (IOException e) {
            System.out.println("No existing data found.");
        }
    }

    public void saveDataToFile(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            List<Student> list = new ArrayList<>();
            tree.inOrderTraversal(list);
            for (Student s : list) {
                pw.println(s.id + "," + s.name + "," + s.program);
            }
            System.out.println("Data saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }
}
