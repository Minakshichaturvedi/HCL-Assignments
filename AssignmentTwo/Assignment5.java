import java.util.*;
import java.util.regex.*;

interface UniOps {
    void add(String id, String name, String course, int marks);
    void display();
    void remove(String id);
    void search(String id);
    void sortByMarks();
    TreeMap<String, Integer> convertToTree();
    Map<String, Integer> countByCourse();
    Set<String> uniqueCourses();
}

class UniStudent {
    String id;
    String name;
    String course;
    int marks;
    UniStudent(String i, String n, String c, int m) { id = i; name = n; course = c; marks = m; }
    public String toString() { return id + " " + name + " " + course + " " + marks; }
}

class UniversityManager implements UniOps {
    ArrayList<UniStudent> list = new ArrayList<>();
    Vector<UniStudent> vector = new Vector<>();
    Stack<UniStudent> stack = new Stack<>();
    HashMap<String, UniStudent> map = new HashMap<>();
    Hashtable<String, UniStudent> table = new Hashtable<>();
    TreeMap<String, UniStudent> tree = new TreeMap<>();
    Set<String> courseSet = new HashSet<>();

    boolean validId(String s) {
        return Pattern.matches("^[A-Z]{2}[0-9]{4}$", s);
    }
    boolean validName(String s) {
        return Pattern.matches("^[A-Za-z ]{2,40}$", s);
    }
    boolean validCourse(String s) {
        return Pattern.matches("^[A-Za-z ]{2,30}$", s);
    }
    boolean validMarks(String s) {
        return Pattern.matches("^[0-9]{1,3}$", s);
    }

    public void add(String id, String name, String course, int marks) {
        UniStudent u = new UniStudent(id, name, course, marks);
        if (map.containsKey(id)) return;
        list.add(u);
        vector.add(u);
        stack.push(u);
        map.put(id, u);
        table.put(id, u);
        tree.put(id, u);
        courseSet.add(course);
    }

    public void display() {
        for (UniStudent u : list) System.out.println(u);
    }

    public void remove(String id) {
        UniStudent u = map.remove(id);
        table.remove(id);
        tree.remove(id);
        if (u == null) return;
        list.removeIf(x -> x.id.equals(id));
        vector.removeIf(x -> x.id.equals(id));
        stack.removeIf(x -> x.id.equals(id));
    }

    public void search(String id) {
        UniStudent u = map.get(id);
        System.out.println(u == null ? "Not Found" : u);
    }

    public void sortByMarks() {
        List<UniStudent> cp = new ArrayList<>(list);
        cp.sort(Comparator.comparingInt(x -> x.marks));
        for (UniStudent u : cp) System.out.println(u);
    }

    public TreeMap<String, Integer> convertToTree() {
        TreeMap<String, Integer> t = new TreeMap<>();
        for (UniStudent u : list) t.put(u.id, u.marks);
        return t;
    }

    public Map<String, Integer> countByCourse() {
        Map<String, Integer> c = new HashMap<>();
        for (UniStudent u : list) c.put(u.course, c.getOrDefault(u.course, 0) + 1);
        return c;
    }

    public Set<String> uniqueCourses() {
        return new HashSet<>(courseSet);
    }
}

public class Assignment5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UniversityManager m = new UniversityManager();
        while (true) {
            System.out.println("1 Add");
            System.out.println("2 Display");
            System.out.println("3 Remove");
            System.out.println("4 Search");
            System.out.println("5 SortByMarks");
            System.out.println("6 ConvertHashMapToTreeMap");
            System.out.println("7 CountCourseWise");
            System.out.println("8 ShowUniqueCourses");
            System.out.println("9 Exit");
            try {
                int ch = Integer.parseInt(sc.nextLine());
                if (ch == 9) break;
                if (ch == 1) {
                    String id = sc.nextLine();
                    String name = sc.nextLine();
                    String course = sc.nextLine();
                    String sMarks = sc.nextLine();
                    if (!m.validId(id) || !m.validName(name) || !m.validCourse(course) || !m.validMarks(sMarks)) System.out.println("Invalid");
                    else m.add(id, name, course, Integer.parseInt(sMarks));
                } else if (ch == 2) {
                    m.display();
                } else if (ch == 3) {
                    String id = sc.nextLine();
                    m.remove(id);
                } else if (ch == 4) {
                    String id = sc.nextLine();
                    m.search(id);
                } else if (ch == 5) {
                    m.sortByMarks();
                } else if (ch == 6) {
                    TreeMap<String, Integer> t = m.convertToTree();
                    for (Map.Entry<String, Integer> e : t.entrySet()) System.out.println(e.getKey() + " " + e.getValue());
                } else if (ch == 7) {
                    Map<String, Integer> c = m.countByCourse();
                    for (Map.Entry<String, Integer> e : c.entrySet()) System.out.println(e.getKey() + " " + e.getValue());
                } else if (ch == 8) {
                    Set<String> s = m.uniqueCourses();
                    for (String x : s)
                         System.out.println(x);
                } else {
                    System.out.println("Invalid");
                }
            } catch (Exception e) {
                System.out.println("Invalid");
            }
        }
    }
}