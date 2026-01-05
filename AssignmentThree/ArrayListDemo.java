import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> a1 = new ArrayList<>();
        ArrayList<String> a2 = new ArrayList<>(20);
        ArrayList<String> a3 = new ArrayList<>(Arrays.asList("A","B","C"));

        a1.add("One");
        a1.add("Two");
        a1.add(1,"Inserted");
        a1.addAll(a3);
        System.out.println(a1.get(2));
        a1.set(2,"Changed");
        System.out.println(a1.contains("Two"));
        System.out.println(a1.indexOf("Two"));
        System.out.println(a1.lastIndexOf("Two"));
        a1.remove("Two");
        a1.remove(0);
        a1.removeAll(a3);
        a1.add("X"); a1.add("Y"); a1.add("Z");
        System.out.println(a1.size());
        System.out.println(a1.isEmpty());
        a1.clear();
        System.out.println(a1);
    }
}