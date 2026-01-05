import java.util.*;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<Integer> v1 = new Vector<>();
        Vector<Integer> v2 = new Vector<>(10);
        Vector<Integer> v3 = new Vector<>(Arrays.asList(1,2,3));

        v1.add(10);
        v1.add(20);
        v1.add(1,15);
        v1.addAll(v3);
        System.out.println(v1.get(2));
        v1.set(2,99);
        System.out.println(v1.contains(20));
        System.out.println(v1.indexOf(20));
        System.out.println(v1.lastIndexOf(20));
        v1.remove(2);
        v1.remove((Integer)20);
        v1.removeAll(v3);
        System.out.println(v1.size());
        System.out.println(v1.isEmpty());
        v1.clear();
        System.out.println(v1);
    }
}