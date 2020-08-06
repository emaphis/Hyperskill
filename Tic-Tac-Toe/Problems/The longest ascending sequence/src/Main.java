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

        int currentLen = 1;
        int maxLen = 1;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > numbers[i - 1]) {
                currentLen++;
                if (maxLen < currentLen) {
                    maxLen = currentLen;
                }
            } else {
                currentLen = 1;
            }
        }
        System.out.println(maxLen);
    }
}