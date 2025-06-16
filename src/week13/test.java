package week13;

// FSKTMStudentEnrollment.java
import java.io.*;
import java.util.*;
import java.util.UUID;

public class test {
    // ============================ Module 1: Student Record Storage ============================
    static class Student implements Comparable<Student> {
        String matricID, name, street, city, district, state, postcode, programme;
        double cgpa;
        UUID userID;

        Student(String matricID, String name, String street, String city, String district, String state, String postcode, String programme, double cgpa) {
            this.matricID = matricID;
            this.name = name;
            this.street = street;
            this.city = city;
            this.district = district;
            this.state = state;
            this.postcode = postcode;
            this.programme = programme;
            this.cgpa = cgpa;
            this.userID = UUID.randomUUID();
        }

        @Override
        public int compareTo(Student s) {
            return this.matricID.compareTo(s.matricID);
        }

        public String toString() {
            return matricID + "," + name + "," + street + "," + city + "," + district + "," + state + "," + postcode + "," + programme + "," + cgpa + "," + userID;
        }
    }

    static class TreeNode {
        Student student;
        TreeNode left, right;
        int size;

        TreeNode(Student student) {
            this.student = student;
            this.size = 1;
        }
    }

    static class BST {
        TreeNode root;
        Stack<TreeNode> history = new Stack<>();

        TreeNode insert(TreeNode node, Student student) {
            if (node == null) return new TreeNode(student);
            if (student.compareTo(node.student) < 0)
                node.left = insert(node.left, student);
            else if (student.compareTo(node.student) > 0)
                node.right = insert(node.right, student);
            else
                return node;
            node.size = 1 + size(node.left) + size(node.right);
            return node;
        }

        void insert(Student student) {
            root = insert(root, student);
            System.out.println("Inserted: " + student.name);
        }

        TreeNode delete(TreeNode node, String matricID) {
            if (node == null) return null;
            int cmp = matricID.compareTo(node.student.matricID);
            if (cmp < 0)
                node.left = delete(node.left, matricID);
            else if (cmp > 0)
                node.right = delete(node.right, matricID);
            else {
                if (node.left == null) return node.right;
                if (node.right == null) return node.left;
                TreeNode min = min(node.right);
                node.student = min.student;
                node.right = delete(node.right, min.student.matricID);
            }
            node.size = 1 + size(node.left) + size(node.right);
            return node;
        }

        TreeNode min(TreeNode node) {
            while (node.left != null) node = node.left;
            return node;
        }

        void delete(String matricID) {
            history.push(root);
            root = delete(root, matricID);
            System.out.println("Deleted student with ID: " + matricID);
        }

        TreeNode search(TreeNode node, String matricID) {
            if (node == null) return null;
            int cmp = matricID.compareTo(node.student.matricID);
            if (cmp < 0) return search(node.left, matricID);
            if (cmp > 0) return search(node.right, matricID);
            return node;
        }

        void inOrder(TreeNode node, List<Student> list) {
            if (node == null) return;
            inOrder(node.left, list);
            list.add(node.student);
            inOrder(node.right, list);
        }

        int size(TreeNode node) {
            return node == null ? 0 : node.size;
        }

        int height(TreeNode node) {
            if (node == null) return 0;
            return 1 + Math.max(height(node.left), height(node.right));
        }

        int balanceFactor(TreeNode node) {
            return node == null ? 0 : height(node.left) - height(node.right);
        }

        void undo() {
            if (!history.isEmpty()) {
                root = history.pop();
                System.out.println("Undo successful.");
            } else {
                System.out.println("Nothing to undo.");
            }
        }
    }

    // ============================ Module 2: Search ============================
    static class Search {
        static List<Student> byProgramme(TreeNode node, String programme) {
            List<Student> result = new ArrayList<>();
            searchProgramme(node, programme, result);
            return result;
        }

        private static void searchProgramme(TreeNode node, String programme, List<Student> result) {
            if (node == null) return;
            searchProgramme(node.left, programme, result);
            if (node.student.programme.equalsIgnoreCase(programme)) result.add(node.student);
            searchProgramme(node.right, programme, result);
        }
    }

    // ============================ Module 3: Sorting ============================
    static class Sort {
        static void bubbleSort(List<Student> list) {
            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = 0; j < list.size() - i - 1; j++) {
                    if (list.get(j).name.compareTo(list.get(j + 1).name) > 0) {
                        Collections.swap(list, j, j + 1);
                    }
                }
            }
        }

        static void insertionSort(List<Student> list) {
            for (int i = 1; i < list.size(); i++) {
                Student key = list.get(i);
                int j = i - 1;
                while (j >= 0 && list.get(j).name.compareTo(key.name) > 0) {
                    list.set(j + 1, list.get(j));
                    j--;
                }
                list.set(j + 1, key);
            }
        }
    }

    // ============================ Module 4: Recursion ============================
    static class Statistics {
        static int countProgramme(TreeNode node, String programme) {
            if (node == null) return 0;
            int count = node.student.programme.equalsIgnoreCase(programme) ? 1 : 0;
            return count + countProgramme(node.left, programme) + countProgramme(node.right, programme);
        }

        static double averageCGPA(TreeNode node, String programme) {
            List<Double> cgpas = new ArrayList<>();
            collectCGPA(node, programme, cgpas);
            return cgpas.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        }

        static void collectCGPA(TreeNode node, String programme, List<Double> cgpas) {
            if (node == null) return;
            collectCGPA(node.left, programme, cgpas);
            if (node.student.programme.equalsIgnoreCase(programme)) cgpas.add(node.student.cgpa);
            collectCGPA(node.right, programme, cgpas);
        }
    }

    // ============================ Module 5: UI and Integration ============================
    public static void main(String[] args) throws IOException {
        BST tree = new BST();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nFSKTM Student Enrolment System");
            System.out.println("1. Insert Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Search by Programme");
            System.out.println("4. Sort Students");
            System.out.println("5. Statistics");
            System.out.println("6. Undo");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt(); sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Matric ID: ");
                    String id = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Street: ");
                    String street = sc.nextLine();
                    System.out.print("City: ");
                    String city = sc.nextLine();
                    System.out.print("District: ");
                    String district = sc.nextLine();
                    System.out.print("State: ");
                    String state = sc.nextLine();
                    System.out.print("Postcode: ");
                    String postcode = sc.nextLine();
                    System.out.print("Programme: ");
                    String programme = sc.nextLine();
                    System.out.print("CGPA: ");
                    double cgpa = sc.nextDouble(); sc.nextLine();
                    tree.insert(new Student(id, name, street, city, district, state, postcode, programme, cgpa));
                    break;

                case 2:
                    System.out.print("Enter Matric ID to delete: ");
                    String delID = sc.nextLine();
                    tree.delete(delID);
                    break;

                case 3:
                    System.out.print("Enter programme: ");
                    String prog = sc.nextLine();
                    List<Student> found = Search.byProgramme(tree.root, prog);
                    if (found.isEmpty()) System.out.println("No students found.");
                    else found.forEach(s -> System.out.println(s));
                    break;

                case 4:
                    List<Student> list = new ArrayList<>();
                    tree.inOrder(tree.root, list);
                    Sort.bubbleSort(list);
                    list.forEach(System.out::println);
                    break;

                case 5:
                    System.out.print("Programme for stats: ");
                    String p = sc.nextLine();
                    int count = Statistics.countProgramme(tree.root, p);
                    double avg = Statistics.averageCGPA(tree.root, p);
                    System.out.println("Count: " + count + ", Avg CGPA: " + avg);
                    break;

                case 6:
                    tree.undo();
                    break;

                case 7:
                    return;
            }
        }
    }
}
