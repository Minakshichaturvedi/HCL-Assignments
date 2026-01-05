import java.util.*;
import java.util.regex.*;

public class Assignment2 {
    static boolean validateMobile(String s) {
        return Pattern.matches("^[6-9][0-9]{9}$", s);
    }
    static boolean validateEmail(String s) {
        return Pattern.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", s);
    }
    static boolean validateUsername(String s) {
        return Pattern.matches("^[A-Za-z][A-Za-z0-9_]{2,15}$", s);
    }
    static boolean validatePassword(String s) {
        return Pattern.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$", s);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Validate Mobile Number");
            System.out.println("2. Validate Email ID");
            System.out.println("3. Validate Username");
            System.out.println("4. Validate Password");
            System.out.println("5. Exit");
            try {
                int choice = Integer.parseInt(sc.nextLine());
                if (choice == 5) break;
                String input = sc.nextLine();
                boolean ok = false;
                if (choice == 1) ok = validateMobile(input);
                else if (choice == 2) ok = validateEmail(input);
                else if (choice == 3) ok = validateUsername(input);
                else if (choice == 4) ok = validatePassword(input);
                else System.out.println("Invalid");
                if (choice >= 1 && choice <= 4) System.out.println(ok ? "Welcome" : "Invalid");
            } catch (Exception e) {
                System.out.println("Invalid");
            }
        }
    }
}