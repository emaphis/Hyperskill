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

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length - 1; i++) {
            int num = numbers[i] * numbers[i + 1];
            if (num > max) {
                max = num;
            }
        }

        System.out.println(max);
    }
}