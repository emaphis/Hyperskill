import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        int num = 999;
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        while (num != 0) {
            num = scanner.nextInt();
            count++;
        }
        System.out.println(count - 1);
    }
}