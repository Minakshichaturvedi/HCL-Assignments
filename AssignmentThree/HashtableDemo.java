import java.util.*;

public class HashtableDemo {
    public static void main(String[] args) {
        Hashtable<Integer,String> t1 = new Hashtable<>();
        Hashtable<Integer,String> t2 = new Hashtable<>(20);
        Hashtable<Integer,String> t3 = new Hashtable<>(20,0.75f);
        Hashtable<Integer,String> t4 = new Hashtable<>(Map.of(1,"A",2,"B"));

        t1.put(1,"One");
        t1.put(2,"Two");
        t1.putIfAbsent(3,"Three");
        t1.putAll(t4);
        System.out.println(t1.get(2));
        System.out.println(t1.containsKey(1));
        System.out.println(t1.containsValue("Two"));
        t1.replace(2,"Replaced");
        t1.remove(3);
        t1.remove(1,"One");
        System.out.println(t1.size());
        System.out.println(t1.isEmpty());
        System.out.println(t1.keys());
        System.out.println(t1.elements());
        System.out.println(t1.entrySet());
        t1.clear();
        System.out.println(t1);
    }
}