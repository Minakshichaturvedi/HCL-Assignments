
import java.util.*;
class QuestionFour {
    public static void main(String[] args) {
        String s = "Hello Java";
        System.out.println("Length: " + s.length());
        System.out.println("isEmpty: " + s.isEmpty());
        System.out.println("charAt(1): " + s.charAt(1));
        System.out.println("toString: " + s.toString());
        System.out.println("equals: " + s.equals("Hello Java"));
        System.out.println("compareTo: " + s.compareTo("Hello"));
        System.out.println("contains: " + s.contains("Java"));
        System.out.println("indexOf: " + s.indexOf("Java"));
        System.out.println("lastIndexOf: " + s.lastIndexOf("a"));
        System.out.println("startsWith: " + s.startsWith("Hello"));
        System.out.println("endsWith: " + s.endsWith("Java"));
        System.out.println("matches: " + s.matches("Hello.*"));
        System.out.println("substring: " + s.substring(6));
        System.out.println("toLowerCase: " + s.toLowerCase());
        System.out.println("trim: " + "  Hi  ".trim());
        System.out.println("replace: " + s.replace("Java","World"));
        String[] parts = s.split(" ");
        System.out.println("split: " + Arrays.toString(parts));
        System.out.println("join: " + String.join("-", parts));
        System.out.println("valueOf: " + String.valueOf(123));
    }
}