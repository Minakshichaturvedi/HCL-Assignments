import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer,String> h1 = new HashMap<>();
        HashMap<Integer,String> h2 = new HashMap<>(20);
        HashMap<Integer,String> h3 = new HashMap<>(20,0.75f);
        HashMap<Integer,String> h4 = new HashMap<>(Map.of(1,"A",2,"B"));

        h1.put(1,"One");
        h1.put(2,"Two");
        h1.putIfAbsent(3,"Three");
        h1.putAll(h4);
        System.out.println(h1.get(2));
        System.out.println(h1.containsKey(1));
        System.out.println(h1.containsValue("Two"));
        h1.replace(2,"Replaced");
        h1.remove(3);
        h1.remove(1,"One");
        System.out.println(h1.size());
        System.out.println(h1.isEmpty());
        System.out.println(h1.keySet());
        System.out.println(h1.values());
        System.out.println(h1.entrySet());
        h1.clear();
        System.out.println(h1);
    }
}