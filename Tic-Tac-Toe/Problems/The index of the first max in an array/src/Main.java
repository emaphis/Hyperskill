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

        int idx = 0;
        int max = numbers[idx];

        for (int i = 0; i < len; i++) {
            if (max < numbers[i]) {
                max = numbers[i];
                idx = i;
            }
        }

        System.out.println(idx);
    }
}