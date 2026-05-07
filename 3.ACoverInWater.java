import java.util.Scanner;

public class ACoverInWater {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of test cases
        int t = sc.nextInt();

        while (t-- > 0) {

            // Length of string
            int n = sc.nextInt();

            // Input string
            String s = sc.next();

            // Count total empty cells
            int dots = 0;

            // Flag to check if "..." exists
            boolean found = false;

            // Traverse string
            for (int i = 0; i < n; i++) {

                // Count empty cells
                if (s.charAt(i) == '.') {
                    dots++;
                }
            }

            // Check for 3 consecutive dots
            for (int i = 0; i < n - 2; i++) {

                if (s.charAt(i) == '.'
                        && s.charAt(i + 1) == '.'
                        && s.charAt(i + 2) == '.') {

                    found = true;
                    break;
                }
            }

            /*
             If any "..." exists,
             answer is always 2

             Otherwise,
             answer = total dots
            */
            if (found) {
                System.out.println(2);
            } else {
                System.out.println(dots);
            }
        }

        sc.close();
    }
}
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of test cases
        int t = sc.nextInt();

        // Process each test case
        while (t-- > 0) {

            // Read integer n
            int n = sc.nextInt();

            /*
             If n is divisible by 3,
             Vanya cannot make it divisible
             after adding or subtracting 1.

             So Vova wins.

             Otherwise,
             Vanya can make it divisible by 3
             in one move.
            */

            if (n % 3 == 0) {

                System.out.println("Second");

            } else {

                System.out.println("First");
            }
        }

        sc.close();
    }
}
