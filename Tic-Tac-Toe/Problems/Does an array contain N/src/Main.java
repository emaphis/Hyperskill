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

        boolean ret = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == n) {
                ret = true;
                break;
            }
        }

        System.out.println(ret);
    }
}