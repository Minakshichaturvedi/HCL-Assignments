import java.util.*;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer,String> tr1 = new TreeMap<>();
        TreeMap<Integer,String> tr2 = new TreeMap<>(Comparator.reverseOrder());
        TreeMap<Integer,String> tr3 = new TreeMap<>(Map.of(1,"A",2,"B"));

        tr1.put(1,"One");
        tr1.put(2,"Two");
        tr1.putIfAbsent(3,"Three");
        tr1.putAll(tr3);
        System.out.println(tr1.get(2));
        System.out.println(tr1.containsKey(1));
        System.out.println(tr1.containsValue("Two"));
        tr1.replace(2,"Replaced");
        tr1.remove(3);
        tr1.remove(1,"One");
        System.out.println(tr1.size());
        System.out.println(tr1.isEmpty());
        System.out.println(tr1.firstKey());
        System.out.println(tr1.lastKey());
        System.out.println(tr1.headMap(2));
        System.out.println(tr1.tailMap(2));
        System.out.println(tr1.entrySet());
        tr1.clear();
        System.out.println(tr1);
    }
}