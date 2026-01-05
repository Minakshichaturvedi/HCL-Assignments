

import java.util.*;

class QuestionTwo {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[20]; // fixed size array
        int n = 0;               // current number of elements

        while (true) {
            System.out.println("Array Operations");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Linear Search");
            System.out.println("4. Binary Search");
            System.out.println("5. Find Maximum");
            System.out.println("6. Count Even/Odd");
            System.out.println("7. Insertion Sort");
            System.out.println("8. Display Array");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: // Insert
                    if (n == arr.length) {
                        System.out.println("Array is full.");
                    } else {
                        System.out.print("Enter element: ");
                        arr[n++] = sc.nextInt();
                        System.out.println("Element inserted.");
                    }
                    break;

                case 2: // Delete
                    if (n == 0) {
                        System.out.println("Array is empty.");
                    } else {
                        System.out.print("Enter position (0-based): ");
                        int pos = sc.nextInt();
                        if (pos < 0 || pos >= n) {
                            System.out.println("Invalid position!");
                        } else {
                            for (int i = pos; i < n - 1; i++) {
                                arr[i] = arr[i + 1];
                            }
                            n--;
                            System.out.println("Element deleted.");
                        }
                    }
                    break;

                case 3: // Linear Search
                    if (n == 0) {
                        System.out.println("Array is empty.");
                    } else {
                        System.out.print("Enter element: ");
                        int key = sc.nextInt();
                        boolean found = false;
                        for (int i = 0; i < n; i++) {
                            if (arr[i] == key) {
                                System.out.println("Found at position " + i);
                                found = true;
                                break;
                            }
                        }
                        if (!found) System.out.println("Not Found");
                    }
                    break;

                case 4: // Binary Search
                    if (n == 0) {
                        System.out.println("Array is empty");
                    } else {
                        Arrays.sort(arr, 0, n); 
                        System.out.print("Enter element: ");
                        int key = sc.nextInt();
                        int idx = Arrays.binarySearch(arr, 0, n, key);
                        System.out.println(idx >= 0 ? "Found at position " + idx : "Not Found");
                    }
                    break;

                case 5: // Max
                    if (n == 0) {
                        System.out.println("Array is empty!");
                    } else {
                        int max = arr[0];
                        for (int i = 1; i < n; i++) {
                            if (arr[i] > max) max = arr[i];
                        }
                        System.out.println("Maximum value = " + max);
                    }
                    break;

                case 6: // Even/Odd
                    if (n == 0) {
                        System.out.println("Array is empty!");
                    } else {
                        int even = 0, odd = 0;
                        for (int i = 0; i < n; i++) {
                            if (arr[i] % 2 == 0) even++;
                            else odd++;
                        }
                        System.out.println("Even count = " + even + ", Odd count = " + odd);
                    }
                    break;

                case 7: // Insertion Sort
                    if (n == 0) {
                        System.out.println("Array is empty!");
                    } else {
                        for (int i = 1; i < n; i++) {
                            int temp = arr[i];
                            int j = i - 1;
                            while (j >= 0 && arr[j] > temp) {
                                arr[j + 1] = arr[j];
                                j--;
                            }
                            arr[j + 1] = temp;
                        }
                        System.out.println("Array sorted successfully!");
                    }
                    break;

                case 8: // Display Array
                    if (n == 0) {
                        System.out.println("Array is empty!");
                    } else {
                        System.out.println("Current Array: " + Arrays.toString(Arrays.copyOf(arr, n)));
                    }
                    break;

                case 9: // Exit
                    System.out.println("Exiting program. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}