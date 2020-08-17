import java.util.Scanner;

public class Main {

    public static double pow(double a, long n) {
        // write your code here
        double ret;
        if (n == 0L) {
            return 1L;
        } else if (n == 1L) {
            return a;
        } else {
            ret = pow(a, n / 2L);
            ret = ret * ret;
            if (n % 2L == 0L) {
                return ret;
            } else {
                return a * ret;
            }
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final double a = Double.parseDouble(scanner.nextLine());
        final int n = Integer.parseInt(scanner.nextLine());
        System.out.println(pow(a, n));
    }
}