import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int len = scanner.nextInt();
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = scanner.nextInt();
        }

        int temp = a[a.length - 1];
        for (int i = a.length - 1; i > 0; i--) {
            a[i] = a[i - 1];
        }
        a[0] = temp;

        for (int num: a) {
            System.out.print(num + " ");
        }
    }
}