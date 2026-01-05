package Project3;

import java.util.*;
class DuplicateEnoException extends Exception {
    public DuplicateEnoException(String msg) { super(msg); }
}

class InvalidPercentageException extends Exception {
    public InvalidPercentageException(String msg) { super(msg); }
}

class EmptyFieldException extends Exception {
    public EmptyFieldException(String msg) { super(msg); }
}

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student s) throws DuplicateEnoException, InvalidPercentageException, EmptyFieldException {
        // Validation
        for (Student st : students) {
            if (st.getEno().equals(s.getEno())) {
                throw new DuplicateEnoException("Eno must be unique!");
            }
        }
        if (s.getPercentage() <= 0) {
            throw new InvalidPercentageException("Percentage must be positive!");
        }
        if (s.getBranch() == null || s.getBranch().isEmpty() || s.getSem() <= 0) {
            throw new EmptyFieldException("Branch and Sem cannot be empty or invalid!");
        }

        students.add(s);
        System.out.println("Student added successfully!");
    }

    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    public void searchByEno(String eno) {
        for (Student s : students) {
            if (s.getEno().equals(eno)) {
                System.out.println("Found: " + s);
                return;
            }
        }
        System.out.println("Student with Eno " + eno + " not found.");
    }

    public void updateBranch(String eno, String newBranch) {
        for (Student s : students) {
            if (s.getEno().equals(eno)) {
                s.setBranch(newBranch);
                System.out.println("Branch updated successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void deleteByEno(String eno) {
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.getEno().equals(eno)) {
                it.remove();
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void displaySorted() {
        students.sort(Comparator.comparing(Student::getName));
        System.out.println("Sorted Students:");
        displayAll();
    }
}