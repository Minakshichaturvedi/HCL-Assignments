package Project3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        // Login system
        String username = "admin";
        String password = "1234";

        System.out.print("Enter username: ");
        String u = sc.nextLine();
        System.out.print("Enter password: ");
        String p = sc.nextLine();

        if (!u.equals(username) || !p.equals(password)) {
            System.out.println("Invalid login. Exiting...");
            return;
        }

        int choice;
        do {
            System.out.println("\n--- Student Management Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by Eno");
            System.out.println("4. Update Student Branch");
            System.out.println("5. Delete Student by Eno");
            System.out.println("6. Display Sorted Students");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter Eno: ");
                        String eno = sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Branch: ");
                        String branch = sc.nextLine();
                        System.out.print("Enter Sem: ");
                        int sem = sc.nextInt();
                        System.out.print("Enter Percentage: ");
                        double percentage = sc.nextDouble();
                        sc.nextLine();

                        Student s = new Student(eno, name, branch, sem, percentage);
                        manager.addStudent(s);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    manager.displayAll();
                    break;

                case 3:
                    System.out.print("Enter Eno to search: ");
                    String searchEno = sc.nextLine();
                    manager.searchByEno(searchEno);
                    break;

                case 4:
                    System.out.print("Enter Eno to update: ");
                    String updateEno = sc.nextLine();
                    System.out.print("Enter new Branch: ");
                    String newBranch = sc.nextLine();
                    manager.updateBranch(updateEno, newBranch);
                    break;

                case 5:
                    System.out.print("Enter Eno to delete: ");
                    String deleteEno = sc.nextLine();
                    manager.deleteByEno(deleteEno);
                    break;

                case 6:
                    manager.displaySorted();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 7);

        sc.close();
    }
}