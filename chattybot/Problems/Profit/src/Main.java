import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        double m = scanner.nextInt(); // money
        double p = scanner.nextInt(); // percent
        double k = scanner.nextInt(); // goal
        int years = 0;

        while (m < k) {
            years++;
            m = m + m * p / 100.0;
        //    System.out.println(m);
        }
        System.out.println(years);
    }
}