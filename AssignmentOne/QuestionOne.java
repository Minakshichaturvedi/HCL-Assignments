class QuestionOne {
    // Addition
    static int add(int a, int b) { return a + b; }
    // Subtraction
    static int subtract(int a, int b) { return a - b; }
    // Multiplication
    static int multiply(int a, int b) { return a * b; }
    // Division
    static int divide(int a, int b) { return a / b; }
    // Remainder
    static int remainder(int a, int b) { return a % b; }
    // Square
    static int square(int a) { return a * a; }
    // Cube
    static int cube(int a) { return a * a * a; }
    // Absolute
    static int absolute(int a) { return Math.abs(a); }

    public static void main(String[] args) {
        System.out.println("Addition: " + add(10, 5));
        System.out.println("Subtraction: " + subtract(10, 5));
        System.out.println("Multiplication: " + multiply(10, 5));
        System.out.println("Division: " + divide(10, 5));
        System.out.println("Remainder: " + remainder(10, 5));
        System.out.println("Square: " + square(5));
        System.out.println("Cube: " + cube(3));
        System.out.println("Absolute: " + absolute(-10));
    }
}