import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        int k = scanner.nextInt();  // starting seed.
        int n = scanner.nextInt();  // number of gaussians to generate
        double m = scanner.nextDouble();  // number to test against

        boolean found = false;
        int seed = k;
        while (!found) {
            Random rand = new Random(seed);
            for (int i = 0; i < n; i++) {
                double gauss = rand.nextGaussian();
                if (gauss >= m) {
                    found = false;
                    break;
                }
                found = true;
            }
            seed++;
        }

        System.out.println(seed - 1);
    }
}