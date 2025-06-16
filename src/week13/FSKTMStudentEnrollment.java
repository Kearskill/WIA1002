package week13;
/**
 * Group: (Kami Budak DS)
 * Team Member and Module Assignments:
 * Student 1 - Mariam
 * Student 2 - Nabila
 * Student 3 - Dania
 * Student 4 - Ameer & Amri
 * Student 5 - Kearney
 * 2.
 * 3.
 * 4.
 * Student 5: [Kearney Leith Julius] [23001894]: UI and Integration
 */


import java.util.*;
import java.io.*;
import java.util.UUID;

public class FSKTMStudentEnrollment {
    public static String filename = "Book1.csv";
    static Scanner sc = new Scanner(System.in);

// Student 1 (Mariam)

    static class StudentDetails {
        String matricID;
        String name;
        String street1;
        String street2;
        String city;
        String district;
        String state;
        String postcode;
        String programme;
        double cgpa;
        String userID;


        public StudentDetails(String matricID, String name, String street1, String street2, String city, String district, String state, String postcode, String programme, double cgpa, String userID) {
            this.matricID = matricID;
            this.name = name;
            this.street1 = street1;
            this.street2 = street2;
            this.city = city;
            this.district = district;
            this.state = state;
            this.postcode = postcode;
            this.programme = programme;
            this.cgpa = cgpa;
            this.userID = UUID.randomUUID().toString();

        }

        public void printDetails() {
            System.out.println("Name: " + name);
            System.out.println("Matric ID: " + matricID);
            System.out.println("Street 1: " + street1);
            System.out.println("Street 2: " + street2);
            System.out.println("City: " + city);
            System.out.println("District: " + district);
            System.out.println("State: " + state);
            System.out.println("Postcode: " + postcode);
            System.out.println("Programme: " + programme);
            System.out.println("CGPA: " + cgpa);

        }

    }

    class NodeBST {
        StudentDetails data;
        NodeBST left, right;
        int subtreeSize;

        public NodeBST(StudentDetails data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.subtreeSize = 1;
        }
    }

    class StudentBST {
        private NodeBST root;

        public StudentBST() {
            this.root = null;
        }

        public void Insert(StudentDetails details) {
            System.out.println("Adding new student...");
            details.printDetails();
            root = insertRecursive(root, details);
            updateAllSubtreeSizes();
            System.out.println("Subtree sizes updated. Current BST height: " + getHeight());

        }

        private NodeBST insertRecursive(NodeBST node, StudentDetails details) {
            if (node == null) {
                return new NodeBST(details);
            }
            if (details.matricID.compareTo(node.data.matricID) < 0) {
                node.left = insertRecursive(node.left, details);
            } else if (details.matricID.compareTo(node.data.matricID) > 0) {
                node.right = insertRecursive(node.right, details);
            } else {
                System.out.println("Matric ID already exists");
            }
            return node;
        }

        public void DeleteMatricId(String matricID) {
            System.out.println("Enter student matric ID to delete: " + matricID);
            NodeBST[] deletedNode = new NodeBST[1]; // To capture deleted node info
            root = deleteRecursive(root, matricID, deletedNode);
            if (deletedNode[0] != null) {
                System.out.println("Deleting...");
                System.out.println("Matric ID: " + deletedNode[0].data.matricID + ", Name: " + deletedNode[0].data.name +
                        ", Programme: " + deletedNode[0].data.programme + ", CGPA: " + deletedNode[0].data.cgpa);
                updateAllSubtreeSizes();
                System.out.println("Subtree sizes updated. Current BST height: " + getHeight());
            } else {
                System.out.println("Matric ID not found.");
            }
        }

        private NodeBST deleteRecursive(NodeBST node, String matricID, NodeBST[] deletedNode) {
            if (node == null) return null;
            if (matricID.compareTo(node.data.matricID) < 0) {
                node.left = deleteRecursive(node.left, matricID, deletedNode);
            } else if (matricID.compareTo(node.data.matricID) > 0) {
                node.right = deleteRecursive(node.right, matricID, deletedNode);
            } else {
                // Found node to delete
                deletedNode[0] = node;
                if (node.left == null) return node.right;
                if (node.right == null) return node.left;
                // Two children: Find inorder successor
                NodeBST successor = minValueNode(node.right);
                node.data = successor.data;
                node.right = deleteRecursive(node.right, successor.data.matricID, new NodeBST[1]);
            }
            return node;
        }

        private NodeBST minValueNode(NodeBST node) {
            while (node.left != null) node = node.left;
            return node;
        }

        public StudentDetails searchMatricId(String matricID) {
            NodeBST node = root;
            while (node != null) {
                if (matricID.compareTo(node.data.matricID) < 0) node = node.left;
                else if (matricID.compareTo(node.data.matricID) > 0) node = node.right;
                else return node.data;
            }
            return null;
        }

        public void printInOrder() {
            printInOrderRecursive(root);
        }

        private void printInOrderRecursive(NodeBST node) {
            if (node == null) return;
            printInOrderRecursive(node.left);
            node.data.printDetails();
            System.out.println("---");
            printInOrderRecursive(node.right);
        }

        private int updateAllSubtreeSizes() {
            return updateSubtreeSizeRecursive(root);
        }

        private int updateSubtreeSizeRecursive(NodeBST node) {
            if (node == null) return 0;
            int leftSize = updateSubtreeSizeRecursive(node.left);
            int rightSize = updateSubtreeSizeRecursive(node.right);
            node.subtreeSize = leftSize + rightSize + 1;
            return node.subtreeSize;
        }

        public int getHeight() {
            return getHeightRecursive(root);
        }

        private int getHeightRecursive(NodeBST node) {
            if (node == null) return 0;
            int leftHeight = getHeightRecursive(node.left);
            int rightHeight = getHeightRecursive(node.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    String MatricID;
    String name;
    String Programme;
    double cgpa;
    UUID UserID;

    public FSKTMStudentEnrollment(String MatricID, String name, String Programme, double cgpa) {
        this.MatricID = MatricID;
        this.name = name;
        this.Programme = Programme;
        this.cgpa = cgpa;
        this.UserID = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "Matric ID: " + MatricID + " , Name: " + name + " , Programme: " + Programme + " , CGPA: " + cgpa;
    }

    public static class SearchEngine {
        public static void searchByProgramme(List<FSKTMStudentEnrollment> students, String targetProgramme) {
            List<FSKTMStudentEnrollment> results = new ArrayList<>();
            for (FSKTMStudentEnrollment s : students) {
                if (s.Programme.equalsIgnoreCase(targetProgramme)) {
                    results.add(s);
                }
            }

            System.out.println("Searching for students in " + targetProgramme + ":");
            System.out.println("Results: " + results.size() + " student" + (results.size() != 1 ? "s" : "") + " found");
            for (FSKTMStudentEnrollment s : results) {
                System.out.println(" - " + s);
            }
            System.out.println();
        }

        public static void searchByCGPARange(List<FSKTMStudentEnrollment> students, double min, double max) {
            List<FSKTMStudentEnrollment> results = new ArrayList<>();
            for (FSKTMStudentEnrollment s : students) {
                if (s.cgpa >= min && s.cgpa <= max) {
                    results.add(s);
                }
            }

            System.out.println("Searching for students with CGPA between " + min + " to " + max + ":");
            System.out.println("Results: " + results.size() + " student" + (results.size() != 1 ? "s" : "") + " found");
            for (FSKTMStudentEnrollment s : results) {
                System.out.println(" - " + s);
            }
            System.out.println();
        }

        public static void searchByPartialName(List<FSKTMStudentEnrollment> students, String keyword) {
            List<FSKTMStudentEnrollment> results = new ArrayList<>();
            for (FSKTMStudentEnrollment s : students) {
                if (s.name.toLowerCase().contains(keyword.toLowerCase())) {
                    results.add(s);
                }
            }

            System.out.println("Searching for students by name: \"" + keyword + "\"");
            if (results.isEmpty()) {
                System.out.println("Search ended. Student not found.\n");
                return;
            }

            System.out.println("Results: " + results.size() + " student" + (results.size() != 1 ? "s" : "") + " found");
            for (FSKTMStudentEnrollment s : results) {
                System.out.println(" - " + s);
            }
            System.out.println();
        }
    }

    /*public static void main(String[] args) {
        List<FSKTMStudentEnrollment> students = new ArrayList<>();

        students.add(new FSKTMStudentEnrollment("32103232", "Ali bin Abu", "Computer Science", 3.10));
        students.add(new FSKTMStudentEnrollment("45435333", "Very Good Student", "Mathematics IN Engineering", 3.70));
        students.add(new FSKTMStudentEnrollment("65465344", "Timmy Junior", "English for Early Education", 4.00));
        students.add(new FSKTMStudentEnrollment("21313211", "Apt Apt", "Biomedic Science", 3.56));
        students.add(new FSKTMStudentEnrollment("56747676", "Lalalalaa", "Dentistry", 4.00));

        SearchEngine.searchByProgramme(students, "Dentistry");
        SearchEngine.searchByCGPARange(students, 3.70, 4.00);
        SearchEngine.searchByPartialName(students, "timmy");
        SearchEngine.searchByPartialName(students, "al");
        SearchEngine.searchByPartialName(students, "ae");
    }*/


//studnet 4 amer amri

    class StudentRecursion {
        public static int countTotal(NodeBST node) {
            if (node == null) return 0;
            return 1 + countTotal(node.left) + countTotal(node.right);
        }

        public static int countByProgramme(NodeBST node, String programme) {
            if (node == null) return 0;
            int count = node.data.programme.equalsIgnoreCase(programme) ? 1 : 0;
            return count + countByProgramme(node.left, programme) + countByProgramme(node.right, programme);
        }

        public static int countByState(NodeBST node, String state) {
            if (node == null) return 0;
            int count = node.data.state.equalsIgnoreCase(state) ? 1 : 0;
            return count + countByState(node.left, state) + countByState(node.right, state);
        }

        public static int countInCGPARange(NodeBST node, double min, double max) {
            if (node == null) return 0;
            int count = (node.data.cgpa >= min && node.data.cgpa <= max) ? 1 : 0;
            return count + countInCGPARange(node.left, min, max) + countInCGPARange(node.right, min, max);
        }

        public static double sumCgpaState(NodeBST node, String state, int[] count) {
            if (node == null) {
                return 0;
            }
            double sum = 0;
            int counter = node.data.state.equalsIgnoreCase(state) ? 1 : 0; //if true =1, false = 0
            if (node.data.state.equalsIgnoreCase(state)) {
                count[0]++; // array is used instead because of pass in reference
                sum += node.data.cgpa;
            }

            sum += sumCgpaState(node.left, state, count);
            sum += sumCgpaState(node.right, state, count);
            return sum;
        }

        public static int getHeight(NodeBST node) {
            if (node == null) return 0;
            return 1 + Math.max(getHeight(node.left), getHeight(node.right));
        }

        public static int getBalanceFactor(NodeBST node) {
            if (node == null) return 0;
            return getHeight(node.left) - getHeight(node.right);
        }
    }

/*

Student 5(
Kearney Leith):
UI and
Integration
*/

    public static void main(String[] args) {
        // you will expect csv of 4 columns
        while (true) {
            System.out.println("""
                    Welcome to FSKTM Student Enrolment System
                    -----------------------------------------
                    1. Save/Load Records
                    2. Insert Student
                    3. Delete Student
                    4. Search Student
                    5. Sort Student Records
                    6. Show Statistics
                    7. History
                    8. Exit
                    
                    Enter choice:
                    """);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    saveRecords();
                    break;
                case 2:
                    insertRecords();
                    break;
                case 3:
                    deleteRecords();
                    break;
                case 4:
                    searchRecords();
                    break;
                case 5:
                    sortRecords();
                    break;
                case 6:
                    showStatistics();
                    break;
                case 7:
                    showHistory();
                    break;
                case 8:
                    System.out.println("Exiting FSKTM Student Enrollment, see you next time.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

//        Map<String, Patient> patients = FileHandler.loadPatients(filename);
//        UndoManager undoManager = new UndoManager();
//        Menu menu = new Menu(patients, undoManager);
//
//        menu.show();
//
//        FileHandler.savePatients(patients, filename);
    }

    private static void saveRecords() {
        System.out.println("Saving records to " + filename);
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            students.clear(); // clear current list before loading
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    Student student = new Student(parts[0], parts[1], parts[2]);
                    students.add(student);
                }
            }
            System.out.println("Records loaded from " + filename);
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }

        System.out.println("Loaded ");
    }

    private static void insertRecords() {

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
        double cgpa = sc.nextDouble();

        System.out.println("""
                Adding new student…
                Name: Liew Wei Shiung
                Matric ID: WHA10061
                Street 1: 123, Level 4, Apartment FiveSixSeven
                Street 2: Jalan Lapan
                City: Petaling Jaya
                District: Petaling
                State: Selangor
                Postcode: 47800
                Programme: Artificial Intelligence
                CGPA: 2.80
                Subtree sizes updated. Current BST height: 3
                """);
    }

    private static void deleteRecords() {
        System.out.println("Deleting records");
        System.out.println("Enter student matric ID to delete: ");
        String toDelete = sc.nextLine();
        System.out.println("Deleting...");
        System.out.println("""
                Matric ID: WHA10061, Name: Liew Wei Shiung, Programme: AI, CGPA: 2.80
                Subtree sizes updated. Current BST height: 2
                """);

    }

    private static void searchRecords() {
        System.out.println("Searching records");
        System.out.println("Search by: 1 (ID), 2 (Name), 3 (Partial Name), 4 (Address), 5 (Programme), 6 (CGPA): ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter ID to search for: ");
                int IDToSearch = sc.nextInt();

                boolean IDFound = false;
                if (tree.has(IDToSearch)) {
                    IDFound = true;
                }
                if (!IDFound) {
                    System.out.println("Search ended. Student not found.");
                    break;
                }
                //some logic goes here

                break;
            case 2:
                System.out.println("Enter Name to search for: ");
                String nameToSearch = sc.nextLine();
                boolean studentFound = false;

                if (tree.has(nameToSearch)) {
                    studentFound = true;
                }
                if (!studentFound) {
                    System.out.println("Search ended. Student not found.");
                    break;
                }


                break;
            case 3:
                System.out.println("Enter partial name to search for: ");
                String partialNameToSearch = sc.nextLine();

                boolean studentFound = false;
                if (tree.has(nameToSearch)) {
                    studentFound = true;
                }
                if (!studentFound) {
                    System.out.println("Search ended. Student not found.");
                    break;
                }
                break;
            case 4:
                System.out.println("Enter address to search for: ");
                String addressToSearch = sc.nextLine();
                break;
            case 5:
                System.out.println("Enter programme to search for: ");
                String programmeToSearch = sc.nextLine();

                break;
            case 6:
                System.out.println("Enter CGPA to search for: ");
                int cgpaToSearch = sc.nextInt();
                boolean correctFormat = false;
                while (!correctFormat) {
                    System.out.println("Enter CGPA range to search for (min), (max): ");
                    String[] parts = sc.nextLine().split(", ");
                    if (parts.length != 2) {
                        System.out.println("Error: please enter a valid range to search for:");
                        correctFormat = false;
                        break; // or throw an exception
                    } else {
                        correctFormat = true;
                    }
                }

                System.out.println("Results:  students found");
                for (int i = 0; i < 5; i++) {
                    System.out.println("studnet 1");
                }

                break;


        }
    }

    private static void sortRecords() {
        System.out.println("""
                Choose which fields to sort. Current selection [CGPA] (Descending), [Matric ID] (Ascending)
                1. Matric ID
                2. Name
                3. Address
                4. Programme
                5. CGPA
                """);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:

        }
    }

    private static void showStatistics() {
        System.out.println("This is what the statistics look like");
    }

    private static void showHistory() {
        System.out.println("Showing history");
    }


    class Module3Sorting {
        public static String[][] readCSV(String filename) {
            List<String[]> data = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;

                while ((line = br.readLine()) != null) {
                    // split line into columns
                    String[] parts = line.split(",", 7); // split into max 7 parts to combine address
                    if (parts.length == 7) {
                        String address = parts[2].trim() + ", " + parts[3].trim() + ", " + parts[4].trim();
                        String[] student = {
                                parts[0].trim(), // Matric ID
                                parts[1].trim(), // Name
                                address,         // Combined Address
                                parts[5].trim(), // Programme
                                parts[6].trim()  // CGPA
                        };
                        data.add(student);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }

            // convert to String[][]
            return data.toArray(new String[0][0]);
        }
    }

    static String[][] students = {
            {"WHA10081", "Ali Zain", "Selangor, Petaling, 46000", "AI", "3.88"},
            {"WHA10072", "Mohd Aladdin", "Johor, Johor Bahru, 80000", "AI", "3.99"},
            {"WHA10095", "Fatimah Nur", "Kedah, Alor Setar, 05000", "CS", "3.80"},
            {"WHA10012", "Zulaikha", "Sabah, Kota Kinabalu, 88000", "DS", "3.88"},
            {"WHA10081", "TestStudentPleaseIgnore", "Selangor, Petaling, 46000", "AI", "3.98"}
    };

    static final String[] FIELD_NAMES = {"Matric ID", "Name", "Address", "Programme", "CGPA"};

    public static void bubbleSort(String[][] list, int[] fields, boolean[] ascending) {
        boolean needNextPass = true;

        for (int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false;

            for (int i = 0; i < list.length - k; i++) {
                if (compare(list[i], list[i + 1], fields, ascending) > 0) {
                    // swap
                    String[] temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    needNextPass = true;
                }
            }
        }
    }

    public static int compare(String[] a, String[] b, int[] fields, boolean[] ascending) {
        for (int i = 0; i < fields.length; i++) {
            int col = fields[i];
            int cmp;

            if (col == 4) { // CGPA
                double d1 = Double.parseDouble(a[col]);
                double d2 = Double.parseDouble(b[col]);
                cmp = Double.compare(d1, d2);
            } else {
                cmp = a[col].compareToIgnoreCase(b[col]);
            }

            if (cmp != 0) return ascending[i] ? cmp : -cmp;
        }
        return 0;
    }


    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> selectedFields = new ArrayList<>();
        List<Boolean> ascendingOrder = new ArrayList<>();

        System.out.println("Module 3: Sorting\n*User can choose what field and what order to sort\n*Multi-field sorting");

        while (true) {
            // display current selection
            System.out.print("\nChoose which fields to sort. Current selection ");
            if (selectedFields.isEmpty()) {
                System.out.println("[None]");
            } else {
                for (int i = 0; i < selectedFields.size(); i++) {
                    System.out.print("[" + FIELD_NAMES[selectedFields.get(i)] + "] (" +
                            (ascendingOrder.get(i) ? "Ascending" : "Descending") + ")");
                    if (i < selectedFields.size() - 1) System.out.print(", ");
                }
                System.out.println();
            }

            // display field menu
            for (int i = 0; i < FIELD_NAMES.length; i++) {
                System.out.println((i + 1) + ". " + FIELD_NAMES[i]);
            }
            System.out.print("Enter your choice (1-5, 0 to finish): ");
            int choice = sc.nextInt();

            if (choice == 0) break;
            if (choice < 1 || choice > 5 || selectedFields.contains(choice - 1)) {
                System.out.println("Invalid or already selected. Try again.");
                continue;
            }

            System.out.println("You have selected [" + FIELD_NAMES[choice - 1] + "]. Which order to sort?");
            System.out.println("1. Ascending\n2. Descending");
            System.out.print("Enter order: ");
            int order = sc.nextInt();

            selectedFields.add(choice - 1);
            ascendingOrder.add(order == 1);
        }

        // convert to arrays
        int[] fields = selectedFields.stream().mapToInt(i -> i).toArray();
        boolean[] order = new boolean[ascendingOrder.size()];
        for (int i = 0; i < ascendingOrder.size(); i++) {
            order[i] = ascendingOrder.get(i);
        }

        // sort
        bubbleSort(students, fields, order);

        // output
        System.out.print("\nSorted student list by ");
        for (int i = 0; i < fields.length; i++) {
            System.out.print("[" + FIELD_NAMES[fields[i]] + "] (" + (order[i] ? "Ascending" : "Descending") + ")");
            if (i < fields.length - 1) System.out.print(" then ");
        }
        System.out.println();

        for (String[] s : students) {
            System.out.println("- Matric ID: " + s[0] + ", Name: " + s[1] + ", Programme: " + s[3] + ", CGPA: " + s[4]);
        }
    }*/
}