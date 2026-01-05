import java.util.*;
import java.util.regex.*;

interface EmpOps {
    void add(int id, String name);
    void displayAll();
    void search(int id);
    void remove(int id);
}

class Employee {
    int id;
    String name;
    Employee(int i, String n) { id = i; name = n; }
    public String toString() { return id + " " + name; }
}

class EmpManager implements EmpOps {
    HashMap<Integer, Employee> hm = new HashMap<>();
    Hashtable<Integer, Employee> ht = new Hashtable<>();
    TreeMap<Integer, Employee> tm = new TreeMap<>();

    boolean validId(String s) {
        return Pattern.matches("^[1-9][0-9]{0,5}$", s);
    }

    boolean validName(String s) {
        return Pattern.matches("^[A-Za-z ]{2,40}$", s);
    }

    public void add(int id, String name) {
        Employee e = new Employee(id, name);
        hm.put(id, e);
        ht.put(id, e);
        tm.put(id, e);
    }

    public void displayAll() {
        for (Map.Entry<Integer, Employee> x : hm.entrySet()) System.out.println("HM " + x.getValue());
        for (Map.Entry<Integer, Employee> x : ht.entrySet()) System.out.println("HT " + x.getValue());
        for (Map.Entry<Integer, Employee> x : tm.entrySet()) System.out.println("TM " + x.getValue());
    }

    public void search(int id) {
        Employee e = hm.get(id);
        System.out.println(e == null ? "Not Found" : e);
    }

    public void remove(int id) {
        hm.remove(id);
        ht.remove(id);
        tm.remove(id);
    }

    void demoNullSupport() {
        hm.put(null, null);
        System.out.println("HM null key " + hm.containsKey(null));
        try {
            ht.put(null, null);
        } catch (Exception ex) {
            System.out.println("HT no null key");
        }
        try {
            tm.put(null, null);
        } catch (Exception ex) {
            System.out.println("TM no null key");
        }
        hm.put(999, null);
        ht.put(999, null);
        tm.put(999, null);
        System.out.println("HM null value " + (hm.get(999) == null));
        System.out.println("HT null value " + (ht.get(999) == null));
        System.out.println("TM null value " + (tm.get(999) == null));
    }
}

public class Assignment4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmpManager m = new EmpManager();
        while (true) {
            System.out.println("1 Add");
            System.out.println("2 Display");
            System.out.println("3 Search");
            System.out.println("4 Remove");
            System.out.println("5 DemoNull");
            System.out.println("6 Exit");
            try {
                int ch = Integer.parseInt(sc.nextLine());
                if (ch == 6) break;
                if (ch == 1) {
                    String sId = sc.nextLine();
                    String name = sc.nextLine();
                    if (!m.validId(sId) || !m.validName(name)) System.out.println("Invalid");
                    else m.add(Integer.parseInt(sId), name);
                } else if (ch == 2) {
                    m.displayAll();
                } else if (ch == 3) {
                    int id = Integer.parseInt(sc.nextLine());
                    m.search(id);
                } else if (ch == 4) {
                    int id = Integer.parseInt(sc.nextLine());
                    m.remove(id);
                } else if (ch == 5) {
                    m.demoNullSupport();
                } else {
                    System.out.println("Invalid");
                }
            } catch (Exception e) {
                System.out.println("Invalid");
            }
        }
    }
}