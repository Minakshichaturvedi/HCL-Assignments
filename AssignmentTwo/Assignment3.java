import java.util.*;
import java.util.regex.*;

interface StudentOps {
    void addStudent(int roll, String name);
    void displayAll();
    void removeByRoll(int roll);
    void searchByRoll(int roll);
}

class Student {
    int roll;
    String name;
    Student(int r, String n) { roll = r; name = n; }
    public String toString() { return roll + " " + name; }
}

class StudentManager implements StudentOps {
    List<Student> list = new ArrayList<>();
    Vector<Student> vector = new Vector<>();

    boolean validRoll(String s) {
        return Pattern.matches("^[1-9][0-9]{0,5}$", s);
    }

    boolean validName(String s) {
        return Pattern.matches("^[A-Za-z ]{2,40}$", s);
    }

    public void addStudent(int roll, String name) {
        list.add(new Student(roll, name));
        vector.add(new Student(roll, name));
    }

    public void displayAll() {
        for (Student s : list) System.out.println(s);
    }

    public void removeByRoll(int roll) {
        list.removeIf(s -> s.roll == roll);
        vector.removeIf(s -> s.roll == roll);
    }

    public void searchByRoll(int roll) {
        Student f = null;
        for (Student s : list) if (s.roll == roll) { f = s; break; }
        System.out.println(f == null ? "Not Found" : f);
    }
}

public class Assignment3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager m = new StudentManager();
        while (true) {
            System.out.println("1 Add");
            System.out.println("2 Display");
            System.out.println("3 Remove");
            System.out.println("4 Search");
            System.out.println("5 Exit");
            try {
                int ch = Integer.parseInt(sc.nextLine());
                if (ch == 5) break;
                if (ch == 1) {
                    String r = sc.nextLine();
                    String n = sc.nextLine();
                    if (!m.validRoll(r) || !m.validName(n)) System.out.println("Invalid");
                    else m.addStudent(Integer.parseInt(r), n);
                } else if (ch == 2) {
                    m.displayAll();
                } else if (ch == 3) {
                    int r = Integer.parseInt(sc.nextLine());
                    m.removeByRoll(r);
                } else if (ch == 4) {
                    int r = Integer.parseInt(sc.nextLine());
                    m.searchByRoll(r);
                } else {
                    System.out.println("Invalid");
                }
            } catch (Exception e) {
                System.out.println("Invalid");
            }
        }
    }
}