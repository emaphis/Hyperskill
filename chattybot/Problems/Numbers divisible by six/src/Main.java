import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int num = scanner.nextInt();

        for (int i = 0; i < num; i++) {
            int x = scanner.nextInt();
            if (x % 6 == 0) {
                sum += x;
            }
        }

        System.out.println(sum);
    }
}