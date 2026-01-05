import java.io.*;
import java.util.*;
import java.util.regex.*;

class Employee implements Serializable {
    private String id;
    private String name;
    private double salary;
    private String department;

    public Employee(String id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }

    public void setSalary(double salary) { this.salary = salary; }

    public String toString() {
        return id + " " + name + " " + salary + " " + department;
    }
}

class EmployeeManager {
    private Map<String, Employee> employees = new HashMap<>();
    private final String file = "employees.dat";

    public EmployeeManager() { loadData(); }

    public void addEmployee(Employee e) {
        if (employees.containsKey(e.getId())) throw new RuntimeException("Employee ID must be unique");
        if (e.getSalary() <= 0) throw new RuntimeException("Salary must be positive");
        if (e.getDepartment() == null || e.getDepartment().isBlank()) throw new RuntimeException("Department cannot be empty");
        employees.put(e.getId(), e);
        saveData();
    }

    public void displayAll() {
        for (Employee e : employees.values()) System.out.println(e);
    }

    public Employee searchById(String id) {
        return employees.get(id);
    }

    public void updateSalary(String id, double salary) {
        Employee e = employees.get(id);
        if (e == null) throw new RuntimeException("Employee not found");
        if (salary <= 0) throw new RuntimeException("Salary must be positive");
        e.setSalary(salary);
        saveData();
    }

    public void deleteEmployee(String id) {
        if (!employees.containsKey(id)) throw new RuntimeException("Employee not found");
        employees.remove(id);
        saveData();
    }

    public void displaySorted() {
        List<Employee> list = new ArrayList<>(employees.values());
        list.sort(Comparator.comparing(Employee::getName));
        for (Employee e : list) System.out.println(e);
    }

    public void displayDepartments() {
        Set<String> depts = new HashSet<>();
        for (Employee e : employees.values()) depts.add(e.getDepartment());
        for (String d : depts) System.out.println(d);
    }

    private void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(employees);
        } catch (Exception e) {
            System.out.println("Error saving data");
        }
    }

    private void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            employees = (Map<String, Employee>) ois.readObject();
        } catch (Exception e) {
            employees = new HashMap<>();
        }
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Login: Enter username and password");
        String user = sc.nextLine();
        String pass = sc.nextLine();
        if (!user.equals("admin") || !pass.equals("admin123")) {
            System.out.println("Invalid Login");
            return;
        }
        EmployeeManager manager = new EmployeeManager();
        while (true) {
            System.out.println("1 Add Employee");
            System.out.println("2 Display All Employees");
            System.out.println("3 Search Employee by ID");
            System.out.println("4 Update Employee Salary");
            System.out.println("5 Delete Employee");
            System.out.println("6 Display Sorted Employees");
            System.out.println("7 Display Departments");
            System.out.println("8 Exit");
            try {
                int ch = Integer.parseInt(sc.nextLine());
                if (ch == 8) break;
                if (ch == 1) {
                    System.out.println("Enter ID, Name, Salary, Department");
                    String id = sc.nextLine();
                    String name = sc.nextLine();
                    double salary = Double.parseDouble(sc.nextLine());
                    String dept = sc.nextLine();
                    manager.addEmployee(new Employee(id, name, salary, dept));
                } else if (ch == 2) {
                    manager.displayAll();
                } else if (ch == 3) {
                    String id = sc.nextLine();
                    Employee e = manager.searchById(id);
                    System.out.println(e == null ? "Not Found" : e);
                } else if (ch == 4) {
                    String id = sc.nextLine();
                    double salary = Double.parseDouble(sc.nextLine());
                    manager.updateSalary(id, salary);
                } else if (ch == 5) {
                    String id = sc.nextLine();
                    manager.deleteEmployee(id);
                } else if (ch == 6) {
                    manager.displaySorted();
                } else if (ch == 7) {
                    manager.displayDepartments();
                } else {
                    System.out.println("Invalid Choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}