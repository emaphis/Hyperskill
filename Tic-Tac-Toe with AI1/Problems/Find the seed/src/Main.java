import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt(); // number of random numbers
        int k   = scanner.nextInt();
        int minSeed = a;
        int min = Integer.MAX_VALUE;

        for (int seed = a; seed <= b; seed++) {
            Random random = new Random(seed);
            int maxRnd = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                int nextRnd = random.nextInt(k);
                maxRnd = Math.max(maxRnd, nextRnd);
            }

            if (maxRnd < min) {
                min = maxRnd;
                minSeed = seed;
            }
        }

        System.out.println(minSeed);
        System.out.println(min);
    }
}