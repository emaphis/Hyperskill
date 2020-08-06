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
        int n = scan.nextInt();
        int m = scan.nextInt();

        boolean ret = true;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == m && numbers[i + 1] == n) {
                ret = false;
                break;
            }
            if (numbers[i] == n && numbers[i + 1] == m) {
                ret = false;
                break;
            }
        }

        System.out.println(ret);
    }
}