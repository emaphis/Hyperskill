import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);

        int len = scan.nextInt();
        int[] numbers = new int[len];
        for (int i = 0; i < len; i++) {
            numbers[i] = scan.nextInt();
        }

        int count = 0;
        for (int i = 0; i < numbers.length - 2; i++) {
            if (triple(numbers[i], numbers[i + 1], numbers[i + 2])) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean triple(int m, int n, int o) {
        return m == n - 1 && n == o - 1;
    }
}