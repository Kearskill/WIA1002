package week13;
/*
* Group: (Kami Budak DS)
* Team Member and Module Assignments:
*
* 2.
* 3.
* 4.
* Student 5: [Kearney Leith Julius] [23001894]: UI and Integration
* */

import java.util.*;
import java.io.*;
public class FSKTMStudentEnrollment {
    public static String filename = "Book1.csv";
    static Scanner sc = new Scanner(System.in);


    /* Student 5 (Kearney Leith): UI and Integration */
    public static void main(String[] args) {
        // you will expect csv of 4 columns
        while(true) {
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

    private static void saveRecords(){
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

    private static void insertRecords(){

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

    private static void deleteRecords(){
        System.out.println("Deleting records");
        System.out.println("Enter student matric ID to delete: ");
        String toDelete = sc.nextLine();
        System.out.println("Deleting...");
        System.out.println("""
                Matric ID: WHA10061, Name: Liew Wei Shiung, Programme: AI, CGPA: 2.80
                Subtree sizes updated. Current BST height: 2
                """);

    }
    private static void searchRecords(){
        System.out.println("Searching records");
        System.out.println("Search by: 1 (ID), 2 (Name), 3 (Partial Name), 4 (Address), 5 (Programme), 6 (CGPA): ");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                System.out.println("Enter ID to search for: ");
                int IDToSearch = sc.nextInt();

                boolean IDFound = false;
                if (tree.has(IDToSearch)){
                    IDFound = true;
                }
                if (!IDFound){
                    System.out.println("Search ended. Student not found.");
                    break;
                }
                /*some logic goes here*/
                break;
            case 2:
                System.out.println("Enter Name to search for: ");
                String nameToSearch = sc.nextLine();
                boolean studentFound = false;

                if (tree.has(nameToSearch)){
                    studentFound = true;
                }
                if (!studentFound){
                    System.out.println("Search ended. Student not found.");
                    break;
                }


                break;
            case 3:
                System.out.println("Enter partial name to search for: ");
                String partialNameToSearch = sc.nextLine();

                boolean studentFound = false;
                if (tree.has(nameToSearch)){
                    studentFound = true;
                }
                if (!studentFound){
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

                System.out.println("Results: " + /*getNumber* + */  " students found");
                for (int i = 0; i < 5; i++) {
                    System.out.println("studnet 1");
                }

                break;


        }
    }

    private static void sortRecords(){
        System.out.println("""
                Choose which fields to sort. Current selection [CGPA] (Descending), [Matric ID] (Ascending)
                1. Matric ID
                2. Name
                3. Address
                4. Programme
                5. CGPA
                """);
        int choice = sc.nextInt();
        switch (choice){
            case 1:

        }
    }
    private static void showStatistics(){
        System.out.println("This is what the statistics look like");
    }

    private static void showHistory(){
        System.out.println("Showing history");
    }
}
